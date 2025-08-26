package com.jnpThota.oracleDB.controller;


import java.util.List;

import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.jnpThota.oracleDB.model.Employees;
import com.jnpThota.oracleDB.service.EmployeeService;


@RestController
@RequestMapping("/v1/api")
public class workerController {
	@Autowired
	private EmployeeService service;

	@GetMapping("/liteworker")
	public List<Employees> liteWorker()
	{
		return service.employeesList();
	}

	@GetMapping("/worker/{emplID}")
	public Employees worker(@PathVariable("emplID") Long emplID){
		return service.workerData(emplID);

	}

	@PostMapping("/worker")
	public Employees addEmployee(@RequestBody Employees employee) {
		if(service.saveEmployee(employee)){
			return employee;
		}
		return null;
    }

	@DeleteMapping("/worker/{emplID}")
	public String deleteEmployee(@PathVariable("emplID") Long emplID) {
		if(service.removeEmployee(emplID)){
			return "Employee Sucessfully deleted";
		}
		return "Employee deletion Failed";
	}
	

}
