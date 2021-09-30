package Laboration2.Uppgift6;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;


/**
 * class that uses median 3 implementation to quicksort
 */
public class QuickSortM3 {
    private static int PARTITION;
    private static boolean sorted;
    private static long time;

    /**
     * Main function that executes the program. scans input from file
     * and outputs via system.out
     *
     * @param args
     * @throws FileNotFoundException    if the file was not found
     */
    public static void main(String[] args) throws FileNotFoundException {


        int[] numbers = scanFile();

        long start = System.currentTimeMillis();
        sort(numbers);
        long end = System.currentTimeMillis();
        sorted = isSorted(numbers,0,numbers.length-1);
        time = end-start;
        System.out.println("array is sorted? :" +sorted);
        System.out.println(time);

    }


    /**
     * method for debugging, checing if the array was sorted
     * @param a array to sort
     * @param lo left index
     * @param hi right index
     * @return true if sorted
     */
    private static boolean isSorted(int[] a, int lo, int hi){
        for (int i = lo + 1; i <= hi; i++)
            if (a[i] < a[i-1]) return false;
        return true;
    }

    /**
     * method that scans file and put's it in an array.
     * @return  the array that was created
     * @throws FileNotFoundException    if the file was not found.
     */
    private static int[] scanFile() throws FileNotFoundException {
        String filePath = "src/InputFiles/1m.txt";
        Scanner in = new Scanner(new FileReader(filePath));
        int size = Integer.parseInt(in.nextLine());
        int[] numbers = new int[size];

        for(int i = 0; i < numbers.length; i++)
            numbers[i] = in.nextInt();
        return numbers;
    }

    /**
     * method that partitions and sorts the array.
     * @param a array to be sorted
     * @param lo    left index
     * @param hi    right index
     * @return      partitioning index
     */
    private static int partition(int[] a, int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        int v = a[lo];
        while (true) {

            // find item on lo to swap
            while (less(a[++i], v))
                if (i == hi) break;


            while (less(v, a[--j]))
                if (j == lo) break;

            // check if pointers cross
            if (i >= j) break;

            exch(a, i, j);
        }


        exch(a, lo, j);


        return j;
    }

    /**
     * Calls the recurssive sorting method.
     * @param a
     */
    public static void sort(int[] a) {
        sort(a, 0, a.length - 1);
    }

    /**
     * Creates partitions recursivly and taking advantage
     * of the median 3 as partitioning element.
     * @param a     array that shall be sorted
     * @param lo    left index
     * @param hi    right index
     */
    private static void sort(int[] a, int lo, int hi) {
        int n = hi - lo + 1;
        if (hi <= lo) return;

        int m = median3(a, lo, lo + n/2, hi);
        exch(a, m, lo);

        int j = partition(a, lo, hi);

        sort(a, lo, j-1);
        sort(a, j+1, hi);
    }

    /**
     * Method that determines wich element that is the median value.
     * @param a array to be checked
     * @param i low index (left index)
     * @param j mid index (mid index)
     * @param k high index (right index)
     * @return
     */
    private static int median3(int[] a, int i, int j, int k) {
        return (less(a[i], a[j]) ?
                (less(a[j], a[k]) ? j : less(a[i], a[k]) ? k : i) :
                (less(a[k], a[j]) ? j : less(a[k], a[i]) ? k : i));
    }

    /**
     * checks if w greater than v
     * @param v element for comparission
     * @param w element for comparission
     * @return true if w greater than v
     */
    private static boolean less(int v, int w) {
        return v < w;
    }

    /**
     * Excanges elements in the array, with index.
     * @param a array to perform exchanges
     * @param i first index
     * @param j second index
     */
    private static void exch(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}

