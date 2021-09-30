package Laboration2.Uppgift5;

import edu.princeton.cs.algs4.Insertion;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;


/**
 *  Princetons implementation of merge sort. Class is responsible for
 *  reading a file as input, testing the algorithm with different cutoff values
 *  and prints the result to a csv file.
 */

public class MergeSort {
    private static int CUTOFF;
    private static boolean sorted;
    private static long time;

    /**
     * Main function that reads and writhe to files. test the algorithm with
     * different cutoffs and prints the results to a csv file.
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        FileWriter writer = new FileWriter("src/Laboration2/Uppgift5/1M.csv");

        writer.write("Cutoff, time\n");
        for(CUTOFF = 0; CUTOFF <= 30; CUTOFF++){

            String filePath = "src/InputFiles/1M.txt";
            Scanner in = new Scanner(new FileReader(filePath));
            int size = Integer.parseInt(in.nextLine());
            Integer[] numbers = new Integer[size];
            for(int i = 0; i < numbers.length; i++)
                numbers[i] = in.nextInt();


            long start = System.currentTimeMillis();
            sort(numbers);
            long end = System.currentTimeMillis();
            time = end-start;
            writer.write(CUTOFF+", "+time+"\n");
            //System.out.println(CUTOFF+", "+time+"\n");
            System.out.println("working....");
        }
        writer.close();
        System.out.println("done");

        //for debugging
        //System.out.println(sorted);




    }

    /**
     * Create auxiliary array that will be used for the sorting and merging.
     *
     * @param a     array for sorting
     */
    private static void sort(Integer[] a){
        int [] aux = new int[a.length];
        sort(a,aux,0,a.length-1);
    }

    /**
     * Recursive method for split phase and merge phase.
     * @param a     array for sorting
     * @param aux   auxiliary array
     * @param lo    left pointer value
     * @param hi    right pointer value
     */
    private static void sort(Integer[] a, int[] aux, int lo, int hi) {
        // cut off to insertion
        if (hi <= lo + CUTOFF){
            insertionSort(a,lo,hi);
            return;
        }


        int mid = lo + (hi - lo) / 2;
        sort(a, aux, lo, mid);
        sort(a, aux, mid + 1, hi);
        merge(a, aux, lo, mid, hi);
    }

    /**
     * Merging the arrays and placing the values in its correct index.
     *
     * @param a     array for sorting
     * @param aux   auxiliary array for temporary use
     * @param lo    left pointer value
     * @param mid   mid value
     * @param hi    right pointer value
     */
    private static void merge(Integer[] a, int[] aux, int lo, int mid, int hi) {
        // copy to aux[]
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }

        // merge back to a[]
        int i = lo, j = mid+1;
        for (int k = lo; k <= hi; k++) {
            if      (i > mid)              a[k] = aux[j++];
            else if (j > hi)               a[k] = aux[i++];
            else if ((aux[j] < aux[i]))    a[k] = aux[j++];
            else                           a[k] = aux[i++];
        }
        // return true if array is sorted, debugging purposes
        //sorted = isSorted(a,0,a.length-1);




    }

    /**
     * helper function to determine if the array was sorted ( debugging purposes )
     *
     * @param a     array that shall be checked
     * @param lo    i
     * @param hi    j
     * @return      boolean value sorted = true
     */
    private static boolean isSorted(Integer[] a, int lo, int hi){
        for (int i = lo + 1; i <= hi; i++)
            if (a[i] < a[i-1]) return false;
        return true;

    }

    /**
     * insertion sort that merge sort cutoffs to
     *
     * @param a     array that shall be sorted
     * @param lo    i
     * @param hi    j
     */
    private static void insertionSort(Integer[] a, int lo, int hi) {
        for (int i = lo; i <= hi; i++)
            for (int j = i; j > lo && less(a[j], a[j-1]); j--)
                exch(a, j, j-1);
    }

    /**
     * checks if w is greater than v
     * @param v
     * @param w
     * @return true if w is greater than v
     */
    private static boolean less(Integer v, Integer w) {
        return v < w;
    }

    /**
     * swaps element
     *
     * @param a array to swap the elements in
     * @param i index for first element
     * @param j index for second element
     */
    private static void exch(Integer[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }


}
