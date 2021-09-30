package Laboration2.Uppgift6;

import edu.princeton.cs.algs4.StdRandom;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


/**
 * Class responsible for quicksort, implementation with inspiration from princeton
 *
 *
 */
public class QuickSort {
        private static int PARTITION;
        private static boolean sorted;
        private static long time;

    /**
     * Main method that reads and writes to file and calls the sorting method
     *
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {

        String filePath = "src/InputFiles/1m.txt";
        Scanner in = new Scanner(new FileReader(filePath));
        int size = Integer.parseInt(in.nextLine());
        Integer[] numbers = new Integer[size];

        for(int i = 0; i < numbers.length; i++)
            numbers[i] = in.nextInt();

        long start = System.currentTimeMillis();
        sort(numbers);
        long end = System.currentTimeMillis();

        time = end-start;
        sorted = isSorted(numbers,0,numbers.length-1);
        System.out.println(time);
        System.out.println(sorted);
    }

    /**
     * shuffles the array and calls the recursive sorting method
     * @param a     array that will be shuffled and sorted
     */
    public static void sort(Integer[] a) {
        StdRandom.shuffle(a);
        sort(a, 0, a.length - 1);

    }

    /**
     * Method that sorts partitions of the array recursivly.
     *
     * @param a     Array that will  be sorted
     * @param lo    left index
     * @param hi    right index
     */
    private static void sort(Integer[] a, int lo, int hi) {
        if (hi <= lo) return;
        int j = partition(a, lo, hi);
        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
    }


    /**
     * Partitioning and swapping elements.
     * @param a     array that will be sorted
     * @param lo    left index
     * @param hi    right index
     * @return      returns partition index
     */
    private static int partition(Integer[] a, int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        Integer v = a[lo];
        while (true) {


            while (less(a[++i], v)) {
                if (i == hi) break;
            }


            while (less(v, a[--j])) {
                if (j == lo) break;
            }


            if (i >= j) break;

            exch(a, i, j);
        }


        exch(a, lo, j);


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

    /**
     * method for debugging, checks if array was sorted
     * @param a     array that shall be checked
     * @param lo    left index
     * @param hi    right index
     * @return
     */
    private static boolean isSorted(Integer[] a, int lo, int hi){
        for (int i = lo + 1; i <= hi; i++)
            if (a[i] < a[i-1]) return false;
        return true;
    }

}