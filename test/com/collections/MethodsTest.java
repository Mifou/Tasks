package com.collections;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

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
        Employee employee6 = new Employee("Albert", 1023);
        Employee employee7 = new Employee("Zack", 8000);
        Employee employee8 = new Employee("Bill", 3450);

        List<Employee> list1 = new ArrayList<>();
        list1.add(employee1);
        list1.add(employee2);
        list1.add(employee3);
        list1.add(employee4);
        list1.add(employee5);
        list1.add(employee6);
        list1.add(employee7);
        list1.add(employee8);

        NameComparator nameComparator = new NameComparator();

        //create queue before sorting list1
        PriorityQueue<Employee> queue = methods.createPriorityQueue(list1);
        System.out.println("priority queue: " + queue);
        //sorting list1
        list1.sort(nameComparator);
        List<Employee> list2 = new ArrayList<>();

        while (queue.peek() != null) {
            //create list2 from queue
            list2.add(queue.poll());
        }
        assertEquals(list1, list2);
    }

    @Test
    void reverseArrayList() {
        Employee employee1 = new Employee("Kazek", 2000);
        Employee employee2 = new Employee("Dzol", 2500);
        Employee employee3 = new Employee("Boyd", 3000);
        Employee employee4 = new Employee("John", 3500);
        Employee employee5 = new Employee("Peter Long", 4000);
        Employee employee6 = new Employee("Albert", 1023);

        ArrayList<Employee> list1 = new ArrayList<>();
        list1.add(employee1);
        list1.add(employee2);
        list1.add(employee3);
        list1.add(employee4);
        list1.add(employee5);
        list1.add(employee6);

        ArrayList<Employee> list2 = new ArrayList<>();
        list2.add(employee6);
        list2.add(employee5);
        list2.add(employee4);
        list2.add(employee3);
        list2.add(employee2);
        list2.add(employee1);

        assertEquals(methods.reverseArrayList(list1), list2);
    }

    @Test
    void checkIfAnagram() {
        assertTrue(methods.checkIfAnagram("dupa", "upad"));
        assertTrue(methods.checkIfAnagram("moszna", "mszona"));
        assertTrue(methods.checkIfAnagram("sieckarnia", "kaseciarni"));

        assertFalse(methods.checkIfAnagram("dupa", "zupa"));
        assertFalse(methods.checkIfAnagram("drzewo", "JavaCollections"));

    }

    @Test
    void canBePalindrome() {
        assertTrue(methods.canBePalindrome("kajak"));
        assertTrue(methods.canBePalindrome("kkaaj"));
        assertTrue(methods.canBePalindrome("kkaa"));
        assertFalse(methods.canBePalindrome("abcd"));
        assertFalse(methods.canBePalindrome("kajakk"));
    }

    @Test
    void sumTwoIntArrays() {

        //1 Case
        int[] array1 = {1, 2, 3};
        int[] array2 = {9, 9, 9};
        int[] sumA1andA2 = {1, 1, 2, 2};
        int[] methodSum1 = methods.sumTwoIntArrays(array1, array2);

        if (sumA1andA2.length == methodSum1.length) {
            int count1 = 0;
            for (int i = 0; i < sumA1andA2.length; i++) {
                if (sumA1andA2[i] != methodSum1[i]) {
                    count1++;
                    break;
                }
            }
            assertEquals(0, count1);

        }
        //2 Case
        int[] array3 = {1, 7};
        int[] array4 = {4, 0};
        int[] sumA3andA4 = {2, 7};
        int[] methodSum2 = methods.sumTwoIntArrays(array3, array4);

        if (sumA3andA4.length == methodSum2.length) {
            int count2 = 0;
            for (int i = 0; i < sumA3andA4.length; i++) {
                if (sumA3andA4[i] != methodSum2[i]) {
                    count2++;
                    break;
                }
            }
            assertEquals(1, count2);
        }
    }
}