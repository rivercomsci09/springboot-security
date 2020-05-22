package com.river.data;

import org.springframework.data.jpa.repository.JpaRepository;

import com.river.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
