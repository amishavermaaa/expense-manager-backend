package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.entity.Expenses;

public interface ExpenseRepository extends JpaRepository<Expenses, Long>{


}
