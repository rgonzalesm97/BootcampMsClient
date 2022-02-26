package com.bank.client.model.dao;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
public class Credit {

	private String id;
    private String idClient;
    private String cardNumber;
    private String typeCredit;
    private String accountNumber;
    private Double balance;
    private Double credit;
    private Double debt;

}
