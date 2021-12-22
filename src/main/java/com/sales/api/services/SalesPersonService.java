package com.sales.api.services;

import com.sales.api.dto.IdDTO;
import com.sales.api.dto.DateDTO;
import com.sales.api.entities.Sales;
import com.sales.api.entities.SalesPerson;
import com.sales.api.repositories.SalesPersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class SalesPersonService {

    @Autowired
    SalesPersonRepository salesPersonRepository;

    public void saveNewSalesPerson(SalesPerson salesPerson){
        salesPersonRepository.save(salesPerson);
    }

    public Optional<SalesPerson> getSalesPerson(Long id){
        Optional<SalesPerson> salesPersonOptional = salesPersonRepository.findById(id);
        return salesPersonOptional;
    }

    public double findAverageValueOfSalesShouldReturnAveragePrice(List<IdDTO> idDTO){
        ArrayList<Sales> arrayList = new ArrayList<>();
        Optional<List<Sales>> listOfOptionalSales = salesPersonRepository
                .getSalesByRangeOfDateAndSalesPersonId(idDTO.get(0).getDate(), idDTO.get(1).getDate(), idDTO.get(2).getId());
        ArrayList<Sales> listOfSales = (ArrayList<Sales>) listOfOptionalSales.get();

        double average = 0;
        int count;
        for(count = 0; count < listOfSales.size(); count++) {
            average = average + listOfSales.get(count).getValue();
        }
        return average / count;
    }


}
