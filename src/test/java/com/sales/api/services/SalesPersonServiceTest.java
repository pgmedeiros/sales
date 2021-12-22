package com.sales.api.services;

import com.sales.api.entities.Sales;
import com.sales.api.entities.SalesPerson;
import com.sales.api.repositories.SalesPersonRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.*;

@ExtendWith(SpringExtension.class)
public class SalesPersonServiceTest {


    @InjectMocks
    SalesPersonService salesPersonService;
    @Mock
    SalesPersonRepository salesPersonRepository;
    @InjectMocks
    List<Sales> listOfSales = new ArrayList<>();

    SalesPerson salesPerson;
    Sales sales1;
    Sales sales2;

    @BeforeEach
    public void setup(){
        salesPerson = new SalesPerson();
        salesPerson.setId(1L);
        salesPerson.setName("pedro medeiros");
        sales1 = new Sales();
        sales1.setId(1L);
        sales1.setDate(LocalDate.parse("2001-01-01"));
        sales1.setValue(250.00);
        sales1.setSalesPerson(salesPerson);
        sales2 = new Sales();
        sales2.setId(2L);
        sales2.setDate(LocalDate.parse("2001-01-02"));
        sales2.setValue(350.00);
        sales2.setSalesPerson(salesPerson);
        listOfSales.add(sales1);
        listOfSales.add(sales2);

        Mockito.when(salesPersonRepository
                .getSalesByRangeOfDateAndSalesPersonId(anyString(), anyString(), anyLong()))
                .thenReturn(java.util.Optional.ofNullable(listOfSales));

    }







}
