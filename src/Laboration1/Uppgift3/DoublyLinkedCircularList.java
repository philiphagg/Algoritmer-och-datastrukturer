package Laboration1.Uppgift3;

import java.util.Iterator;
import java.util.Scanner;

public class DoublyLinkedCircularList<T> implements Iterable<T> {
    Node<T> head;
    int size;

    @Override
    public Iterator<T> iterator() {
        return new dlcIterator();
    }
    private class dlcIterator implements Iterator<T>{
        private Node<T> current = head.next;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            current = head;
            current = current.next;
            return current.data;
        }
    }

    private class Node<T>{
        private Node<T> prev, next;
        private T data;

        private Node(){
            data = null;
            prev = null;
            next = null;
        }

        private Node(Node<T> prev, T data, Node<T> next) {
            this.prev = prev;
            this.data = data;
            this.next = next;
        }

        public Node(T data) {
            this.data = data;
        }

        public String toString(){
            return String.valueOf(data);
        }
    }

    public DoublyLinkedCircularList() {
        this.head = new Node<T>();
        this.size = 0;
    }
    public boolean isEmpty(){
        return size == 0;
    }

    public void enqueue(T data){
        if(isEmpty()){
            Node<T> newNode = new Node<T>();
            newNode.prev = head;
            head.prev = head.next = newNode;
            newNode.data = data;
        }else {
            Node<T> oldTail = head.next;
            Node<T> newNode = new Node<T>();
            newNode.data = data;
            head.next = newNode;
            newNode.prev = head;
            newNode.next = oldTail;
            oldTail.prev = newNode;

        }
        size++;

    }

    public T dequeue(){
        if(isEmpty())throw new IllegalArgumentException("Cant dequeue an empty queue");
        T data = head.prev.data;
        if(size == 1)
            head.prev = head.next = null;
        else{
            Node<T> oldNode = head.prev;
            head.prev.prev.next = head;
            head.prev = head.prev.prev;

        }
        size--;

        return data;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (isEmpty())
            sb.append("[]");
        else {
            Node<T> current;
            int i = 0;
            for (current = head.next; current.next != head /*null*/; current = current.next) {
                if(++i < size) {
                    sb.append('[');
                    sb.append(current.data);
                    sb.append("], ");

                }else{
                    break;
                }
            }
            sb.append("[" + current.data + "]");

        }
        return sb.toString();
    }

    public static void main(String[] args) {
        DoublyLinkedCircularList dlc = new DoublyLinkedCircularList();
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
                    dlc.enqueue(s.next());
                    System.out.println(dlc);
                    System.out.println();
                    s.nextLine();
                    break;
                case("d"):
                    dlc.dequeue();
                    System.out.println(dlc);
                    System.out.println();
                    break;
                case("s"):
                    System.out.println(dlc.size);
                    break;
                case("quit"):
                    System.exit(0);
                    break;
            }

        }

    }
}
