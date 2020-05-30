package com.collections;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MethodsTest {

    Methods methods = new Methods();

    @Test
    void putToArrayAfterElement() {
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(5);
        numbers.add(1);
        numbers.add(3);
        numbers.add(5);
        numbers.add(9);
        numbers.add(4);

        methods.putToArrayAfterElement(numbers, 7, 5, false);
        assertEquals(numbers.get(numbers.indexOf(5) + 1), 7);

        methods.putToArrayAfterElement(numbers, 7, 5, true);
        assertEquals(numbers.get(numbers.lastIndexOf(5) + 1), 7);
    }

    @Test
    void compare() {
        Set<Integer> firstSet = new HashSet<>();
        firstSet.add(1);
        firstSet.add(5);
        firstSet.add(3);
        firstSet.add(9);
        firstSet.add(4);

        Set<Integer> secondSet = new HashSet<>(firstSet);
        assertTrue((methods.compare(firstSet, secondSet)));
    }

    @Test
    void createPriorityQueue() {
        Employee employee1 = new Employee("Kazek", 2000);
        Employee employee2 = new Employee("Dzol", 2500);
        Employee employee3 = new Employee("Boyd", 3000);
        Employee employee4 = new Employee("John", 3500);
        Employee employee5 = new Employee("Peter Long", 4000);
        Employee employee6 = new Employee("Albert",1023);
        Employee employee7 = new Employee("Zack", 8000);
        Employee employee8 = new Employee("Bill", 3450);

        List<Employee> list = new ArrayList<>();
        list.add(employee1);
        list.add(employee2);
        list.add(employee3);
        list.add(employee4);
        list.add(employee5);
        list.add(employee6);
        list.add(employee7);
        list.add(employee8);

        PriorityQueue<Employee> queue = methods.createPriorityQueue(list);
        
        System.out.println("priority queue: " + queue);
    }
}