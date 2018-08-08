package com.mykescraft.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Orders {

	@GeneratedValue
	@Id
	private Long id;

	@ManyToMany
	private List<Product> orderedList;
		
	@Column
	private Date orderDate;
	
	@Column
	@Size(min=3, max=30)
	@NotBlank
    private String customerName;
 
    @Column
    @NotBlank
    private String customerAddress;
 
    @Column
    @Email
    @NotBlank
    private String customerEmail;
 
    @Column
    @NotBlank
    private String customerPhone;
	
	public List<Product> getOrderedList() {
		return orderedList;
	}

	public void setOrderedList(List<Product> orderedList) {
		this.orderedList = orderedList;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public String getCustomerPhone() {
		return customerPhone;
	}

	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}

	public Orders() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

		
	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	
	

}
