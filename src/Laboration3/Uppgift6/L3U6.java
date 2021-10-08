package Laboration3.Uppgift6;
import edu.princeton.cs.algs4.SeparateChainingHashST;
import edu.princeton.cs.algs4.StdIn;

import java.io.*;
import java.util.Scanner;

public class L3U6<Key,Value> {


    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.setIn(new FileInputStream("src/Laboration3/Uppgift1/polished-gutenberg.txt"));
        SeparateChainingHashST<String,Integer> st = new SeparateChainingHashST<>();

        InsertKeys(st);
        String inputWord;
        Integer wordValue;
        while(true){
            System.out.println("Please enter a word: ");
            inputWord = sc.nextLine();
            wordValue = st.get(inputWord);
            if(wordValue == null)
                System.out.println(inputWord+" occors 0 times");
            else
                System.out.println(inputWord+" occors " +wordValue+ " times");

        }



    }

    private static void InsertKeys(SeparateChainingHashST<String, Integer> st) {
        while (!StdIn.isEmpty()) {
            String key = StdIn.readString().toLowerCase();
            if (st.contains(key)) {
                st.put(key, st.get(key) + 1);
            }
            else {
                st.put(key, 1);
            }
        }
    }
}
