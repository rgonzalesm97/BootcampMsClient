package com.bank.client.model.dao;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document("client")
public class Client{

	@Id
	private String id;
	private String name;
	private String type;
	private String profile;
	
}
