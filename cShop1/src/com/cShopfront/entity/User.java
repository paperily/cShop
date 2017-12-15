package com.cShopfront.entity;



import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.cShopfront.entity.Order;


@Entity
@Table(name="user")
public class User {
	@Id
	@GeneratedValue(generator="id")
	@GenericGenerator(name="id",strategy="native")
	private Integer id;
	@Column(name="name")
	private String name;
	@Column(name="password")
	private String password;
	@Column(name="email")
	private String email;
	private int state;
	@OneToMany(mappedBy="user", targetEntity=Order.class, 
	            cascade=CascadeType.ALL)
	private Set<Order> orderSet=new HashSet<Order>();
	public Integer getId() {
		return id;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<Order> getOrderSet() {
		return orderSet;
	}
	public void setOrderSet(Set<Order> orderSet) {
		this.orderSet = orderSet;
	}


	

}
