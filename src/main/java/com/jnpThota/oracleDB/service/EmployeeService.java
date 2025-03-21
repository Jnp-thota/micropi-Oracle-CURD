package com.jnpThota.oracleDB.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jnpThota.oracleDB.model.Employees;
import com.jnpThota.oracleDB.repository.EmployeeRepository;

@Service
public class EmployeeService {
    
    @Autowired
    private EmployeeRepository repo;
    
    public List<Employees> listAll() {
        return repo.findAll();
    }
    
    public void save(Employees employee) {
        repo.save(employee);
    }
    
    public Employees get(Long id) {
        Optional<Employees> result = repo.findById(id);
        return result.orElse(null);
    }
    
    public void delete(Long id) {
        repo.deleteById(id);
    }
}
