package Laboration2.Uppgift6;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class QuickSortM3 {
    private static int PARTITION;
    private static boolean sorted;
    private static long time;


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


    private static boolean isSorted(int[] a, int lo, int hi){
        for (int i = lo + 1; i <= hi; i++)
            if (a[i] < a[i-1]) return false;
        return true;
    }
    private static int[] scanFile() throws FileNotFoundException {
        String filePath = "src/InputFiles/1m.txt";
        Scanner in = new Scanner(new FileReader(filePath));
        int size = Integer.parseInt(in.nextLine());
        int[] numbers = new int[size];

        for(int i = 0; i < numbers.length; i++)
            numbers[i] = in.nextInt();
        return numbers;
    }

    private static int partition(int[] a, int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        int v = a[lo];
        while (true) {

            // find item on lo to swap
            while (less(a[++i], v))
                if (i == hi) break;

            // find item on hi to swap
            while (less(v, a[--j]))
                if (j == lo) break;      // redundant since a[lo] acts as sentinel

            // check if pointers cross
            if (i >= j) break;

            exch(a, i, j);
        }

        // put v = a[j] into position
        exch(a, lo, j);

        // with a[lo .. j-1] <= a[j] <= a[j+1 .. hi]
        return j;
    }
    public static void sort(int[] a) {
        // StdRandom.shuffle(a);

        sort(a, 0, a.length - 1);

    }
    private static void sort(int[] a, int lo, int hi) {
        int n = hi - lo + 1;
        if (hi <= lo) return;

        int m = median3(a, lo, lo + n/2, hi);
        exch(a, m, lo);

        int j = partition(a, lo, hi);

        sort(a, lo, j-1);
        sort(a, j+1, hi);
    }
    private static int median3(int[] a, int i, int j, int k) {
        return (less(a[i], a[j]) ?
                (less(a[j], a[k]) ? j : less(a[i], a[k]) ? k : i) :
                (less(a[k], a[j]) ? j : less(a[k], a[i]) ? k : i));
    }
    private static boolean less(int v, int w) {
        return v < w;
    }

    private static void exch(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}

