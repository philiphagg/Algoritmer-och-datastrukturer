package Laboration1.Uppgift4;


import static Laboration1.Util.Util.printInfoCll;

class Main {
    public static void main(String[] args) {
        CircularLinkedList cll = new CircularLinkedList();

        printCll(cll);
        for(int i = 0; i < 10; i++) {
            cll.addFirst(i);
            //printCll(cll);
        }


        for(int i = 'a'; i <'g'; i++) {
            cll.addLast((char)i);
            //printCll(cll);
        }
        System.out.println("Node removed: "+cll.removeFirst());
        printCll(cll);
        System.out.println("Node removed: "+cll.removeLast());
        printCll(cll);


    }

    public static void printCll(CircularLinkedList cll){
        System.out.println(cll.printCircularLinkedList());
        printInfoCll(cll);

    }
}
