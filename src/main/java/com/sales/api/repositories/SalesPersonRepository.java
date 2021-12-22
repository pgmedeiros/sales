package com.sales.api.repositories;

import com.sales.api.entities.Sales;
import com.sales.api.entities.SalesPerson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SalesPersonRepository extends JpaRepository<SalesPerson, Long> {



    @Query("SELECT s FROM Sales s WHERE (s.date BETWEEN TO_DATE(?1, 'yyyy-MM-dd') AND TO_DATE(?2, 'yyyy-MM-dd')) AND (s.salesPerson.id = ?3)")
    Optional<List<Sales>> getSalesByRangeOfDateAndSalesPersonId(String initialdate, String finalDate, Long id);

}
