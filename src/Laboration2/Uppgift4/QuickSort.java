package Laboration2.Uppgift4;

import edu.princeton.cs.algs4.Quick;

public class QuickSort {
    public static void main(String[] args) {
        Integer arr[] = {1233,21432,123,32,53424,234,324,32432,42,34,23423};
        Quick.sort(arr);

        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i]+ " ");
        }
    }
}
