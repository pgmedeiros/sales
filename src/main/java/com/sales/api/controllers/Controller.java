package com.sales.api.controllers;

import com.sales.api.dto.IdDTO;
import com.sales.api.dto.DateDTO;
import com.sales.api.entities.Sales;
import com.sales.api.entities.SalesPerson;
import com.sales.api.repositories.SalesPersonRepository;
import com.sales.api.services.SalesPersonService;
import com.sales.api.services.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class Controller {

    @Autowired
    SalesService salesService;
    @Autowired
    SalesPersonService salesPersonService;

    @Autowired
    SalesPersonRepository salesRepository;

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

    @PostMapping("/average")
    public double findByRangeOfPersonId(@RequestBody List<IdDTO> idDTO){
        double sales = salesPersonService.findAverageValueOfSalesShouldReturnAveragePrice(idDTO);
        return sales;
    }

    @PostMapping("/newsale")
    public ResponseEntity newSale(@RequestBody Sales sale){
        salesService.save(sale);
        return new ResponseEntity(HttpStatus.OK);
    }





}
