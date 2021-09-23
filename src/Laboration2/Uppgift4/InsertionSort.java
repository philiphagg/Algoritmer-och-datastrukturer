package Laboration2.Uppgift4;

import edu.princeton.cs.algs4.Insertion;
import edu.princeton.cs.algs4.Merge;
import edu.princeton.cs.algs4.StdIn;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Scanner;

public class InsertionSort {
    public static void main(String[] args) throws FileNotFoundException {
        String filePath = "src/InputFiles/inputfile1000.txt";

        Scanner in = new Scanner(new FileReader(filePath));

        int size = Integer.parseInt(in.nextLine());
        Integer[] numbers = new Integer[size];

        for(int i = 0; i < numbers.length; i++)
            numbers[i] = in.nextInt();

        long start = System.currentTimeMillis();
        Insertion.sort(numbers);
        long end = System.currentTimeMillis();

        System.out.println("Merge sort time : "+(end-start)+ "ms; input size: "+size);
        System.out.println(Arrays.toString(numbers));
    }
}
