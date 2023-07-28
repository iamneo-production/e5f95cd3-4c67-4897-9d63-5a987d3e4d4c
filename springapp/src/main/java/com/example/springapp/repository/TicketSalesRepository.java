package com.example.springapp.repository;
import com.example.springapp.model.TicketSales;


import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketSalesRepository extends JpaRepository<TicketSales,Long>
{
    
}