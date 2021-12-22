package com.sales.api.dto;

public class DataDTO {

    String name;
    int totalOfSales;
    double averageSalesPerDay;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTotalOfSales() {
        return totalOfSales;
    }

    public void setTotalOfSales(int totalOfSales) {
        this.totalOfSales = totalOfSales;
    }

    public double getAverageSalesPerDay() {
        return averageSalesPerDay;
    }

    public void setAverageSalesPerDay(double averageSalesPerDay) {
        this.averageSalesPerDay = averageSalesPerDay;
    }
}
