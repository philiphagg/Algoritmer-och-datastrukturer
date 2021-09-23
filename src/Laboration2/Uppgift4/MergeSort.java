package Laboration2.Uppgift4;

import edu.princeton.cs.algs4.Merge;

public class MergeSort {
    public static void main(String[] args) {
        Integer arr[]  = {123,312,5342,34,534,3424132,321,3425,3452,534,342,3421132,342,234};
        Merge.sort(arr);

        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i]+ " ");
        }

    }
}
