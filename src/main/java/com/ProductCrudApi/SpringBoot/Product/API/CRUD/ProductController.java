package com.ProductCrudApi.SpringBoot.Product.API.CRUD;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ProductController {
	
	@Autowired
	SessionFactory sf;
	
	@PostMapping("api/product/{pid}/{name}/{price}")
	public Product Getproduct(@PathVariable int pid,@PathVariable String name,@PathVariable float price) {
		
		Session s=sf.openSession();
		Transaction t=s.beginTransaction();
		Product p=new Product(pid,name,price);
		s.save(p);
		t.commit();
		s.close();
		return p;
		
	}
   @GetMapping("api/products")
	public List<Product>all(){
	   Session s=sf.openSession();
	   Query query=s.createQuery("from Product");
	   List <Product> list=query.list();
		return list;
	
	}
   @GetMapping("api/product/{pid}")
	public Product GetSingleproduct(@PathVariable int pid) {
		
		Session s=sf.openSession();
		Transaction t=s.beginTransaction();
		Product p=s.get(Product.class, pid);
		s.save(p);
		t.commit();
		s.close();
		return p;
	
   }
   
   @PutMapping("api/product/{pid}/{price}")
	public Product updateproduct(@PathVariable int pid,@PathVariable float price) {
		
		Session s=sf.openSession();
		Transaction t=s.beginTransaction();
		Product p=s.get(Product.class, pid);
		p.setPrice(price);
	s.update(p);
		t.commit();
		s.close();
		return p;
		
	}
   @DeleteMapping("api/product/{pid}")
  	public Product deleteproduct(@PathVariable int pid) {
  		
  		Session s=sf.openSession();
  		Transaction t=s.beginTransaction();
  		Product p=s.get(Product.class, pid);
  	
  	s.delete(p);
  		t.commit();
  		s.close();
  		return p;
   
}
}