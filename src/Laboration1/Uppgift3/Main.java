package Laboration1.Uppgift3;

public class Main {
    public static void main(String[] args) {
        DoubleLinkedCircularList dcl = new DoubleLinkedCircularList();
        System.out.println("Size: " +dcl.size);

        for(int i = 1; i <= 10; i++)
            dcl.enqueue(i);

        dcl.dequeue();



    }

}
