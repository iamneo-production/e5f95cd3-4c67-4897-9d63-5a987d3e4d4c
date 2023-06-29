<<<<<<< HEAD
package com.example.springapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springapp.model.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment,Integer> {
=======
package com.example.springapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springapp.model.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment,Integer> {
>>>>>>> 465dbd60d2c9045a58b26d9bc1b8eac19eaca3ff
}