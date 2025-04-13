package com.example.bankService.service;

import com.example.bankService.model.Bank;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class BankService {

    public List<Bank> findBanksByZipcode(String zipcode) {
        // Placeholder for calling Google Maps Service
        return Collections.emptyList();
    }
}
