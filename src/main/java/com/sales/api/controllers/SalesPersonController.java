package com.sales.api.controllers;

import com.sales.api.dto.DateDTO;
import com.sales.api.entities.Sales;
import com.sales.api.entities.SalesPerson;
import com.sales.api.services.SalesPersonService;
import com.sales.api.services.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
public class SalesPersonController {

    @Autowired
    SalesService salesService;
    @Autowired
    SalesPersonService salesPersonService;

    @GetMapping("/salesperson/{id}")
    public Optional<SalesPerson> findById(@PathVariable Long id){
        Optional<SalesPerson> salesPerson = salesPersonService.getSalesPerson(id);
        return salesPerson;
    }

    @PostMapping("/sales")
    public List<Sales> findByRangeOfDate(@RequestBody List<DateDTO> date){
        List<Sales> sales = salesService.findByDateRange(date.get(0).getDate(), date.get(1).getDate());
        return sales;
    }




}
