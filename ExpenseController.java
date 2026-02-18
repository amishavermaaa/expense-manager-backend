package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.entity.Expenses;
import com.project.repository.ExpenseRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/expenses")
@RequiredArgsConstructor
public class ExpenseController { 
	
	@Autowired
	private ExpenseRepository expenseRepository;
    
	
	//Add Expenses
    @PostMapping
	public Expenses addExpense(@RequestBody Expenses expense) {
		return expenseRepository.save(expense);
	}
    
    
    //Get all Expenses
	@GetMapping
	public List<Expenses> getAllExpenses() {
		return expenseRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Expenses getExpenseById(@PathVariable Long id) {
		return expenseRepository.findById(id).orElseThrow(() -> new RuntimeException("Expense not found"));
	}
	
	
	@DeleteMapping("/{id}")
	public String deleteExpense(@PathVariable Long id) {
		expenseRepository.deleteById(id);
		return "Expense deleted successfully!";
	}
}
