package com.sales.api.repositories;

import com.sales.api.entities.SalesPerson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalesPersonRepository extends JpaRepository<SalesPerson, Long> {
}
