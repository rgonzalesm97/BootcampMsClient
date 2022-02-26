package com.bank.client.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.client.model.dao.Client;
import com.bank.client.model.dao.Credit;
import com.bank.client.proxy.ClientProxy;
import com.bank.client.repository.ClientRepository;
import com.bank.client.service.ClientService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ClientServiceImpl implements ClientService{
	
	@Autowired
	private ClientRepository clientRepo;
	
	private ClientProxy clientProxy = new ClientProxy();

	@Override
	public Flux<Client> findAll() {
		return clientRepo.findAll();
	}

	@Override
	public Mono<Client> findById(String id) {
		return clientRepo.findById(id);
	}
	
	@Override
	public Mono<Client> save(Client client) {
		return checkType(client).flatMap(this::checkProfile)
								.flatMap(clientRepo::save); 
				
	}

	@Override
	public void delete(String id) {
		clientRepo.deleteById(id).subscribe();
	}
	
	//CLIENT UTIL METHODS
	public Mono<Client> checkType(Client client){
		List<String> types = new ArrayList<String>();
		types.add("personal");
		types.add("business");
		
		return types.contains(client.getType()) ? Mono.just(client)
				 								: Mono.error(() -> new IllegalArgumentException("Invalid Client type"));
		
	}
	
	public Mono<Client> checkProfile(Client client){
		
		switch (client.getProfile()) {
		case "VIP":
			if(client.getType().equals("business")) return Mono.error(() -> new IllegalArgumentException("Invalid Client profile, business client can't have VIP profile"));
		case "PYME":
			if(client.getType().equals("personal")) return Mono.error(() -> new IllegalArgumentException("Invalid Client profile, personal client can't have PYME profile"));
			return checkIfCreditCard(client);
		case "DEFAULT":
			return Mono.just(client);
		default:
			return Mono.error(() -> new IllegalArgumentException("Invalid Client profile"));
		}
	}
	
	public Mono<Client> checkIfCreditCard(Client client){
		return clientProxy.getCredits(client.getId())
						  .filter(resp->resp.getTypeCredit().contains("credit card"))
						  .next()
						  .switchIfEmpty(Mono.just(new Credit()))
						  .flatMap(resp->{
							  if(resp.getId()!=null && resp.getTypeCredit().contains("credit card")) return Mono.just(client);
							  return Mono.error(() -> new IllegalArgumentException("Invalid Client profile, client doesn't have a credit card"));
						  });
	}
	
	

}
