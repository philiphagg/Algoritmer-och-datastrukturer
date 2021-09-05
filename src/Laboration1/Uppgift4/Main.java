package Laboration1.Uppgift4;


import static Laboration1.Util.Util.printInfoCll;

class Main {
    public static void main(String[] args) {
        CircularLinkedList cll = new CircularLinkedList();
        printCll(cll);
        addTenItemsToFront(cll);
        addTenItemsToBack(cll);
        emptyQueueFront(cll);
        addTenItemsToBack(cll);
        emptyQueueBack(cll);


    }

    private static void emptyQueueBack(CircularLinkedList cll) {
        int listSize = cll.getSize();
        for(int i = 0; i < listSize; i++){
            cll.removeLast();
            printCll(cll);
        }
    }

    private static void emptyQueueFront(CircularLinkedList cll) {
        int listSize = cll.getSize();
        for(int i = 0; i < listSize; i++){
            cll.removeFirst();
            printCll(cll);
        }
    }

    public static void printCll(CircularLinkedList cll){
        System.out.println(cll.printCircularLinkedList());
        printInfoCll(cll);

    }
    public static void addTenItemsToFront(CircularLinkedList cll){
        for(int i = 0; i < 10; i++) {
            cll.addFirst(i);
            printCll(cll);
        }
    }
    public static void addTenItemsToBack(CircularLinkedList cll){
        for(int i = 'a'; i <'g'; i++) {
            cll.addLast((char)i);
            printCll(cll);
        }
    }
}
