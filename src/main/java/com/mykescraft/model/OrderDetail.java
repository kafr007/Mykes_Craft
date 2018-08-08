package com.mykescraft.model;

import javax.persistence.CascadeType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

public class OrderDetail {
	
	@Id @ManyToOne(cascade=CascadeType.PERSIST) Order order;
    @Id int id;
    @OneToOne(cascade=CascadeType.PERSIST) Product product;
    int quantity;
    double price;

}
