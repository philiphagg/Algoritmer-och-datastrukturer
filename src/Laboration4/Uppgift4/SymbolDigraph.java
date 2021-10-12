package Laboration4.Uppgift4;

import Laboration4.Uppgift1.Graphi;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.ST;

public class SymbolDigraph {
     public ST<String, Integer> st;  // string -> index
     public String[] keys;           // index  -> string
     Digraph graph;             // the underlying graph
     static final String NEWLINE = System.getProperty("line.separator");

    public SymbolDigraph(String filename, String delimiter) {
        st = new ST<String, Integer>();
        In in = new In(filename);

        while (!in.isEmpty()) {
            String[] a = in.readLine().split(delimiter);
            for (int i = 0; i < a.length; i++) {
                if (!st.contains(a[i]))
                    st.put(a[i], st.size());
            }
        }

        keys = new String[st.size()];
        for (String name : st.keys()) {
            keys[st.get(name)] = name;
        }


        graph = new Digraph(st.size());
        in = new In(filename);
        while (in.hasNextLine()) {
            String[] a = in.readLine().split(delimiter);
            int v = st.get(a[0]);
            for (int i = 1; i < a.length; i++) {
                int w = st.get(a[i]);
                graph.addEdge(v, w);
            }
        }
    }
    public boolean contains(String s) {
        return st.contains(s);
    }
    @Deprecated
    public int index(String s) {
        return st.get(s);
    }
    public int indexOf(String s) {
        return st.get(s);
    }
    @Deprecated
    public String name(int v) {
        validateVertex(v);
        return keys[v];
    }


    public String nameOf(int v) {
        validateVertex(v);
        return keys[v];
    }


    @Deprecated
    public Digraph G() {
        return graph;
    }

    public Digraph graph() {
        return graph;
    }


    private void validateVertex(int v) {
        int V = graph.V();
        if (v < 0 || v >= V)
            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V-1));
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(graph.V() + " vertices, " + graph.E() + " edges " + NEWLINE);
        for (int v = 0; v < graph.V(); v++) {
            s.append(keys[v] + ": ");
            for (int w : graph.adj[v]) {
                s.append(keys[w] + " ");
            }
            s.append(NEWLINE);
        }
        return s.toString();
    }


}
