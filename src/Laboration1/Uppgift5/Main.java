package Laboration1.Uppgift5;

public class Main {

    public static void main(String[] args) {
        GeneralQueue gq = new GeneralQueue();
        for(int i = 10; i > 0; i--){
            gq.enqueue(i);
            System.out.println(gq.printQueue());

        }
        System.out.println("removed element: "+gq.dequeue(4));

        System.out.println(gq.printQueue());

    }

}
