package Laboration2.Uppgift4;

import edu.princeton.cs.algs4.Insertion;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        Integer [] arr = {12,3,45,54,23443,432,234,412,123};
        Insertion.sort(arr,0,arr.length);

        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i]+ " ");
        }

    }
}
