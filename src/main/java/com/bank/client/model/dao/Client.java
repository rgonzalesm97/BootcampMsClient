package com.bank.client.model.dao;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document("client")
public class Client implements Serializable{

	@Id
	private String id;
	private String name;
	private String type;
	private String profile;
	
	private static final long serialVersionUID = 1L;
}
