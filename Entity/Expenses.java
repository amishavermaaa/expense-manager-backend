package com.project.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "expenses")
@NoArgsConstructor
@AllArgsConstructor
public class Expenses {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String title;
	private Double amount;
	private String category;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	public Expenses() {}
	
	public Long getId() {
		return id;
	}
	
	public User getUser() {
		return user;
	}

	public String getTitle() {
		return title;
	}

	public String getCategory() {
		return category;
	}

	public Double getAmount() {
		return amount;
	}

	public void setTitle(String title) {
		this.title = title;
		
	}
	
	public void setUser(User user) {
		this.user = user;
		
	}
	
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	
	public void setCategory(String category) {
		this.category = category;
	}

}
