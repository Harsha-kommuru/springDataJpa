package com.harsha.DataJpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.harsha.DataJpa.entity.Employee;



@Repository
public interface EmployeRepo extends JpaRepository<Employee, Long>{

	@Query(value = "insert into public.employee (id, name, contact) VALUES (?1, ?2, ?3)", nativeQuery = true)
	public void insertEmployee(long id,String name,String contact);
}
