package org.example.models;

import org.example.config.CompanyMessageSettings;

import java.util.*;

public class Company {
    private String name;
    private List<Employee> employees = new ArrayList<>();
    private CompanyMessageSettings settings;

    public Company(String name, CompanyMessageSettings settings) {
        this.name = name;
        this.settings = settings;
    }

    public void addEmployee(Employee e) {
        employees.add(e);
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public CompanyMessageSettings getSettings() {
        return settings;
    }

    public String getName() {
        return name;
    }

}
