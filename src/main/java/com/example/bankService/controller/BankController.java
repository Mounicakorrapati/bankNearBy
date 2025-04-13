package com.example.bankService.controller;

import com.example.bankService.model.Bank;
import com.example.bankService.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/banks")
public class BankController {

    @Autowired
    private BankService bankService;

    // This endpoint will return a view with the list of banks in an HTML format
    @GetMapping
    public ResponseEntity<String> getBanksByZipcode(@RequestParam String zipcode) {
        List<Bank> banks = bankService.findBanksByZipcode(zipcode);
        
        // Format the response as a readable text
        StringBuilder response = new StringBuilder();
        response.append("Banks near zipcode ").append(zipcode).append(":\n\n");

        for (Bank bank : banks) {
            response.append("Name: ").append(bank.getName()).append("\n")
                    .append("Address: ").append(bank.getAddress()).append("\n")
                    .append("Latitude: ").append(bank.getLatitude()).append("\n")
                    .append("Longitude: ").append(bank.getLongitude()).append("\n\n");
        }
       return ResponseEntity.ok()
            .header("Content-Type", "text/plain")
            .body(response.toString());
    }
}
