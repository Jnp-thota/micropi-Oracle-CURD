//package com.jnpThota.oracleDB.model;
//
//import jakarta.persistence.*;
//import java.math.BigDecimal;
//import java.util.List;
//
//@Entity
//@Table(name = "EMPLOYEES")
//public class Employees {
//    
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "EMPLID", nullable = false, unique = true, precision = 38, scale = 0)
//    private Long empId;
//    
//    @Column(name = "EMPNAME", length = 100, nullable = false)
//    private String empName;
//    
//    @Column(name = "DEPARTMENT", length = 50)
//    private String department;
//    
//    @Column(name = "AGE", precision = 38, scale = 0)
//    private Integer age;
//    
//    @Column(name = "EXPERIENCE", precision = 38, scale = 0)
//    private Integer experience;
//    
//    @Column(name = "SALARY", precision = 10, scale = 2)
//    private BigDecimal salary;
//    
//    // Getters and Setters
//    public Long getEmpId() {
//        return empId;
//    }
//
//    public void setEmpId(Long empId) {
//        this.empId = empId;
//    }
//
//    public String getEmpName() {
//        return empName;
//    }
//
//    public void setEmpName(String empName) {
//        this.empName = empName;
//    }
//
//    public String getDepartment() {
//        return department;
//    }
//
//    public void setDepartment(String department) {
//        this.department = department;
//    }
//
//    public Integer getAge() {
//        return age;
//    }
//
//    public void setAge(Integer age) {
//        this.age = age;
//    }
//
//    public Integer getExperience() {
//        return experience;
//    }
//
//    public void setExperience(Integer experience) {
//        this.experience = experience;
//    }
//
//    public BigDecimal getSalary() {
//        return salary;
//    }
//
//    public void setSalary(BigDecimal salary) {
//        this.salary = salary;
//    }
//}

//updated for jenkins test
//nothing

package com.jnpThota.oracleDB.model;

import java.math.BigDecimal;

public class Employees {

    private Long empId;
    private String empName;
    private String department;
    private Integer age;
    private Integer experience;
    private BigDecimal salary;

    // Default constructor
    public Employees() {
    }

    // Parameterized constructor
    public Employees(Long empId, String empName, String department, Integer age, Integer experience,
            BigDecimal salary) {
        this.empId = empId;
        this.empName = empName;
        this.department = department;
        this.age = age;
        this.experience = experience;
        this.salary = salary;
    }

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

    @Override
    public String toString() {
        return "Employees{" +
                "empId=" + empId +
                ", empName='" + empName + '\'' +
                ", department='" + department + '\'' +
                ", age=" + age +
                ", experience=" + experience +
                ", salary=" + salary +
                '}';
    }
}
