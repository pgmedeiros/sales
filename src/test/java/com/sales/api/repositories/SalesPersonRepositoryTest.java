package com.sales.api.repositories;

import com.sales.api.entities.SalesPerson;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.EmptyResultDataAccessException;
import java.util.Optional;

@DataJpaTest
public class SalesPersonRepositoryTest {

    @Autowired
    SalesPersonRepository salesPersonRepository;


    Long notExistingId;
    Long existingId;
    SalesPerson salesPerson;


    @BeforeEach
    public void setup(){
        //valor garantidamente NÃO NÃO existente na tabela deve ser informado nessa variável
        notExistingId = 100L;
        //valor garantidamente SIM SIM existente na tabela deve ser informado nessa variável
        existingId = 1L;

        salesPerson = new SalesPerson();
        salesPerson.setName("VendedorX9");


    }


    @Test
    public void findByIdShouldReturnIsEmptyTrueWhenNotExistingIdIsProvided(){
        Optional<SalesPerson> salesPersonOptional = salesPersonRepository.findById(notExistingId);
        Assertions.assertTrue(salesPersonOptional.isEmpty());
    }

    @Test
    public void findByIdShouldReturnIsEmptyFalseWhenExistingIdIsProvided(){
        Optional<SalesPerson> salesPersonOptional = salesPersonRepository.findById(existingId);
        Assertions.assertFalse(salesPersonOptional.isEmpty());
    }
    @Test
    public void findByIdShouldReturnIsEmptyTrueWhenExistingIdIsProvidedAndDeletedById(){
        salesPersonRepository.deleteById(existingId);
        Optional<SalesPerson> salesPersonOptional = salesPersonRepository.findById(existingId);
        Assertions.assertTrue(salesPersonOptional.isEmpty());
    }
    @Test
    public void findByIdShouldReturnIsPresentTrueWhenNotExistingIdIsProvidedAndSaved(){
        salesPersonRepository.deleteById(existingId);
        salesPersonRepository.save(salesPerson);
        Optional<SalesPerson> salesPersonOptional = salesPersonRepository.findById(salesPerson.getId());
        Assertions.assertTrue(salesPersonOptional.isPresent());
    }
    @Test
    public void deleteShouldThrowEmptyResultDataAccessExceptionWhenNotExistingIdIsProvided(){
        Assertions.assertThrowsExactly(EmptyResultDataAccessException.class, () -> {
            salesPersonRepository.deleteById(notExistingId);
        });
    }


    @Test
    public void saveShouldAddOnetoCountWhenObjectIsSaved(){
        Long count = salesPersonRepository.count();
        salesPersonRepository.save(salesPerson);
        Assertions.assertEquals(count + 1, salesPersonRepository.count());
    }

    @Test
    public void saveShouldUpdateValueWhenIdExistOnTable(){
        Long count = salesPersonRepository.count();
        salesPerson.setId(1L);
        salesPerson.setName("Outro vendedor");
        SalesPerson salesPerson2 = salesPersonRepository.save(salesPerson);
        Assertions.assertEquals(count, salesPersonRepository.count());
        Assertions.assertEquals("Outro vendedor", salesPerson2.getName());
    }



}
