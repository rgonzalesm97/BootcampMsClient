package com.bank.client.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.bank.client.model.dao.Client;


public class ClientFactory {
	
	static List<String> types = new ArrayList<String>();
	static {
		types.add("personal");
		types.add("business");
	}
	
	public static Optional<Client> validateClient(Client client){
		return Optional.ofNullable(types.contains(client.getType())?client:null);
	}
}
