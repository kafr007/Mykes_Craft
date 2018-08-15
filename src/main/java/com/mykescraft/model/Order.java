package com.mykescraft.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name="orders")
public class Order {
	

	@GeneratedValue
	@Id
	private int id;
	
	@OneToOne
	private Customer customer;

	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE} , fetch = FetchType.LAZY)
    @JoinTable(name = "ORDERS_ACCESSORIES", joinColumns = {@JoinColumn(name = "ORDER_ID")},inverseJoinColumns = {@JoinColumn(name = "ACCESSORY_ID")})
    private Set<Accessory> accessories;
		
	@Column
	private Date orderDate;
	
	@Column
	private double amount;
	
    public Order(Date orderDate, Set<Accessory> boughtAccessories) {
    	this.orderDate=orderDate;
    	this.accessories = boughtAccessories;
    }

	
	public Order() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

		
	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public Set<Accessory> getAccessories() {
		return accessories;
	}

	public void setAccessories(Set<Accessory> accessories) {
		this.accessories = accessories;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
}
