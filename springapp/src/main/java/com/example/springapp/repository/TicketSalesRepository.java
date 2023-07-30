<<<<<<< HEAD

package com.example.springapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springapp.model.TicketSales;

public interface TicketSalesRepository extends JpaRepository<TicketSales, Long>
=======
package com.example.springapp.repository;

import com.example.springapp.model.TicketSales;


import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketSalesRepository extends JpaRepository<TicketSales,Long>
>>>>>>> cd20a07a8d17164e81677b15f295cacebc216f65
{

}
