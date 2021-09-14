package Laboration1.Uppgift6;


import Laboration1.Uppgift5.GeneralQueue;

import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

/**
 * representation of a queue that orders the elements of integers
 * in ascending order.
 */
public class OrderedQueue implements Iterable {
    int size;
    Node head;

    /**
     * constructor for creation of <code>OrderedQueue</code>
     */
    public OrderedQueue() {
        this.size = 0;
        this.head = null;
    }

    /**
     * iterator
     * @return custom made iterator
     */
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

    /**
     * checks if queue is empty
     * @return  if queue is empty
     */
    public boolean isEmpty(){
        return size == 0;
    }


    /**
     * adds element to the queue
     * @param data the element that will be added
     */
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

    /**
     * removes element from the queue at specific index
     * @param k index
     * @return  element that was removed
     */
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

    /**
     * string representation of the queue
     * @return the string representation
     */
    public String toString(){
        StringBuilder sb = new StringBuilder();
        if(isEmpty())
            sb.append("[]");
        else{
            Node current;
            for (current = head; current.next != null; current = current.next) {
                sb.append('[');
                sb.append(current.data);
                sb.append("], ");
            }
            sb.append("[" + current.data + "]");
        }

        return sb.toString();
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
        Random ran = new Random();


        System.out.println(queue);

        while(true){
            System.out.println("e: enqueue d: dequeue s: size quit: quit");
            String input = s.nextLine();
            switch (input){
                case("e"):
                    System.out.print("enter a value: ");
                    queue.enqueue(Integer.parseInt(s.next()));
                    System.out.println(queue);
                    System.out.println();
                    s.nextLine();
                    break;
                case("d"):
                    System.out.print("enter index: ");
                    queue.dequeue(Integer.parseInt(s.next()));
                    System.out.println(queue);
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
