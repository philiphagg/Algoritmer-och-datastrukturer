package Laboration2.Uppgift5;

import edu.princeton.cs.algs4.Insertion;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class MergeSort {
    private static int CUTOFF;
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

        writer.write("Cutoff, time\n");
        for(CUTOFF = 0; CUTOFF <= 30; CUTOFF++){
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

    private static void sort(Integer[] a){
        int [] aux = new int[a.length];
        sort(a,aux,0,a.length-1);
    }
    private static void sort(Integer[] a, int[] aux, int lo, int hi) {
        int n = hi - lo + 1;
        if (hi <= lo + CUTOFF){
            insertionSort(a,lo,hi);
            return;
        }
        if(hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        sort(a, aux, lo, mid);
        sort(a, aux, mid + 1, hi);
        merge(a, aux, lo, mid, hi);
    }

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
    private static boolean isSorted(Integer[] a, int lo, int hi){
        for (int i = lo + 1; i <= hi; i++)
            if (a[i] < a[i-1]) return false;
        return true;

    }
    private static void insertionSort(Integer[] a, int lo, int hi) {
        for (int i = lo; i <= hi; i++)
            for (int j = i; j > lo && less(a[j], a[j-1]); j--)
                exch(a, j, j-1);
    }

    private static boolean less(Integer v, Integer w) {
        return v < w;
    }

    private static void exch(Integer[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }


}
