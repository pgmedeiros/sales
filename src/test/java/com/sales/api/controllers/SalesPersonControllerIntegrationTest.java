package com.sales.api.controllers;

import com.sales.api.dto.DateDTO;
import com.sales.api.entities.Sales;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class SalesPersonControllerIntegrationTest {

    @Autowired
    SalesPersonController salesPersonController;

    @InjectMocks
    private DateDTO initialDateDTO;
    @InjectMocks
    private DateDTO finalDateDTO;
    @InjectMocks
    private ArrayList<DateDTO> listDateDTO = new ArrayList<>();
    private int listOfResult;
    @BeforeEach
    public void setup(){
        initialDateDTO.setDate("2001-01-11");
        finalDateDTO.setDate("2001-01-20");
        listDateDTO.add(initialDateDTO);
        listDateDTO.add(finalDateDTO);
        listOfResult = 10;
    }

    @Test
    public void findByRangeOfDateShouldReturnListOfSales(){
        List<Sales> sales = salesPersonController.findByRangeOfDate(listDateDTO);
        Assertions.assertEquals(10, sales.size());
    }


}
