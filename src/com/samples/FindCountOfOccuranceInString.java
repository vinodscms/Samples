package com.samples;

import java.util.*;

/**
 * Program to count the words with its occurance.
 */
public class FindCountOfOccuranceInString {
    public static void main(String args[]) {
        String sentence = "this is a dummy abc ab abcd ab abcd abc this def kerty is a test sentence";
        String words[] = sentence.split(" ");
        Map<Integer,ArrayList> wordMap = new HashMap<>();
        List<String> wordList = new ArrayList<>();

        int length;
        for(String word:words){
            wordList = new ArrayList<>();
            length = word.length();
            if(wordMap.containsKey(length))
            {
                wordList = wordMap.get(length);
                wordList.add(word);
                wordMap.put(length, (ArrayList) wordList);
            }else {
                wordList.add(word);
                wordMap.put(length, (ArrayList) wordList);
            }
        }

        for(Iterator<Map.Entry<Integer, ArrayList>> itr = wordMap.entrySet().iterator(); itr.hasNext();) {
            Map.Entry pair = (Map.Entry)itr.next();
            System.out.println(pair.getKey() + ":" + pair.getValue());
        }

        //First non repeat word in string
        System.out.println("\nFirst non-repeating word: " + firstNonRepeator(words));
    }

    private static String firstNonRepeator(String[] words) {
        Queue<String> queue = new LinkedList<>();
        for(String s : words) {
            if(!queue.contains(s))
                queue.add(s);
            else
                queue.remove(s);
        }
        return queue.peek();
    }
}
