package com.collections;

import java.util.*;

public class Methods {

    public ArrayList<Integer> putToArrayAfterElement(ArrayList<Integer> array, int elementToPut, int existingElement, boolean isLast) {
        if (array.contains(existingElement)) {
            if (!isLast) {
                array.add((array.indexOf(existingElement)) + 1, elementToPut);
            } else {
                array.add((array.lastIndexOf(existingElement)) + 1, elementToPut);
            }
            return array;

        }
        return array;
    }

    static boolean compare(Set<?> set1, Set<?> set2) {
        if (set1 == null || set2 == null) {
            return false;
        }
        if (set1.size() != set2.size()) {
            return false;
        }
        return (set1.containsAll(set2));
    }


    public PriorityQueue<Employee> createPriorityQueue(List<Employee> list){
        return new PriorityQueue(list);
    }

    public ArrayList reverseArrayList(ArrayList list){
       Collections.reverse(list);
       return list;
    }
}
