package com.sales.api.controllers;

import com.sales.api.dto.DataDTO;
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

import java.util.ArrayList;
import java.util.List;

@RestController
public class Controller {

    @Autowired
    SalesService salesService;
    @Autowired
    SalesPersonService salesPersonService;


    @PostMapping("/data")
    public List<Sales> findByRangeOfDate(@RequestBody List<DateDTO> date){
        List<Sales> sales = salesService.findByDateRange(date.get(0).getDate(), date.get(1).getDate());
        return sales;
    }

    @PostMapping("/newsale")
    public ResponseEntity newSale(@RequestBody Sales sale){
        salesService.save(sale);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping("/data")
    public ArrayList<DataDTO> find(@RequestBody List<IdDTO> date){
        ArrayList<DataDTO> data = new ArrayList<>();
        data = salesPersonService.getData(date);
        return data;
    }





}
