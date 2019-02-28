package com.jk.testservice.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Product {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="prod_id")
    private long id;
     
    @Column(nullable = false)
    private String name;
    
    @ManyToMany(cascade=CascadeType.REMOVE)
    /*@JoinTable(name = "PRODUCT_SERVICE",  joinColumns = @JoinColumn(name = "prod_id"), 
    	inverseJoinColumns = @JoinColumn(name = "service_id"))
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)*/
    private List<Service> services;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Service> getServices() {
		return services;
	}
	public void setServices(List<Service> services) {
		this.services = services;
	}
	
}
