package com.collections;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MethodsTest { // once you remove this method from main class please change the test class name

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
        // you shouldn't use Main class. Method putToArrayAfterElement shouldn't be static void and should return modified array
        // So put this method in some new class, not Main, create not static method which return modified array and test this method.

        assertEquals(numbers.get(numbers.indexOf(5)+1),7);  // intellij gives you a hint here - assertEquals is better in that case


        methods.putToArrayAfterElement(numbers, 7, 5, true);

        assertEquals(numbers.get(numbers.lastIndexOf(5)+1),7);  // intellij gives you a hint here - assertEquals is better in that case




    }

    // this test is not needed, it's java functionality, we don't need to test java class itself
    @Test
    void compare() {
        Set<Integer> firstSet = new HashSet<>(); // remember about <> operator when you create set or list
        firstSet.add(1);
        firstSet.add(5);
        firstSet.add(3);
        firstSet.add(9);
        firstSet.add(4);

        Set<Integer> secondSet = new HashSet<>(firstSet);
        assertTrue((methods.compare(firstSet,secondSet)));
    }
}