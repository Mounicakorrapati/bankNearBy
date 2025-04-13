package com.example.bankService.service;

import com.example.bankService.model.Bank;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class BankService {

    private final RestTemplate restTemplate;
    private final String mapServiceUrl;

    public BankService(RestTemplate restTemplate, @Value("${mapservice.url}") String mapServiceUrl) {
        this.restTemplate = restTemplate;
        this.mapServiceUrl = mapServiceUrl;
    }

    // Method to call MapService and get the banks near a zipcode within a certain radius
    public List<Bank> findBanksByZipcode(String zipcode) {
        String url = mapServiceUrl + "/maps?zipcode=" + zipcode;  
      
       System.out.println("Requesting URL: " + url);

        List<Bank> banks = restTemplate.exchange(
                url,
                org.springframework.http.HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Bank>>() {}
        ).getBody();
        
        // Log the response to verify the data
        System.out.println("Received response: " + banks);
        
        return banks;
    }
}
