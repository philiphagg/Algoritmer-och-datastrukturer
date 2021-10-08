package Laboration4.Uppgift1;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Stack;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DFS {
    private boolean[] marked;    // marked[v] = is there an s-v path?
    private int[] edgeTo;        // edgeTo[v] = last edge on s-v path
    private final int s;         // source vertex


    public DFS(Graphi G, int s){
        this.s = s;
        edgeTo = new int[G.getV()];
        marked = new boolean[G.getV()];
        validateVertex(s);
        dfs(G,s);
    }

    public boolean hasPathTo(int v) {
        validateVertex(v);
        return marked[v];
    }
    public Iterable<Integer> pathTo(int v) {
        validateVertex(v);
        if (!hasPathTo(v)) return null;
        Stack<Integer> path = new Stack<Integer>();
        for (int x = v; x != s; x = edgeTo[x])
            path.push(x);
        path.push(s);
        return path;
    }

     void dfs(Graphi G, int v) {
        marked[v] = true;
        for(int w : G.adj(v)){
            if(!marked[w]){
                edgeTo[w] = v;
                dfs(G,w);
            }
        }
    }
     void validateVertex(int v) {
        int V = marked.length;
        if (v < 0 || v >= V)
            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V-1));
    }


}
