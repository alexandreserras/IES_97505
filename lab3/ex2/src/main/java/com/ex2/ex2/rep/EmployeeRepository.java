package com.ex2.ex2.rep;

import com.ex2.ex2.model.*;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.*;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

    List<Employee> findByEmailId(String emailId);
}
