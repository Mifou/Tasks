package com.collections;

import java.util.Comparator;

public class SalaryComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee employee1, Employee employee2) {
        return Integer.compare(employee1.getSalary(), employee2.getSalary());
    }
}
