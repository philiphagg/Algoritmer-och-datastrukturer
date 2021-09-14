package Laboration1.Uppgift6;

import java.util.Iterator;
import java.util.Scanner;

public class OQ  {
    Node head;
    int size;



    private class Node{
        private Node prev, next;
        private int data;

        private Node(){
            data = 0;
            prev = null;
            next = null;
        }



        public Node(int data) {
            this.data = data;
        }

        public String toString(){
            return String.valueOf(data);
        }
    }

    public OQ() {
        this.head = new Node();
        this.size = 0;
    }
    public boolean isEmpty(){
        return size == 0;
    }

    public void enqueue(int data){
        if(isEmpty()) {
            head.prev = head.next = new Node();
            head.next.data = data;
            head.next.prev = head;
            head.next.next = head;
        }
        Node node = new Node();
        node.data = data;
        Node current = head.next;
        while(current != head && current.data < data){
            current = current.next;
        }
        node.next = current;
        node.prev = current.prev;
        node.prev.next = node;
        current.prev = node;
        size++;
    }

    public void dequeue(){

        size--;


    }

    public void printQueue() {
        if (isEmpty())
            System.out.print("[]");
        else {
            Node current;
            int i = 0;
            for (current = head.next; current.next != head /*null*/; current = current.next) {
                if(++i < size) {
                    System.out.print('[');
                    System.out.print(current.data);
                    System.out.print("], ");

                }else{
                    break;
                }
            }
            System.out.print("[" + current.data + "]");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        OQ queue = new OQ();
        Scanner s = new Scanner(System.in);
/*
        for(int i = 0; i < 5 ; i++){
            dlc.enqueue(i);
            dlc.printQueue();
        }

        dlc.dequeue();
        dlc.printQueue();

        System.out.println();
*/
        while(true){
            System.out.println("e: enqueue d: dequeue s: size quit: quit");
            String input = s.nextLine();
            switch (input){
                case("e"):
                    System.out.print("enter a value: ");
                    queue.enqueue(Integer.parseInt(s.next()));
                    queue.printQueue();
                    System.out.println();
                    s.nextLine();
                    break;
                case("d"):

                    break;
                case("s"):
                    System.out.println(queue.size);
                    break;
                case("quit"):
                    System.exit(0);
                    break;
            }

        }


    }
}
