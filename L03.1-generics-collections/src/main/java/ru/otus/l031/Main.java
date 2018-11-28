package ru.otus.l031;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Integer> firstList = new MyArrayList();
        System.out.println(String.format("Before addAll firstList length %s\nContains: %s", firstList.size(), firstList));

        Collections.addAll(firstList, 1, 4, 100, -48, 0);
        System.out.println(String.format("\nAfter addAll firstList length %s\nContains: %s", firstList.size(), firstList));

        List <Integer> secondList = new MyArrayList(firstList);

        Collections.copy(secondList, firstList);
        System.out.println(String.format("\nAfter copy secondList length %s\nContains: %s", secondList.size(), secondList));

        Collections.sort(secondList, Comparator.reverseOrder());
        System.out.println(String.format("\nAfter sort: %s", secondList));
    }
}
