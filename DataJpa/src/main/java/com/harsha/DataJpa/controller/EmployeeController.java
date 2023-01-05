package com.harsha.DataJpa.controller;

import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.harsha.DataJpa.entity.Employee;



@RestController
public class EmployeeController {

	
	@Autowired
	com.harsha.DataJpa.repository.EmployeRepo employeRepo;
	@RequestMapping(method = RequestMethod.GET, value="/getEmployees")
	public void getAllEmployes()
	{
		List<Employee> allEmployes=employeRepo.findAll();
		System.out.println(allEmployes.size());
		allEmployes.forEach((e) -> {
		      System.out.print(e + ", ");
	    });
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/createEmployees")
	public void createEmployee()
	{
		Employee e=new Employee();
		e.setId(3);
		e.setName("Bhavana");
		JSONObject details=new JSONObject();
		details.put("Age", 25);
		details.put("Gender", "Female");
		
		
		e.setDetails(details.toString());

		JSONObject contact=new JSONObject();
		contact.put("Phno", 456789876);
		contact.put("Email", "sample@123");
		//e.setContact("array['{\"category_id\":2,\"net_amount\":120000}', '{\"category_id\":4,\"net_amount\":60000}']::json[]");

		employeRepo.save(e);
		//employeRepo.insertEmployee(4, "Sappu", "array['{\"category_id\":2,\"net_amount\":120000}', '{\"category_id\":4,\"net_amount\":60000}']::json[]");
	}
}
