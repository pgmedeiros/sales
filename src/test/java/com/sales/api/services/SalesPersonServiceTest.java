package com.sales.api.services;

import com.sales.api.entities.SalesPerson;
import com.sales.api.repositories.SalesPersonRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class SalesPersonServiceTest {


    @InjectMocks
    SalesPersonService salesPersonService;
    @Mock
    SalesPersonRepository salesPersonRepository;
    SalesPerson salesPerson;

    @BeforeEach
    public void setup(){
        salesPerson = new SalesPerson();
        salesPerson.setName("Vendedor X9");
    }


    @Test
    public void saveNewPersonShouldAddSalesPersonToDB(){
        salesPersonService.saveNewSalesPerson(salesPerson);
    }

}
