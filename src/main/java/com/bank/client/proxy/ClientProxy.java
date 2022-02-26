package com.bank.client.proxy;

import org.springframework.web.reactive.function.client.WebClient;

import com.bank.client.model.dao.Credit;

import reactor.core.publisher.Flux;

public class ClientProxy {
	
	private final WebClient.Builder webClientBuilder = WebClient.builder();
	
	//get credits by id client
	public Flux<Credit> getCredits(String idClient){
		return webClientBuilder.build()
								.get()
								.uri("http://localhost:8090/credit/allByClient/{id}", idClient)
								.retrieve()
								.bodyToFlux(Credit.class);
	}

}
