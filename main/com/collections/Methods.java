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


    public PriorityQueue<Employee> createPriorityQueue(List<Employee> list) {
        return new PriorityQueue(list);
    }

    public ArrayList reverseArrayList(ArrayList list) {
        Collections.reverse(list);
        return list;
    }

    public boolean checkIfAnagram(String first, String second) {
        Map<Character, Character> map = new HashMap<>();
        char[] table1 = first.toCharArray();
        char[] table2 = second.toCharArray();

        if (table1.length == table2.length) {
            for (int i = 0; i < table1.length; i++) {
                map.put(table1[i], table2[i]);
            }
            int counter = 0;
            for (int i = 0; i < table1.length; i++) {
                if ((map.containsKey(table2[i])) && (map.containsValue(table1[i]))) {
                    counter++;
                }
            }
            return table1.length == counter;
        } else {
            System.out.println("Different amount of characters in words.");
            return false;
        }

    }

    public boolean canBePalindrome(String s) {
        List<Character> word = new ArrayList<>();
        List<Character> wordCopy = new ArrayList<>();

        //adding single characters as an elements of Lists
        for (char c : s.toCharArray()) {
            word.add(c);
            wordCopy.add(c);
        }

        int nonPairsCharacters = 0;
        int counter = 0;

        while (!(word.isEmpty())) {

            //counting of quantity every type of character in the word
            while (word.contains(wordCopy.get(0))) {
                counter++;
                word.remove(wordCopy.get(0));
            }
            //counting of non pairs characters
            if (counter % 2 == 1) {
                nonPairsCharacters++;
            }
            //update wordCopy list
            wordCopy = List.copyOf(word);

            //set up counter to 0 before next loop
            counter = 0;
        }
        return nonPairsCharacters == 1 || nonPairsCharacters == 0;
    }


    public int[] sumTwoIntArrays(int[] array1, int[] array2) {

        //Convert array to string builder
        StringBuilder stringBuilder1 = new StringBuilder();
        StringBuilder stringBuilder2 = new StringBuilder();
        for (int item : array1) {
            if (item < 0 || item > 9) {
                throw new IllegalArgumentException("You can put in arrays only digits in 0-9 scope.");
            }
            stringBuilder1.append(item);
        }
        for (int item : array2) {
            if (item < 0 || item > 9) {
                throw new IllegalArgumentException("You can put in arrays only digits in 0-9 scope.");
            }
            stringBuilder2.append(item);
        }

        //Convert string builder to int
        int number1 = Integer.parseInt(stringBuilder1.toString());
        int number2 = Integer.parseInt(stringBuilder2.toString());

        //calculate arrays sum
        int sum = number1 + number2;
        String stringSum = String.valueOf(sum);
        int sumcopy = sum;

        int digitsNumber = 0;
        while (sumcopy > 0) {
            sumcopy = sumcopy / 10;
            digitsNumber++;
        }

        //create int array from whole int value
        int[] arraysSum = new int[digitsNumber];
        for (int i = digitsNumber; i > 0; i--) {
            arraysSum[i - 1] = sum % 10;
            sum = sum / 10;
        }

        return arraysSum;
    }
}