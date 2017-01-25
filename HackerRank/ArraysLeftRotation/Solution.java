import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    
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
    
    public static void printArray(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }

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
