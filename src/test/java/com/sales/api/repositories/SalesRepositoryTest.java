package com.sales.api.repositories;

import com.sales.api.entities.Sales;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.List;

@DataJpaTest
public class SalesRepositoryTest {

    @Autowired
    SalesRepository salesRepository;

    int numberOfRegistersToBeFound;
    int numberOfRegistersToBeNotFound;
    String initialDate;
    String finalDate;

    @BeforeEach
    public void setup(){
        initialDate = "2001-01-01";
        finalDate = "2001-01-10";
        numberOfRegistersToBeFound = 12;
        numberOfRegistersToBeNotFound = 11;
    }

    @Test
    public void findByDateRangeShouldReturnEqualsWhenNumberOfRegistersToBeFoundIsUsed(){
        List<Sales> sales = salesRepository.findByDateRange(initialDate, finalDate);
        Assertions.assertEquals(numberOfRegistersToBeFound, sales.size());
    }
    @Test
    public void findByDateRangeShouldReturnNotEqualsWhenNumberOfRegistersToBeNotFoundIsUsed(){
        List<Sales> sales = salesRepository.findByDateRange(initialDate, finalDate);
        Assertions.assertNotEquals(numberOfRegistersToBeNotFound, sales.size());
    }


}
