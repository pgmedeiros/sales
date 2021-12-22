package com.sales.api.services;

import com.sales.api.dto.IdDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
public class SalesPersonServiceIntegrationTest {
    @Autowired
    SalesPersonService salesPersonService;


}
