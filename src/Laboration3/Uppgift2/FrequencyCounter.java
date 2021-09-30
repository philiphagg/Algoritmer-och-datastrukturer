package Laboration3.Uppgift2;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class FrequencyCounter {

        public static void main(String[] args) throws FileNotFoundException {
            int distinct = 0, words = 0;
            System.setIn(new FileInputStream("src/Laboration3/Uppgift1/polished-gutenberg.txt"));
            BinarySearchST<String, Integer> st = new BinarySearchST<>(1000);

            // compute frequency counts
            while (!StdIn.isEmpty() && words < 1000) {
                String key = StdIn.readString();
                words++;
                if (st.contains(key)) {
                    st.put(key, st.get(key) + 1);
                }
                else {
                    st.put(key, 1);
                    distinct++;
                }
            }

            // find a key with the highest frequency count
            String max = "";
            st.put(max, 0);
            for (String word : st.keys()) {
                if (st.get(word) > st.get(max))
                    max = word;
            }

            StdOut.println(max + " " + st.get(max));
            StdOut.println("distinct = " + distinct);
            StdOut.println("words    = " + words);
        }
}



