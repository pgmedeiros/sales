package com.sales.api.services;

import com.sales.api.dto.DataDTO;
import com.sales.api.dto.IdDTO;
import com.sales.api.entities.Sales;
import com.sales.api.entities.SalesPerson;
import com.sales.api.repositories.SalesPersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public int findNumberOfSalesById(List<IdDTO> idDTO, Long id){
        ArrayList<Sales> arrayList = new ArrayList<>();
        localDateOne = idDTO.get(0).getDate();
        localDateTwo = idDTO.get(1).getDate();
        Optional<List<Sales>> listOfOptionalSales = salesPersonRepository
                .getSalesByRangeOfDateAndSalesPersonId(idDTO.get(0).getDate(), idDTO.get(1).getDate(), id);
        ArrayList<Sales> listOfSales = (ArrayList<Sales>) listOfOptionalSales.get();

        return listOfSales.size();
    }

    public int daysBetweenTwoDates(List<IdDTO> idDTO){
        localDateOne = idDTO.get(0).getDate();
        localDateTwo = idDTO.get(1).getDate();
        int diff;
        Period period = Period.between(LocalDate.parse(localDateTwo), LocalDate.parse(localDateOne));
        return diff = Math.abs(period.getDays());
    }

    public double averageSalesPerDay(List<IdDTO> idDTO, Long id){
        int numberOfSales = findNumberOfSalesById(idDTO, id);
        int days = daysBetweenTwoDates(idDTO);
        return numberOfSales / days;
    }

    public ArrayList<DataDTO> getData(List<IdDTO> idDTOS){
        List<SalesPerson> salesPerson = salesPersonRepository.findAll();
        ArrayList<DataDTO> dataDTOS = new ArrayList<>();
        int size = salesPerson.size();
        Long id = 1L;
        for(int count = 1; count <= size; count++){
            DataDTO data = new DataDTO();
            data.setName(getSalesPerson(id).get().getName());
            data.setTotalOfSales(findNumberOfSalesById(idDTOS, id));
            data.setAverageSalesPerDay(averageSalesPerDay(idDTOS, id));
            dataDTOS.add(data);
            id++;
        }
        return dataDTOS;
    }




}
