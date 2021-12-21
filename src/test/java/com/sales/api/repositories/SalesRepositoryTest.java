package com.sales.api.repositories;

import com.sales.api.entities.Sales;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import java.util.List;
import java.util.Optional;

@DataJpaTest
public class SalesRepositoryTest {

    @Autowired
    SalesRepository salesRepository;

    int numberOfRegistersToBeFound;
    int numberOfRegistersToBeNotFound;
    String initialDate;
    String finalDate;
    String notExistingInitialDate;
    String notExistingFinalDate;

    @BeforeEach
    public void setup(){
        initialDate = "2001-01-01";
        finalDate = "2001-01-10";
        numberOfRegistersToBeFound = 12;
        numberOfRegistersToBeNotFound = 11;
        notExistingInitialDate = "2010-01-01";
        notExistingFinalDate = "2010-01-10";
    }

    @Test
    public void findByDateRangeShouldReturnEqualsWhenNumberOfRegistersToBeFoundIsUsed(){
        Optional<List<Sales>> sales = salesRepository.findByDateRange(initialDate, finalDate);
        Assertions.assertEquals(numberOfRegistersToBeFound, sales.get().size());
    }
    @Test
    public void findByDateRangeShouldReturnNotEqualsWhenNumberOfRegistersToBeNotFoundIsUsed(){
        Optional<List<Sales>> sales = salesRepository.findByDateRange(initialDate, finalDate);
        Assertions.assertNotEquals(numberOfRegistersToBeNotFound, sales.get().size());
    }
    @Test
    public void findByDateRangeShouldReturnEqualsWhenNotExistingInitialAndFinalDateIsUsed(){
        Optional<List<Sales>> sales = salesRepository.findByDateRange(notExistingInitialDate, notExistingFinalDate);
        Assertions.assertEquals(0 ,sales.get().size());
    }



}
