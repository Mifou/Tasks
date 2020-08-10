package com.collections;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.SortedSet;
import java.util.TreeSet;

import static org.testng.Assert.assertTrue;

public class SalaryComparatorTest {

    @Test
    void salaryComparatorTest() {
        Employee employee1 = new Employee("Kazek", 2000);
        Employee employee2 = new Employee("Dzolek", 2500);
        Employee employee3 = new Employee("Bolek", 3000);
        Employee employee4 = new Employee("Jasiu", 3500);
        Employee employee5 = new Employee("Pietrek Długos", 4000);

        SalaryComparator salaryComparator = new SalaryComparator();

        SortedSet<Employee> employeeSet1 = new TreeSet<Employee>(salaryComparator) {
        };

        employeeSet1.add(employee1);
        employeeSet1.add(employee2);
        employeeSet1.add(employee3);
        employeeSet1.add(employee4);
        employeeSet1.add(employee5);

        ArrayList<Employee> employeeList = new ArrayList<>(employeeSet1);

        ListIterator<Employee> iterator = employeeList.listIterator();

        while (iterator.hasNext()) {
            int firstSalary = iterator.next().getSalary();
            if (iterator.hasNext()) {
               int secondSalary = iterator.next().getSalary();
                System.out.println(firstSalary + "   " + secondSalary);
                assertTrue(firstSalary < secondSalary);
                iterator.previous();
            }
        }
    }
}