package com.mindex.challenge.controller;

import com.mindex.challenge.dao.CompensationRepository;
import com.mindex.challenge.data.Employee;
import com.mindex.challenge.data.Reporting;
import com.mindex.challenge.data.Compensation;
import com.mindex.challenge.service.CompensationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

@RestController
public class CompensationController {
    private static final Logger LOG = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    private CompensationService compensationService;

    @Autowired
    private CompensationRepository compensationRepository;

    @PostMapping("/compensation")
    public Compensation addCompensation(@RequestBody Compensation compensation) throws ParseException {
        LOG.debug("Received add compensation request create request for [{}]", compensation);
        if(compensationRepository.findByEmployee(compensation.getEmployee()) == null){
            LOG.debug("Adding compensation");
            return compensationService.createCompensation(compensation);
        }
        else {
            return compensationService.update(compensation);
        }
    }

    @GetMapping("/compensation/employee/{id}")
    public Compensation getCompensation(@PathVariable String id) {
        LOG.debug("Received employee create request for id [{}]", id);
        return compensationService.getCompensation(id);
    }
}
