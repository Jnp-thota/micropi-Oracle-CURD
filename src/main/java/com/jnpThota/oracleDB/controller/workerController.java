package com.jnpThota.oracleDB.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jnpThota.oracleDB.model.Employees;
import com.jnpThota.oracleDB.service.EmployeeService;


@RestController
@RequestMapping("/api")
public class workerController {
	@Autowired
	private EmployeeService service;

	@GetMapping("/getEmployees")
	public List<Employees> viewHomePage()
	{
		return service.listAll();
	}
	

}
