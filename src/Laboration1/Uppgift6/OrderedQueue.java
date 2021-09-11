package Laboration1.Uppgift6;


import Laboration1.Uppgift5.GeneralQueue;

import java.util.Iterator;
import java.util.Scanner;

//TODO 6. Implement an ordered queue based on one of the implementations above. The elements stored in the queue should be integer values. The elements should be ordered at insertion so that all elements are stored in ascending order starting from when you insert the first element and in all following insertions. You should print the content of the list after each insertion/deletion of an element.
public class OrderedQueue implements Iterable {
    int size;
    Node head;

    public OrderedQueue() {
        this.size = 0;
        this.head = null;
    }

    @Override
    public Iterator iterator() {
        return new OrderedQueueIterator();
    }


    private class Node{
        private int data;
        private Node next;

        public Node(int data) {
            this.data = data;
        }
        public Node(){
            this.data = 0;
            this.next = null;
        }

    }

    public OrderedQueue(int size, Node head, Node tail) {
        this.size = size;
        this.head = head;
    }
    public boolean isEmpty(){
        return size == 0;
    }



    public void enqueue(int data){

        if(isEmpty()){
            addFirstNode(data);
        }else if(size == 1){
            addFirstOrLast(data);
        }
        else{
            int indexOfInsertion = findIndex(data);
            if (indexOfInsertion == 0)
                addFirst(data);
            else{
                addAtIndex(data, indexOfInsertion);
            }
        }
        size++;
    }
    public int dequeue(int k){
        if(k < 0 || k > size || isEmpty()) throw new IllegalArgumentException();
        int i;
        int data;
        if(size == 1){
            data = head.data;
            head = null;
            size--;
            return data;
        }if(k == 1){
            data = head.data;
            head = head.next;
            size--;
        }else {
            Node indexNode;
            for (i = 1, indexNode = head; i != k - 1; i++) {
                indexNode = indexNode.next;
            }
            data = indexNode.next.data;
            indexNode.next = indexNode.next.next;
            size--;
        }

        return data;
    }

    private void addFirstOrLast(int data) {
        if(data <= head.data){
            addFirst(data);
        }else{
            addLast(data);
        }
    }

    private void addAtIndex(int data, int indexOfInsertion) {
        if(indexOfInsertion + 1 == size)
        {
            addLast(data);
        }else {
            OrderedQueueIterator oqi = new OrderedQueueIterator();
            for (int i = 0; i != indexOfInsertion - 1; i++) {
                oqi.next();
            }
            Node tail = oqi.current.next;
            Node insertionNode = new Node(data);
            oqi.current.next = insertionNode;
            insertionNode.next = tail;
        }
    }

    private int findIndex(int data) {
        OrderedQueueIterator oqi = new OrderedQueueIterator();
        int k = 0;
        while(oqi.hasNext()){
            if(oqi.comparisson(data)){
                k++;
                oqi.next();
            }
            else{
                break;
            }
        }
        return k;
    }

    private void addFirstNode(int data) {
        head = new Node(data);
        head.next = null;
    }

    private void addFirst(int data) {
        Node oldFirst = head;
        head = new Node(data);
        head.next = oldFirst;
    }

    private void addLast(int data) {
        if(size == 1){
            head.next = new Node(data);
        }
        else{
            OrderedQueueIterator oqi = new OrderedQueueIterator();
            findLast(oqi);
            oqi.current.next = new Node(data);
        }

    }

    private void findLast(OrderedQueueIterator oqi) {
        while(oqi.hasNext()){
            oqi.next();
        }
    }

    public void printQueue(){
        if(isEmpty())
            System.out.println("[]");
        else{
            Node current;
            for (current = head; current.next != null; current = current.next) {
                System.out.print('[');
                System.out.print(current.data);
                System.out.print("], ");
            }
            System.out.print("[" + current.data + "]");
        }


    }

    private class OrderedQueueIterator implements Iterator {
        private Node current = head;

        @Override
        public boolean hasNext() {
            return current.next != null;
        }

        @Override
        public Object next() {
            return current = current.next;
        }
        public boolean comparisson(int data){
            return current.data < data;
        }
    }

    public static void main(String[] args) {
        OrderedQueue queue = new OrderedQueue();
        Scanner s = new Scanner(System.in);
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
                    System.out.print("enter index: ");
                    queue.dequeue(Integer.parseInt(s.next()));
                    queue.printQueue();
                    System.out.println();
                    s.nextLine();
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
