package com.sales.api.services;

import com.sales.api.entities.Sales;
import com.sales.api.entities.SalesPerson;
import com.sales.api.repositories.SalesRepository;
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
import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyString;

@ExtendWith(SpringExtension.class)
public class SalesServiceTest {

    @Mock
    private SalesRepository salesRepository;
    @InjectMocks
    private SalesService salesService;
    @InjectMocks
    private Sales sale1;
    @InjectMocks
    private Sales sale2;
    @InjectMocks
    private SalesPerson salesPerson;
    @InjectMocks
    private ArrayList<Sales> sales = new ArrayList<>();
    private Optional<List<Sales>> salesInOptional;

    @BeforeEach
    public void setup(){
        salesPerson.setId(1);
        salesPerson.setName("josefo");
        sale1.setId(1L);
        sale1.setValue(250.00);
        sale1.setDate(LocalDate.parse("2001-01-01"));
        sale1.setSalesPerson(salesPerson);
        sale2.setId(2L);
        sale2.setValue(300.00);
        sale1.setDate(LocalDate.parse("2001-01-01"));
        sale1.setSalesPerson(salesPerson);
        sales.add(sale1);
        sales.add(sale2);
        salesInOptional = Optional.ofNullable(sales);
        Mockito.when(salesRepository.findByDateRange(anyString(), anyString())).thenReturn(salesInOptional);
    }

    @Test
    public void findByRangeShouldReturnOptionalList(){
        List<Sales> testSales = salesService.findByDateRange("2001-01-01", "2001-01-02");
        Assertions.assertEquals(250.00, testSales.get(0).getValue());
    }




}
