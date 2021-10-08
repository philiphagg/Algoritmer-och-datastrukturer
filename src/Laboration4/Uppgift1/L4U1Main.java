package Laboration4.Uppgift1;

import edu.princeton.cs.algs4.StdOut;

import java.util.Scanner;

public class L4U1Main {
    public static void main(String[] args) {
        SymbolGraph sg = new SymbolGraph("src/InputFiles/labb4.txt", " ");
        System.out.println(sg.graph().toString());
        System.out.println(sg.toString());

        Graphi G = sg.graph();

        System.out.println(sg.st.get("FL"));

        DFS dd = new DFS(G,1);
        printAllPaths(sg, G, dd, 1);
        String s, v;
        Scanner sc = new Scanner(System.in);

        System.out.println("Where will you start?");
        s = sc.nextLine();
        DFS d = new DFS(G, sg.st.get(s));
        System.out.println("Where do you want to go?");
        v = sc.nextLine();

        if(d.hasPathTo(sg.st.get(v))) {
            StdOut.printf("%s to %s:  ", s, v);
            for (int x : d.pathTo(sg.st.get(v))) {
                //if (x == sg.st.get(v)) StdOut.print(sg.keys[x]);
                /*else*/ StdOut.print(sg.keys[x]+"-");
            }
        }else
            StdOut.printf("%d to %d:  not connected\n", s, v);

    }




    private static void printAllPaths(SymbolGraph sg, Graphi G, DFS d, int s) {


        for (int v = 0; v < G.getV(); v++) {
            if (d.hasPathTo(v)) {
                StdOut.printf("%s to %s:  ", sg.keys[s], sg.keys[v]);
                for (int x : d.pathTo(v)) {
                    if (x == s) StdOut.print(sg.keys[x]);
                    else        StdOut.print("-" + sg.keys[x]);
                }
                StdOut.println();
            }

            else {
                StdOut.printf("%d to %d:  not connected\n", s, v);
            }

        }
    }


}

