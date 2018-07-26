package com.thoughtworks.jpa.practices.one.to.n.controllers.dto;

import com.thoughtworks.jpa.practices.one.to.n.entities.Company;
import com.thoughtworks.jpa.practices.one.to.n.entities.Employee;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class CompanyDTO {
    private final Long id;
    private final String name;
    private final ZonedDateTime createDate;
    private final List<EmployeeDTO> employees;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ZonedDateTime getCreateDate() {
        return createDate;
    }

    public List<EmployeeDTO> getEmployees() {
        return employees;
    }

    public CompanyDTO(Company company) {
        this.id = company.getId();
        this.name = company.getName();
        this.createDate = company.getCreatedDate();
        this.employees = company.getEmployees().stream().map(employee -> new EmployeeDTO(employee)).collect(Collectors.toList());
    }
}
