package com.sales.api.services;

import com.sales.api.entities.SalesPerson;
import com.sales.api.repositories.SalesPersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalesPersonService {

    @Autowired
    SalesPersonRepository salesPersonRepository;

    public void saveNewPerson(SalesPerson salesPerson){
        salesPersonRepository.save(salesPerson);
    }


}
