package com.mindex.challenge.service;

import com.mindex.challenge.data.*;
public interface EmployeeService {
    Employee create(Employee employee);
    Employee read(String id);
    Employee update(Employee employee);
    Reporting getReportingStructure(String id);
}
