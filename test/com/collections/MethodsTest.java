package com.collections;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
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
        assertEquals(numbers.get(numbers.indexOf(5)+1),7);

        methods.putToArrayAfterElement(numbers, 7, 5, true);
        assertEquals(numbers.get(numbers.lastIndexOf(5)+1),7);
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
        assertTrue((methods.compare(firstSet,secondSet)));
    }
}