import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
* Rotates or shifts the elements of an array to the left k times. Elements that 
* "overflow" out of the array are then inserted to the right end.
*/
public class Solution {
    
    /**
    * Begins iterating throught the input array at position k and to n, appending each
    * element to the output array. Once n is reached, the iteration stops and starts again
    * at position 0, all the way to k - 1. 
    * 
    * In this case, there is really no worst or best case scenario as it always depends on
    * the input size (always have to iterate n times), so the Big O would be O(n).
    * 
    * @param n The number of elements in the input array
    * @param k The number of times the elements should rotate or shift left
    * @param a The input array
    * @return The output array
    */
    public static int[] leftRotateArray(int n, int k, int[] a) {
        int[] out = new int[n];
        for (int a_pos = k, out_pos = 0; a_pos < n; a_pos++, out_pos++) {
            out[out_pos] = a[a_pos];
        }
        for (int a_pos = 0, out_pos = (n-k); a_pos < k; a_pos++, out_pos++) {
            out[out_pos] = a[a_pos];
        }
        return out;
    }
    
    /**
    * Iterates through the rotated array and prints it out.
    * Format: "a b c d e " where the element is printed and a space at each
    * iteration.
    * 
    * @param a The rotated array
    */
    public static void printArray(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }

    /**
    * Takes a user input and parses it into an array. This array is then left
    * rotated and printed out.
    */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int a[] = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        
        int[] out = leftRotateArray(n, k, a);
        printArray(out);
    }
}
