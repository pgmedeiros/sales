package com.sales.api.services;

import com.sales.api.entities.Sales;
import com.sales.api.repositories.SalesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SalesService {

    @Autowired
    SalesRepository salesRepository;

    public List<Sales> findByDateRange(String initialDate, String finalDate){
        Optional<List<Sales>> sales = salesRepository.findByDateRange(initialDate, finalDate);
            return sales.get();
    }

    public void save(Sales sale){
        salesRepository.save(sale);
    }

}
