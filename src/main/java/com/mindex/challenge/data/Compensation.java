package com.mindex.challenge.data;
import java.text.DateFormat;
import java.util.*;
import java.text.*;
import org.springframework.format.annotation.DateTimeFormat;

public class Compensation {
    private Employee employee;
    private Integer salary;
    private Date effectiveDate;

    public Compensation() {
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public String getEffectiveDate() {
        return effectiveDate.toString();
    }

    public void setEffectiveDate(String effectiveDate) throws ParseException {
        this.effectiveDate = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").parse(effectiveDate);
        ;
    }
}
