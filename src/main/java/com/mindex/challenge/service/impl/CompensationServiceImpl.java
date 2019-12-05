package com.mindex.challenge.service.impl;

import com.mindex.challenge.dao.*;
import com.mindex.challenge.data.*;
import com.mindex.challenge.service.CompensationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class CompensationServiceImpl implements CompensationService {

    private static final Logger LOG = LoggerFactory.getLogger(CompensationServiceImpl.class);

    @Autowired
    private CompensationRepository compensationRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Compensation createCompensation(Compensation compensation) {
        LOG.debug("Adding compensation [{}]", compensation);

        compensationRepository.insert(compensation);
        return compensation;
    }

//    @Override
//    public Compensation update(Compensation compensation) throws ParseException {
//        LOG.debug("Updating compensation [{}]", compensation);
//        Compensation oldCompensation = compensationRepository.findByEmployee(compensation.getEmployee());
//
//        //modify and update with save()
//        LOG.debug("salary {} ", oldCompensation.getSalary());
//        LOG.debug("salary {} ", compensation.getSalary());
////        oldCompensation.setSalary(compensation.getSalary());
////        LOG.debug("updated salary {} ", oldCompensation.getSalary());
////        DateFormat readFormat = new SimpleDateFormat( "E MMM dd HH:mm:ss Z yyyy");
////        DateFormat writeFormat = new SimpleDateFormat( "yyyy/MM/dd HH:mm:ss");
////        Date date = null;
////        try {
////            date = readFormat.parse( compensation.getEffectiveDate() );
////        } catch ( ParseException e ) {
////            e.printStackTrace();
////        }
////
////        String formattedDate = "";
////        if( date != null ) {
////            formattedDate = writeFormat.format( date );
////        }
////
////        oldCompensation.setEffectiveDate(formattedDate);
//        compensationRepository.save(oldCompensation);
//        LOG.info("Updating compensation {}", oldCompensation);
//        return oldCompensation;
//    }

    @Override
    public Compensation getCompensation(String id){
        Employee employee = employeeRepository.findByEmployeeId(id);
        Compensation compensation;
        compensation = compensationRepository.findByEmployee(employee);
        if (compensation== null) {
            throw new RuntimeException("There is no compensation records for employee : " + id);
        }

        return compensation;

    }
}
