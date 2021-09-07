package Laboration1.Uppgift6;

public class Main {

    public static void main(String[] args) {
        OrderedQueue OQ = new OrderedQueue();
        System.out.println(OQ.printQueue());

        for(int i = 10; i > 0; i--){
            if(i == 5 || i == 3 || i == 10)
                continue;
            addItem(OQ, i);
        }
        addItem(OQ, 10);




    }

    private static void addItem(OrderedQueue OQ, int data) {
        OQ.enqueue(data);
        System.out.println(OQ.printQueue());
    }
}
