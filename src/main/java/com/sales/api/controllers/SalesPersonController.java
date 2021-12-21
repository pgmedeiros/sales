package com.sales.api.controllers;

import com.sales.api.entities.SalesPerson;
import com.sales.api.services.SalesPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class SalesPersonController {

    @Autowired
    SalesPersonService salesPersonService;

    @GetMapping("/salesperson/{id}")
    public Optional<SalesPerson> findById(@PathVariable Long id){
        Optional<SalesPerson> salesPerson = salesPersonService.getSalesPerson(id);
        System.out.println(salesPerson.get().getName());
        return salesPerson;
    }




}
