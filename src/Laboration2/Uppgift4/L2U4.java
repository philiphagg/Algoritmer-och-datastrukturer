package Laboration2.Uppgift4;



import edu.princeton.cs.algs4.Insertion;
import edu.princeton.cs.algs4.Merge;
import edu.princeton.cs.algs4.Quick;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


/**
 * Class that compares execution time for three sorting algorithms, quicksort,mergesort,insertionsort
 * takes input as a file and tests all of them iterative. Used princetons implementation
 * to get the most accurate and fair comparisson as possible.
 *
 */
public class L2U4 {


    public static void main(String[] args) throws IOException {
        FileWriter writer = new FileWriter("src/Laboration2/Uppgift4/merge-quick-100-million.txt");

        String[] filenames = {"inputfile100.txt", "inputfile1000.txt",
                            "inputfile10000.txt", "inputfile100000.txt",
                            "inputfile1000000.txt", "inputfile10000000.txt", "inputfile100000000.txt"};




        writer.write("Algoritm,tid ms, antal element\n");
        for(int i = 6; i < filenames.length;i++){
            for(int j = 0; j < 1 ;j++){
            System.out.println(i);
                writer.write(quickSort(filenames[i]));
                writer.write(insertionSort(filenames[i]));
                writer.write(mergeSort(filenames[i]));
                System.out.println("i:"+i+"j:"+j);
            }
        }

        writer.close();
        System.out.println("done");


    }

    /**
     * princetons implementation of quicksort that reads input array from file
     *
     *
     * @param filename  name of the file that shall be used as input
     * @return          a string that will be written to file
     * @throws FileNotFoundException    throws exception if file not found
     */
    public static String quickSort(String filename) throws FileNotFoundException {

        String alogName = "Quicksort";
        String filePath = "src/InputFiles/"+filename;

        Scanner in = new Scanner(new FileReader(filePath));
        int size = Integer.parseInt(in.nextLine());
        Integer[] numbers = new Integer[size];

        for(int i = 0; i < numbers.length; i++)
            numbers[i] = in.nextInt();

        long start = System.currentTimeMillis();
        Quick.sort(numbers);
        long end = System.currentTimeMillis();


        System.out.println(alogName+","+(end-start)+ ","+size+",\n");
        return alogName+","+(end-start)+ ","+size+",\n";

    }

    /**
     * princetons implementation of Merge sort that reads input array from file
     *
     *
     * @param filename  name of the file that shall be used as input
     * @return          a string that will be written to file
     * @throws FileNotFoundException    throws exception if file not found
     */
    public static String mergeSort(String filename) throws FileNotFoundException {
        String filePath = "src/InputFiles/"+filename;
        String alogName = "Mergesort";
        Scanner in = new Scanner(new FileReader(filePath));

        int size = Integer.parseInt(in.nextLine());
        Integer[] numbers = new Integer[size];

        for(int i = 0; i < numbers.length; i++)
            numbers[i] = in.nextInt();

        long start = System.currentTimeMillis();
        Merge.sort(numbers);
        long end = System.currentTimeMillis();

        System.out.println(alogName+","+(end-start)+ ","+size+",\n");
        return alogName+","+(end-start)+ ","+size+",\n";

    }

    /**
     * princetons implementation of Insertion sort that reads input array from file
     *
     *
     * @param filename  name of the file that shall be used as input
     * @return          a string that will be written to file
     * @throws FileNotFoundException    throws exception if file not found
     */
    public static String insertionSort(String filename) throws FileNotFoundException {
        String filePath = "src/InputFiles/"+filename;
        String alogName = "insertionSort";
        Scanner in = new Scanner(new FileReader(filePath));

        int size = Integer.parseInt(in.nextLine());
        Integer[] numbers = new Integer[size];

        for(int i = 0; i < numbers.length; i++)
            numbers[i] = in.nextInt();

        long start = System.currentTimeMillis();
        Insertion.sort(numbers);
        long end = System.currentTimeMillis();

        System.out.println(alogName+","+(end-start)+ ","+size+",\n");
        return alogName+","+(end-start)+ ","+size+",\n";


    }
}
