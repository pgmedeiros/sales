package com.sales.api.repositories;

import com.sales.api.entities.Sales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface SalesRepository extends JpaRepository<Sales, Long> {

    @Query("SELECT s FROM Sales s WHERE (s.date BETWEEN TO_DATE(?1, 'yyyy-MM-dd') AND TO_DATE(?2, 'yyyy-MM-dd'))")
    Optional<List<Sales>> findByDateRange(String initialDate, String finalDate);


}
