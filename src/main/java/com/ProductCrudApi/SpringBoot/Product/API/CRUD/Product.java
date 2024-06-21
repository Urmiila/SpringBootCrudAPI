package com.ProductCrudApi.SpringBoot.Product.API.CRUD;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Product {

	@Id
	private int pid;
	private String name ;
    private float price;
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product(int pid, String name, float price) {
		super();
		this.pid = pid;
		this.name = name;
		this.price = price;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Product [pid=" + pid + ", name=" + name + ", price=" + price + "]";
	}
    
	
}
