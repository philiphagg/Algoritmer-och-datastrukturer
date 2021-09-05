package Laboration1.Uppgift5;

public class Main {

    public static void main(String[] args) {
        GeneralQueue gq = new GeneralQueue();
        for(int i = 0; i < 10; i++){
            gq.enqueue(i);
            System.out.println(gq.printQueue());
        }


    }

}
