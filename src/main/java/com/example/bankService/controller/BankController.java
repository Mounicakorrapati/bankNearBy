package com.example.bankService.controller;

import com.example.bankService.model.Bank;
import com.example.bankService.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/banks")
public class BankController {

    @Autowired
    private BankService bankService;

    @GetMapping
    public List<Bank> getBanksByZipcode(@RequestParam String zipcode) {
        return bankService.findBanksByZipcode(zipcode);
    }
}