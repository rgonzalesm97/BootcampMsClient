package com.bank.client.model.dto;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document("clientes")
public class Client {

	@Id
	private String id;
	private String nombre;
	private String apellidos;
	private String razonSocial;
	private String tipo;
	private Object productos;
}
