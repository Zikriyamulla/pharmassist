package com.pharmassist.entity;

import java.time.LocalDateTime;

import com.pharmassist.enums.TransactionType;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;

@Entity
public class Transaction {
	private String transactionId;
	@Enumerated(EnumType.STRING)
	private TransactionType transactionType;
	private LocalDateTime dataTime;
	private int quantity;
	
	@OneToMany
	private Pharmacy pharmacy;
	@OneToMany
	private Medicine medicine;
	
	
	
	public Pharmacy getPharmacy() {
		return pharmacy;
	}
	public void setPharmacy(Pharmacy pharmacy) {
		this.pharmacy = pharmacy;
	}
	public Medicine getMedicine() {
		return medicine;
	}
	public void setMedicine(Medicine medicine) {
		this.medicine = medicine;
	}
	public String getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	public TransactionType getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(TransactionType transactionType) {
		this.transactionType = transactionType;
	}
	public LocalDateTime getDataTime() {
		return dataTime;
	}
	public void setDataTime(LocalDateTime dataTime) {
		this.dataTime = dataTime;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	

}
