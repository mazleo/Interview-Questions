import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
public class Solution {
    
    /** 
    * Generates a HashMap containing a character as a key and an integer as a value.
    * All characters in the string argument are added to the HashMap as a key with 
    * its frequency as its value.
    *
    * @param s The string to generate a HashMap with
    * @return The generated HashMap
    */
    public static HashMap<Character,Integer> generateHash(String str) {
        if (str == null) {
            throw new IllegalArgumentException("String argument cannot be null");
        }
        HashMap<Character,Integer> hash = new HashMap<Character,Integer>(str.length());
        
        for (int c = 0; c < str.length(); c++) {
            if (hash.containsKey(str.charAt(c))) {
                int freq = hash.get(str.charAt(c));
                freq++;
                hash.put(str.charAt(c), freq);
            }
            else {
                hash.put(str.charAt(c), 1);
            }
        }
        
        return hash;
    }
    
    /**
    * Determines how many characters must be deleted from both strings to
    * output anagram.
    *
    * First creates a hash table for each string with the key being the character
    * and the value being the frequency of the character. Another hash table is then
    * created to store unique characters in both strings. To do this, both strings
    * are iterated through. At each iteration, the character is added into
    * the hash if it does not exist. If it does, then the program continues to the next 
    * iteration (to prevent repetition, as it was already calculated). The value will 
    * contain the difference between character's frequency in both strings, which would 
    * be the absolute value. This should determine how many deletions for each character 
    * should be made. At the same time, the differences are added together to output a 
    * total. The total is the resulting number to return.
    *
    * @param first The first string
    * @param second The second string
    * @throws IllegalArgumentException Thrown if the first or second strings are null
    * @return The determined number of characters needed to be deleted to produce an anagram
    */
    public static int numberNeeded(String first, String second) {
        if (first == null || second == null) {
            throw new IllegalArgumentException("The input strings cannot be null.");
        }
        
        String combinedString = first + second;
        HashMap<Character,Integer> charsFirst = generateHash(first);
        HashMap<Character,Integer> charsSecond = generateHash(second);
        HashMap<Character,Integer> uniqueChars = new HashMap<Character,Integer>(combinedString.length());
        int freqDifference = 0;
        int numOfDeletions = 0;
        
        for (int c = 0; c < combinedString.length(); c++) {
            if (uniqueChars.containsKey(combinedString.charAt(c))) {
                continue;
            }
            else {
                if (charsFirst.containsKey(combinedString.charAt(c)) 
                && charsSecond.containsKey(combinedString.charAt(c))) {
                    freqDifference = Math.abs(charsFirst.get(combinedString.charAt(c))
                                            - charsSecond.get(combinedString.charAt(c)));
                }
                else if (charsFirst.containsKey(combinedString.charAt(c)) 
                && !charsSecond.containsKey(combinedString.charAt(c))) {
                    freqDifference = charsFirst.get(combinedString.charAt(c));
                }
                if (!charsFirst.containsKey(combinedString.charAt(c)) 
                && charsSecond.containsKey(combinedString.charAt(c))) {
                    freqDifference = charsSecond.get(combinedString.charAt(c));
                }
                uniqueChars.put(combinedString.charAt(c), freqDifference);
            }
            
            numOfDeletions += freqDifference;
            freqDifference = 0;
        }
        
        return numOfDeletions;
    }
  
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.next();
        String b = in.next();
        System.out.println(numberNeeded(a, b));
    }
}
