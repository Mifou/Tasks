package com.collections;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.*;

import static org.testng.Assert.*;


class MethodsTest {

    Methods methods = new Methods();

    private boolean compareTwoIntArrays(int[] array1, int[] array2) {
        if (array1.length == array2.length) {
            for (int i = 0; i < array1.length; i++) {
                if (array1[i] != array2[i]) {
                    return false;
                }
            }

        }
        return true;
    }

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
        assertEquals((int) numbers.get(numbers.indexOf(5) + 1), 7);

        methods.putToArrayAfterElement(numbers, 7, 5, true);
        assertEquals((int) numbers.get(numbers.lastIndexOf(5) + 1), 7);
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

    @Test(dataProvider = "sumOfArraysDataProvider")
    void sumTwoIntArrays1(int[] array1, int[] array2, int[] sumA1A2) {
        assertTrue(compareTwoIntArrays(methods.sumTwoIntArrays1(array2, array1), sumA1A2));
        assertTrue(compareTwoIntArrays(methods.sumTwoIntArrays(array2, array1), sumA1A2));
    }

    @DataProvider(name = "sumOfArraysDataProvider")

    public Object[][] getData1() {
        int[] array1 = {2, 4, 6};
        int[] array2 = {1, 2};
        int[] sumA1A2 = {2, 5, 8};

        int[] array3 = {9, 8, 7, 6, 2, 5, 9};
        int[] array4 = {9, 8, 7, 8, 9, 7};
        int[] sumA3A4 = {1, 0, 8, 6, 4, 1, 5, 6};

        int[] array5 = {1, 2, 3};
        int[] array6 = {1, 2, 3};
        int[] sumA5A6 = {2, 4, 6};


        return new int[][][]{{array1, array2, sumA1A2}, {array3, array4, sumA3A4}, {array5, array6, sumA5A6}};
    }
}

