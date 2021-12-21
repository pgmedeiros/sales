package com.sales.api.services;

import com.sales.api.entities.SalesPerson;
import com.sales.api.repositories.SalesPersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SalesPersonService {

    @Autowired
    SalesPersonRepository salesPersonRepository;

    public void saveNewSalesPerson(SalesPerson salesPerson){
        salesPersonRepository.save(salesPerson);
    }

    public Optional<SalesPerson> getSalesPerson(Long id){
        Optional<SalesPerson> salesPersonOptional = salesPersonRepository.findById(id);
        return salesPersonOptional;
    }

}
