package com.mykescraft.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class Order {
  
  private String id;
  private Date orderDate;
  private int orderNum;
  private double amount;
  
  @NotBlank
  @Size(min = 3, max = 30)
  private String customerFullName;
  
  @NotBlank
  @Size(min = 3)
  private String customerAddress;
  
  @NotBlank
  @Email
  private String customerEmail;
  
  @NotBlank
  private String customerPhone;
  
  private List<Accessories> shoppingList;
  
  public Order() {
    
  }

  public Order(String id, Date orderDate, int orderNum, double amount, String customerFullName, String customerAddress,
      String customerEmail, String customerPhone, List<Accessories> shoppingList) {
    this.id = id;
    this.orderDate = orderDate;
    this.orderNum = orderNum;
    this.amount = amount;
    this.customerFullName = customerFullName;
    this.customerAddress = customerAddress;
    this.customerEmail = customerEmail;
    this.customerPhone = customerPhone;
    this.shoppingList = shoppingList;
    this.shoppingList = new ArrayList<Accessories>();
  }



  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Date getOrderDate() {
    return orderDate;
  }

  public void setOrderDate(Date orderDate) {
    this.orderDate = orderDate;
  }

  public int getOrderNum() {
    return orderNum;
  }

  public void setOrderNum(int orderNum) {
    this.orderNum = orderNum;
  }

  public double getAmount() {
    return amount;
  }

  public void setAmount(double amount) {
    this.amount = amount;
  }

  public String getCustomerFullName() {
    return customerFullName;
  }

  public void setCustomerFullName(String customerFullName) {
    this.customerFullName = customerFullName;
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

  public List<Accessories> getShoppingList() {
    return shoppingList;
  }

  public void setShoppingList(List<Accessories> shoppingList) {
    this.shoppingList = shoppingList;
  }
  
  
}
