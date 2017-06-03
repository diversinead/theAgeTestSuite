package com.autoFramework.utilities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by sdiver on 5/30/2017.
 */
public class general {

    public static void main(String[] args) {
        long lnum = 654321;
        long invNum = 0;

        findDuplicates();
        sortStrings();

        invNum = invertNumber(lnum);
        System.out.println("Input value : " + lnum);
        System.out.println("Inverted value : " + invNum);
    }
    public static void findDuplicates(){
        ArrayList<String> list = new ArrayList<String>();

        // Form a list of numbers from 0-9.
        for (int i = 0; i < 10; i++) {
            list.add(String.valueOf(i));
        }

        // Insert a new set of numbers from 0-5.
        for (int i = 0; i < 5; i++) {
            list.add(String.valueOf(i));
        }

        System.out.println("Input list : " + list);
        System.out.println("\nFiltered duplicates : " + processList(list));
    }
    public static Set<String> processList(List<String> listContainingDuplicates) {

        final Set<String> resultSet = new HashSet<String>();
        final Set<String> tempSet = new HashSet<String>();

        for (String yourInt : listContainingDuplicates) {
            if (!tempSet.add(yourInt)) {
                resultSet.add(yourInt);
            }
        }
        return resultSet;
    }
    public static void sortStrings(){
        String[] inputList = { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul",
                               "aug", "Sep", "Oct", "nov", "Dec" };

        // Display input un-sorted list.
        System.out.println("-------Input List-------");
        showList(inputList);

        // Call to sort the input list.
        Arrays.sort(inputList);

        // Display the sorted list.
        System.out.println("\n-------Sorted List-------");
        showList(inputList);

        // Call to sort the input list in case-sensitive order.
        System.out.println("\n-------Sorted list (Case-Sensitive)-------");
        Arrays.sort(inputList, String.CASE_INSENSITIVE_ORDER);

        // Display the sorted list.
        showList(inputList);
    }
    public static void showList(String[] array) {
        for (String str : array) {
            System.out.print(str + " ");
        }
        System.out.println();
    }
    public static long invertNumber(long number){
        long invert = 0;

        while (number != 0) {
            invert = (invert * 10) + (number % 10);
            number = number / 10;
        }
        return invert;
    }
}
