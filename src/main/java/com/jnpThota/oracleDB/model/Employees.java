package com.jnpThota.oracleDB.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "EMPLOYEES")
public class Employees {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EMPLID", nullable = false, unique = true, precision = 38, scale = 0)
    private Long empId;
    
    @Column(name = "EMPNAME", length = 100, nullable = false)
    private String empName;
    
    @Column(name = "DEPARTMENT", length = 50)
    private String department;
    
    @Column(name = "AGE", precision = 38, scale = 0)
    private Integer age;
    
    @Column(name = "EXPERIENCE", precision = 38, scale = 0)
    private Integer experience;
    
    @Column(name = "SALARY", precision = 10, scale = 2)
    private BigDecimal salary;
    
    // Getters and Setters
    public Long getEmpId() {
        return empId;
    }

    public void setEmpId(Long empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getExperience() {
        return experience;
    }

    public void setExperience(Integer experience) {
        this.experience = experience;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }
}
