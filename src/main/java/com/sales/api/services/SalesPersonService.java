package com.sales.api.services;

import com.sales.api.dto.DataDTO;
import com.sales.api.dto.IdDTO;
import com.sales.api.dto.RangeOfDatesDTO;
import com.sales.api.entities.Sales;
import com.sales.api.entities.SalesPerson;
import com.sales.api.repositories.SalesPersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.ranges.Range;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SalesPersonService {

    @Autowired
    SalesPersonRepository salesPersonRepository;
    String localDateOne;
    String localDateTwo;

    public void saveNewSalesPerson(SalesPerson salesPerson){
        salesPersonRepository.save(salesPerson);
    }

    public Optional<SalesPerson> getSalesPerson(Long id){
        Optional<SalesPerson> salesPersonOptional = salesPersonRepository.findById(id);
        return salesPersonOptional;
    }

    public int findNumberOfSalesById(RangeOfDatesDTO rangeOfDatesDTO, Long id){
        ArrayList<Sales> arrayList = new ArrayList<>();
        localDateOne = rangeOfDatesDTO.getInitial_date();
        localDateTwo = rangeOfDatesDTO.getFinal_date();
        Optional<List<Sales>> listOfOptionalSales = salesPersonRepository
                .getSalesByRangeOfDateAndSalesPersonId(rangeOfDatesDTO.getInitial_date(), rangeOfDatesDTO.getFinal_date(), id);
        ArrayList<Sales> listOfSales = (ArrayList<Sales>) listOfOptionalSales.get();

        return listOfSales.size();
    }

    public int daysBetweenTwoDates(RangeOfDatesDTO rangeOfDatesDTO){
        localDateOne = rangeOfDatesDTO.getInitial_date();
        localDateTwo = rangeOfDatesDTO.getFinal_date();
        int diff;
        Period period = Period.between(LocalDate.parse(localDateTwo), LocalDate.parse(localDateOne));
        return diff = Math.abs(period.getDays());
    }

    public double averageSalesPerDay(RangeOfDatesDTO rangeOfDatesDTO, Long id){
        int numberOfSales = findNumberOfSalesById(rangeOfDatesDTO, id);
        int days = daysBetweenTwoDates(rangeOfDatesDTO);
        return numberOfSales / days;
    }

    public ArrayList<DataDTO> getData(RangeOfDatesDTO rangeOfDatesDTO){
        List<SalesPerson> salesPerson = salesPersonRepository.findAll();
        ArrayList<DataDTO> dataDTOS = new ArrayList<>();
        int size = salesPerson.size();
        Long id = 1L;
        for(int count = 1; count <= size; count++){
            DataDTO data = new DataDTO();
            data.setName(getSalesPerson(id).get().getName());
            data.setTotalOfSales(findNumberOfSalesById(rangeOfDatesDTO, id));
            data.setAverageSalesPerDay(averageSalesPerDay(rangeOfDatesDTO, id));
            dataDTOS.add(data);
            id++;
        }
        return dataDTOS;
    }




}
