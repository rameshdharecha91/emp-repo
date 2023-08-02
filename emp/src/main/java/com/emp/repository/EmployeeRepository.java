package com.emp.repository;

import com.emp.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



/*
Repository layer
This repository to use for manage CRUD operation for employee table.
Operation will performed: CRUD(Create/Read/Update/Delete)
*/
@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
}
