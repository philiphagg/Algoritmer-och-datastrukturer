package Laboration2.Uppgift6;

import edu.princeton.cs.algs4.StdRandom;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class QuickSort {
        private static int PARTITION;
        private static boolean sorted;
        private static long time;

    public static void main(String[] args) throws IOException {
        FileWriter writer = new FileWriter("src/Laboration2/Uppgift5/1M.csv");

        String filePath = "src/InputFiles/1M.txt";
        Scanner in = new Scanner(new FileReader(filePath));
        int size = Integer.parseInt(in.nextLine());
        Integer[] numbers = new Integer[size];

        for(int i = 0; i < numbers.length; i++)
            numbers[i] = in.nextInt();

        sort(numbers);

        sorted = isSorted(numbers,0,numbers.length-1);
        System.out.println(sorted);
    }


    public static void sort(Integer[] a) {
        StdRandom.shuffle(a);
        sort(a, 0, a.length - 1);

    }

    private static void sort(Integer[] a, int lo, int hi) {
        if (hi <= lo) return;
        int j = partition(a, lo, hi);
        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
    }



    // partition the subarray a[lo..hi] so that a[lo..j-1] <= a[j] <= a[j+1..hi]
    // and return the index j.
    private static int partition(Integer[] a, int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        Integer v = a[lo];
        while (true) {

            // find item on lo to swap
            while (less(a[++i], v)) {
                if (i == hi) break;
            }

            // find item on hi to swap
            while (less(v, a[--j])) {
                if (j == lo) break;      // redundant since a[lo] acts as sentinel
            }

            // check if pointers cross
            if (i >= j) break;

            exch(a, i, j);
        }

        // put partitioning item v at a[j]
        exch(a, lo, j);

        // now, a[lo .. j-1] <= a[j] <= a[j+1 .. hi]
        return j;
    }


    // is v < w ?
    private static boolean less(Integer v, Integer w) {
        if (v == w) return false;   // optimization when reference equals
        return v.compareTo(w) < 0;
    }

    // exchange a[i] and a[j]
    private static void exch(Integer[] a, int i, int j) {
        Integer swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }
    private static boolean isSorted(Integer[] a, int lo, int hi){
        for (int i = lo + 1; i <= hi; i++)
            if (a[i] < a[i-1]) return false;
        return true;
    }

}