package com.core.penchal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
 
public class ReadCountPrintRepeatedCharacterOccurencesInString {
 
    public static void main(String[] args) {
 
        // sample test string
        String testStr = "Spring";
 
        // invoke to count & print for supplied file
        countAndPrintRepeatedCharacterOccurences(testStr);
    }
 
    /**
     * this method is used to count number repeated word occurrences
     * @param fileName
     */
    public static void countAndPrintRepeatedCharacterOccurences(String strContent) {
 
        // Step 1: create Map of Character-Integer
        Map<Character, Integer> mapOfRepeatedChar = new HashMap<Character, Integer>();
 
        // Step 2: convert String into character array using toCharArray() method 
        char[] chArray = strContent.toCharArray();
 
        // Step 3: iterate through char[] array
        for(char ch : chArray) {
 
            // Step 4: leave spaces
            if(ch != ' '){
 
                // Step 5: check whether Map contains particular character 
                if(mapOfRepeatedChar.containsKey(ch)){
 
                    // Step 6: If contains, increase count value by 1
                    mapOfRepeatedChar.put(ch, mapOfRepeatedChar.get(ch) + 1);
                } 
                else {
 
                    // Step 7: otherwise, make a new entry
                    mapOfRepeatedChar.put(ch, 1);
                }
            }
        }
 
        System.out.println("Before sorting : \n");
        System.out.println("Char" + "\t" + "Count");
        System.out.println("====" + "\t" + "=====");
 
        // Step 8: get keySet() for iteration 
        Set<Character> character = mapOfRepeatedChar.keySet();
 
        // Step 9: print word along with its count
        for(Character ch : character) {
            System.out.println(ch + "\t" + mapOfRepeatedChar.get(ch));
        }
 
        // Step 10: Sorting logic by invoking sortByCountValue() method
        Map<Character, Integer> wordLHMap = sortByCountValue(mapOfRepeatedChar);
 
        System.out.println("\n\nAfter sorting in descending order of count : \n");
        System.out.println("Char" + "\t" + "Count");
        System.out.println("====" + "\t" + "=====");
 
        // Step 11: Again print after sorting
        for(Map.Entry<Character, Integer> entry : wordLHMap.entrySet()){
            System.out.println(entry.getKey() + "\t" + entry.getValue());
        }
    }
 
    /**
     * this method sort acc. to count value
     * @param mapOfRepeatedWord
     * @return
     */
    public static Map<Character, Integer> sortByCountValue(
            Map<Character, Integer> mapOfRepeatedWord) {
 
        // get entrySet from HashMap object
        Set<Map.Entry<Character, Integer>> setOfWordEntries = mapOfRepeatedWord.entrySet();
 
        // convert HashMap to List of Map entries
        List<Map.Entry<Character, Integer>> listOfwordEntry = 
                new ArrayList<Map.Entry<Character, Integer>>(setOfWordEntries);
 
        // sort list of entries using Collections class utility method sort(ls, cmptr)
        Collections.sort(listOfwordEntry, 
                new Comparator<Map.Entry<Character, Integer>>() {
 
            @Override
            public int compare(Entry<Character, Integer> es1, 
                    Entry<Character, Integer> es2) {
                return es2.getValue().compareTo(es1.getValue()); // NOTE
            }
        });
 
        // store into LinkedHashMap for maintaining insertion order
        Map<Character, Integer> wordLHMap = 
                new LinkedHashMap<Character, Integer>();
 
        // iterating list and storing in LinkedHahsMap
        for(Map.Entry<Character, Integer> map : listOfwordEntry){
            wordLHMap.put(map.getKey(), map.getValue());
        }
 
        return wordLHMap;
    }
}