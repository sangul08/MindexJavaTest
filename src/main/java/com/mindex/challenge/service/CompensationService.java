package com.mindex.challenge.service;

import com.mindex.challenge.data.*;

import java.text.ParseException;

public interface CompensationService {
    Compensation createCompensation(Compensation compensation);
    Compensation update(Compensation compensation) throws ParseException;
    Compensation getCompensation(String id);
}