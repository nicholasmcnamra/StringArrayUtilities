package com.zipcodewilmington;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by leon on 1/29/18.
 */
public class StringArrayUtils {
    /**
     * @param array array of String objects
     * @return first element of specified array
     */ // TODO
    public static String getFirstElement(String[] array) {
        return array[0];
    }

    /**
     * @param array array of String objects
     * @return second element in specified array
     */
    public static String getSecondElement(String[] array) {
        return array[1];
    }

    /**
     * @param array array of String objects
     * @return last element in specified array
     */ // TODO
    public static String getLastElement(String[] array) {
        return array[array.length - 1];
    }

    /**
     * @param array array of String objects
     * @return second to last element in specified array
     */ // TODO
    public static String getSecondToLastElement(String[] array) {
        return array[array.length - 2];
    }

    /**
     * @param array array of String objects
     * @param value value to check array for
     * @return true if the array contains the specified `value`
     */ // TODO
    public static boolean contains(String[] array, String value) {
        boolean containsValue = false;
        for (int i = 0; i < array.length; i++) {
            if (String.valueOf(array[i]).equals(value)) {
                containsValue = true;
            }
        }
        return containsValue;
    }

    /**
     * @param array of String objects
     * @return an array with identical contents in reverse order
     */ // TODO
    public static String[] reverse(String[] array) {
        String [] newArray = new String [array.length];

        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[(array.length - 1) - i];
        }
        return newArray;
    }

    /**
     * @param array array of String objects
     * @return true if the order of the array is the same backwards and forwards
     */ // TODO
    public static boolean isPalindromic(String[] array) {
        boolean palindrome = false;
        int eachElementCompared = 0;
        ArrayList<String> forwards = new ArrayList<>(List.of(array));
        ArrayList<String> backwards = new ArrayList<>(List.of(array));
        Collections.reverse(backwards);

        for (int i = 0; i < array.length; i++) {
            if (forwards.get(i).equals(backwards.get(i))) {
                eachElementCompared ++;
            }
            if (eachElementCompared == array.length){
                palindrome = true;
            }
        }
        return palindrome;
    }

    /**
     * @param array array of String objects
     * @return true if each letter in the alphabet has been used in the array
     */ // TODO
    public static boolean isPangramic(String[] array) {
        boolean containsAlpha = false;
        int allAlpha = 0;
        StringBuilder allLetters = new StringBuilder("abcdefghijklmnopqrstuvwxyz");
        String arrayToString = "";
        for (String eachString : array) {
            arrayToString += eachString;
        }
        arrayToString = arrayToString.toLowerCase();
        char [] stringToCharArray = arrayToString.toCharArray();
        for(char character: stringToCharArray) {
            for(int i = 0; i < allLetters.length(); i++) {
                if (character == allLetters.charAt(i)) {
                    allAlpha++;
                    allLetters.deleteCharAt(i);
                }
            }
        }
        if (allAlpha == 26) {
            containsAlpha = true;
        }
        return containsAlpha;
    }

    /**
     * @param array array of String objects
     * @param value value to check array for
     * @return number of occurrences the specified `value` has occurred
     */ // TODO
    public static int getNumberOfOccurrences(String[] array, String value) {
        int occurrences = 0;

        for (String each: array) {
            if (each.equals(value)) {
                occurrences++;
            }
        }
        return occurrences;
    }

    /**
     * @param array         array of String objects
     * @param valueToRemove value to remove from array
     * @return array with identical contents excluding values of `value`
     */ // TODO
    public static String[] removeValue(String[] array, String valueToRemove) {
        String [] newArray = new String [array.length - 1];
        int index = 0;
        for(String value : array)
            if (!value.equals(valueToRemove)) {
                newArray[index] = value;
                index++;
            }
        return newArray;
    }

    /**
     * @param array array of chars
     * @return array of Strings with consecutive duplicates removes
     */ // TODO
    public static String[] removeConsecutiveDuplicates(String[] array) {
        ArrayList<String> newArray = new ArrayList<>();
        //add first element so we can start incrementor of loop at 1 without going out of bounds
        newArray.add(array[0]);

        for(int i = 1; i < array.length; i++) {
            if(!array[i-1].equals(array[i])){
                newArray.add(array[i]);
            }
        }
        return newArray.toArray(new String[0]);
    }

    /**
     * @param array array of chars
     * @return array of Strings with each consecutive duplicate occurrence concatenated as a single string in an array of Strings
     */ // TODO
    public static String[] packConsecutiveDuplicates(String[] array) {
        ArrayList<String> arrayList = new ArrayList<>();
        StringBuilder addStringToNewArray = new StringBuilder();
        addStringToNewArray.append(array[0]);
        //get each string element in parameter array
        for (int i = 1; i < array.length; i++) {
            if (array[i] == array[i-1]) {
                addStringToNewArray.append(array[i]);
            }
            else {
                arrayList.add(String.valueOf(addStringToNewArray));
                addStringToNewArray = new StringBuilder(array[i]);
                // set string to add to array to value of index
            }
        }
        arrayList.add(String.valueOf(addStringToNewArray));
        // get last value and add to arraylist
        System.out.println(arrayList);
        return arrayList.toArray(new String[0]);
    }


}
