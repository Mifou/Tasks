package com.collections;
import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

class NameComparatorTest {

    @Test
    //First option test
    void nameComparatorTest() {
        Employee employee1 = new Employee("Kazek", 2000);
        Employee employee2 = new Employee("Dzol", 2500);
        Employee employee3 = new Employee("Boyd", 3000);
        Employee employee4 = new Employee("John", 3500);
        Employee employee5 = new Employee("Peter Long", 4000);

        NameComparator nameComparator = new NameComparator();

        SortedSet<Employee> sortedSet = new TreeSet<Employee>(nameComparator) {
        };

        sortedSet.add(employee1);
        sortedSet.add(employee2);
        sortedSet.add(employee3);
        sortedSet.add(employee4);
        sortedSet.add(employee5);

        ArrayList<Employee> employeeList = new ArrayList<>(sortedSet);

        ListIterator<Employee> iterator = employeeList.listIterator();

        while (iterator.hasNext()) {
            String firstName = iterator.next().getName();
            if (iterator.hasNext()) {
                String secondName = iterator.next().getName();

                System.out.println(firstName + "   " + secondName);
                assertTrue(firstName.compareTo(secondName)<0);
                iterator.previous();
            }
        }
    }

    // nice, but this 'while' seems to be a little bit overcomplicated, test should have rather simple logic - that's the idea of unit tests.
    // In that case it can be easily done by created fake list or set with proper output values and compare employeeSet1 with this fake set/list.
    // I will show you later how it can be done here or you can try on your own.

    @Test
    //Second option test
    void nameComparatorTest2(){
        Employee employee1 = new Employee("Kazek", 2000);
        Employee employee2 = new Employee("Dzol", 2500);
        Employee employee3 = new Employee("Boyd", 3000);
        Employee employee4 = new Employee("John", 3500);
        Employee employee5 = new Employee("Peter Long", 4000);

        NameComparator nameComparator = new NameComparator();

        SortedSet<Employee> sortedSet = new TreeSet<Employee>(nameComparator) {
        };

        sortedSet.add(employee1);
        sortedSet.add(employee2);
        sortedSet.add(employee3);
        sortedSet.add(employee4);
        sortedSet.add(employee5);

        ArrayList<Employee> employeesList1 = new ArrayList<>(sortedSet);

        ArrayList<Employee> employeesList2 = new ArrayList<>();

        employeesList2.add(employee3);
        employeesList2.add(employee2);
        employeesList2.add(employee4);
        employeesList2.add(employee1);
        employeesList2.add(employee5);

        assertEquals(employeesList1,employeesList2);

    }
}