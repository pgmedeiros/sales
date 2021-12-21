package com.sales.api.controllers;


import com.sales.api.entities.SalesPerson;
import com.sales.api.services.SalesPersonService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

@WebMvcTest(SalesPersonController.class)
public class SalesPersonControllerTest {

    @Autowired
    MockMvc mockMvc;
    @MockBean
    SalesPersonService salesPersonService;
    @BeforeEach
    public void setup(){
        SalesPerson salesPerson = new SalesPerson();
        salesPerson.setName("pedro");
        salesPerson.setId(1L);
        ResponseEntity<SalesPerson> responseEntity = new ResponseEntity<>(salesPerson, HttpStatus.OK);
        Mockito.when(salesPersonService.getSalesPerson(1L)).thenReturn(Optional.of(salesPerson));

    }


    /*/APRENDER COMANDO PARA PEGAR ID DA URL
    @Test
    public void main() throws Exception {
        mockMvc.perform(get("/salesperson/")).andExpect(status().isOk());
    }
    */



}
