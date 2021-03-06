package com.mykescraft.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "customers")
public class Customer {

	
	@Id
	private String id;

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	@Column
	@Size(min = 3, max = 30)
	@NotBlank
	private String name;

	@Column
	@Email
	@NotBlank
	private String email;

	@Column
	@NotBlank
	private String customerAddress;

	@Column
    @NotBlank
	private String phoneNumber;
	
	@OneToOne(mappedBy="customer")
    private Order order;

	public Customer() {

	}
	
	

	public Customer(@Size(min = 3, max = 30) @NotBlank String name, @Email @NotBlank String email,
			@NotBlank String customerAddress, @NotBlank String phoneNumber) {
		super();
		this.name = name;
		this.email = email;
		this.customerAddress = customerAddress;
		this.phoneNumber = phoneNumber;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", email=" + email + ", customerAddress=" + customerAddress
				+ ", phoneNumber=" + phoneNumber + ", order=" + order + "]";
	}

}
