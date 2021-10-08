package Laboration3.Uppgift3;

import Laboration3.Uppgift2.BinarySearchST;
import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

public class L3U5 {

    public static void main(String[] args) throws FileNotFoundException {

        int distinct = 0, words = 0;
        System.setIn(new FileInputStream("src/Laboration3/Uppgift1/polished-gutenberg.txt"));
        BinarySearchST<String, Integer> st = new BinarySearchST<>(1000);

        // compute frequency counts
        while (!StdIn.isEmpty()) {
            String key = StdIn.readString();
            words++;
            if (st.contains(key)) {
                st.put(key, st.get(key) + 1);
            }
            else {
                st.put(key, 1);
                distinct++;
            }
        }

        Bag<Integer> hashCodes = new Bag<>();
        for(String word : st.keys())
            hashCodes.add((word.hashCode() & 0x7fffffff) % 11);

        int[] hashDistribution = new int [11];

        for(Object value : hashCodes)
            hashDistribution[(int) value] ++;

        for(int i = 0; i < hashDistribution.length; i++){
            System.out.println(i+": " +"\t" +hashDistribution[i]);
        }
        System.out.print("{");
        for(int i = 0; i < hashDistribution.length;i++){
            System.out.print(hashDistribution[i]+",");
        }
        System.out.print("}");


    }
}