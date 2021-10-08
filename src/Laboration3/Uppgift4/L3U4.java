package Laboration3.Uppgift4;

import Laboration3.Uppgift2.BinarySearchST;
import Laboration3.Uppgift3.BST;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class L3U4 {
    private static long startInsertion;
    private static long endInseartion;
    private static long startSearch;
    private static long endSearch;

    public static void main(String[] args) throws FileNotFoundException {
        BSST();
        //BST();
    }

    private static void BSST() throws FileNotFoundException {
        int distinct = 0, words = 0;
        System.setIn(new FileInputStream("src/Laboration3/Uppgift1/polished-gutenberg.txt"));

        BinarySearchST<String, Integer> st = new BinarySearchST<>(1000);

        startInsertion = System.currentTimeMillis();
        // compute frequency counts
        while (!StdIn.isEmpty()) {
            String key = StdIn.readString().toLowerCase();
            words++;
            if (st.contains(key)) {
                st.put(key, st.get(key) + 1);
            }
            else {
                st.put(key, 1);
                distinct++;
            }
        }
        endInseartion = System.currentTimeMillis();

        startSearch = System.currentTimeMillis();
        // find a key with the highest frequency count
        String max = "";
        st.put(max, 0);
        for (String word : st.keys()) {
            if (st.get(word) > st.get(max))
                max = word;
        }
        endSearch = System.currentTimeMillis();

        StdOut.println(max + " " + st.get(max));
        StdOut.println("distinct = " + distinct);
        StdOut.println("words    = " + words);
        System.out.println("Execution time searching "+(endSearch-startSearch)+"ms");
        System.out.println("Execution time Insertion "+(endInseartion-startInsertion)+"ms");
        System.out.println("Total time"+(endSearch-startInsertion));

    }
    public static void BST() throws FileNotFoundException {
        int distinct = 0, words = 0;
        System.setIn(new FileInputStream("src/Laboration3/Uppgift1/polished-gutenberg.txt"));

        BST<String, Integer> st = new BST<>();

        startInsertion = System.currentTimeMillis();
        // compute frequency counts
        while (!StdIn.isEmpty()) {
            String key = StdIn.readString().toLowerCase();
            words++;
            if (st.contains(key)) {
                st.put(key, st.get(key) + 1);
            } else {
                st.put(key, 1);
                distinct++;
            }
        }
        endInseartion = System.currentTimeMillis();
        startSearch = System.currentTimeMillis();
        // find a key with the highest frequency count
        String max = "";
        st.put(max, 0);
        for (String word : st.keys()) {
            if (st.get(word) > st.get(max))
                max = word;
        }
        endSearch = System.currentTimeMillis();

        StdOut.println("flest förekommande ord -> "+max +" med "+ st.get(max) +" Förekomster");
        StdOut.println("unika ord = " + distinct);
        StdOut.println("antal ord = " + words);

        System.out.println("Execution time searching "+(endSearch-startSearch)+"ms");
        System.out.println("Execution time Insertion "+(endInseartion-startInsertion)+"ms");
        System.out.println("Total time "+(endSearch-startInsertion));
    }

}

