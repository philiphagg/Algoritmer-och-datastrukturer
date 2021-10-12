package Laboration4.Uppgift4;

import Laboration4.Uppgift1.DFS;
import Laboration4.Uppgift1.Graphi;
import Laboration4.Uppgift1.SymbolGraph;
import edu.princeton.cs.algs4.StdOut;

import java.util.Scanner;

public class L4U4Main {
    public static void main(String[] args) {
        SymbolDigraph sg = new SymbolDigraph("src/InputFiles/labb4.txt", " ");
        Digraph G = sg.graph();


        String s, v;
        Scanner sc = new Scanner(System.in);
        System.out.println("Where will you start?");
        s = sc.nextLine().toUpperCase();
        DFS d = new DFS(G, sg.st.get(s));
        System.out.println("Where do you want to go?");
        v = sc.nextLine().toUpperCase();

        if(d.hasPathTo(sg.st.get(v))) {
            StdOut.printf("%s to %s:  ", s, v);
            for (int x : d.pathTo(sg.st.get(v))) {
                if (x == sg.st.get(v)) StdOut.print(sg.keys[x]);
                else StdOut.print(sg.keys[x]+"-");
            }
        }else
            StdOut.printf("%d to %d:  not connected\n", s, v);

    }

}

