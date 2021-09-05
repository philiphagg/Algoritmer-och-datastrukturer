package Laboration1.Uppgift3;

public class Main {
    public static void main(String[] args) {
        DoubleLinkedCircularList dcl = new DoubleLinkedCircularList();
        System.out.println("Size: " +dcl.size);

        for(int i = 1; i <= 10; i++)
            dcl.enqueue(i);

        System.out.println("First: " +dcl.getFirstInQueue());
        System.out.println("Last: " +dcl.getLastInQueue());
        System.out.println("Size: " +dcl.size);
        System.out.println(dcl.printQueue());
        System.out.println("Removed Item: "+dcl.dequeue()+ ", Size: " +dcl.size);
        System.out.println(dcl.printQueue());
        System.out.println("Removed Item: "+dcl.dequeue()+ ", Size: " +dcl.size);
        dcl.enqueue('A');
        dcl.enqueue('B');
        System.out.println(dcl.size);

        System.out.println(dcl.printQueue());
        for(int i = 0; i < 10; i++){
            dcl.dequeue();
            System.out.println(dcl.printQueue());
        }




    }

}
