package Laboration1.Uppgift3;

public class Main {
    public static void main(String[] args) {
        DoubleLinkedCircularList dcl = new DoubleLinkedCircularList();
        System.out.println("Size: " +dcl.size);

        for(int i = 1; i <= 100; i++)
            dcl.enqueue(i);

        System.out.println("First: " +dcl.getFirst());
        System.out.println("Last: " +dcl.getLast());
        System.out.println("Size: " +dcl.size);


    }

}
