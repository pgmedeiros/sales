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
    Controller salesPersonController;

    @InjectMocks
    private DateDTO initialDateDTO;
    @InjectMocks
    private DateDTO finalDateDTO;
    @InjectMocks
    private DateDTO notExistinginitialDateDTO;
    @InjectMocks
    private DateDTO notExistingfinalDateDTO;
    @InjectMocks
    private ArrayList<DateDTO> listDateDTO = new ArrayList<>();
    @InjectMocks
    private ArrayList<DateDTO> notExistinglistDateDTO = new ArrayList<>();
    private int listOfResult;
    @BeforeEach
    public void setup(){
        initialDateDTO.setDate("2001-01-11");
        finalDateDTO.setDate("2001-01-20");
        notExistinginitialDateDTO.setDate("2010-01-01");
        notExistingfinalDateDTO.setDate("2010-01-10");
        listDateDTO.add(initialDateDTO);
        listDateDTO.add(finalDateDTO);
        notExistinglistDateDTO.add(notExistinginitialDateDTO);
        notExistinglistDateDTO.add(notExistingfinalDateDTO);
        listOfResult = 10;
    }



}
