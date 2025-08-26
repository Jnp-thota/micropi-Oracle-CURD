package com.jnpThota.oracleDB.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jnpThota.oracleDB.model.Employees;
//import com.jnpThota.oracleDB.repository.EmployeeRepository;

@Service
public class EmployeeService {
    
//    @Autowired
//    private EmployeeRepository repo;

    List<Employees> employeesDB = new ArrayList<>();
    public List<Employees> employeesList() {
          return employeesDB;
//        return repo.findAll();
    }
    
    public boolean saveEmployee(Employees employee) {
        try {
            employeesDB.add(employee);
        }catch (Exception e){
            return false;
        }
        return true;
    }

    public Employees workerData(Long id) {

        for(Employees employee : employeesDB){
            if(employee.getEmpId().equals(id)){
                return employee;
            }
        }
        return null;
//        Optional<Employees> result = repo.findById(id);
//        return result.orElse(null);
    }
    
    public boolean removeEmployee(Long id) {
        for(Employees employee : employeesDB){
            if(employee.getEmpId().equals(id)){
                employeesDB.remove(employee);
                return true;
            }
        }
        return false;
//        repo.deleteById(id);
    }
}
