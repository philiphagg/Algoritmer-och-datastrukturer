package Laboration1.Uppgift5;


import Laboration1.Uppgift6.OrderedQueue;

import java.util.Scanner;

/**
 * representation of a general queue
 *
 * @param <T>   for generic purposes
 */
public class GeneralQueue<T> {
    Node <T> last;
    int size;

    private class Node<T>{
        private Node<T> next;
        private T data;
    }

    /**
     * constructor for object creation
     */
    public GeneralQueue() {
        Node<T> last = null;
        int size = 0;
    }

    /**
     * getter of <code>GeneralQueue</code> object
     *
     * @return last node in queue
     */
    public Node<T> getLast() {
        return last;
    }

    /**
     * getter of <code>GeneralQueue</code> object
     *
     * @return size of queue
     */
    public int getSize() {
        return size;
    }
    public boolean isEmpty()
    {
        return size == 0;

    }

    /**
     * Adds element to the queue
     *
     * @param data that user wants to add
     */
    public void enqueue(T data){
        if(isEmpty()){
            last = new Node<>();
            last.data = data;
        }else{
            Node<T> oldFirst = last;
            last = new Node<>();
            last.data = data;
            last.next = oldFirst;
        }
        size++;

    }

    /**
     * removes element from a specific index of the queue
     *
     * @param k index that element should be dequeued.
     * @return  element that was removed
     */
    public T dequeue(int k){
        if(k < 0 || k > size || isEmpty()) throw new IllegalArgumentException();
        int i;
        T data;
        if(size == 1){
            data = last.data;
            last = null;
            size--;
            return data;
        }if(k == 1){
            data = last.data;
            last = last.next;
            size--;
        }else {
            Node indexNode;
            for (i = 1, indexNode = last; i != k - 1; i++) {
                indexNode = indexNode.next;
            }
            data = (T) indexNode.next.data;
            indexNode.next = indexNode.next.next;
            size--;
        }

        return data;
    }

    /**
     * String representation of the object
     * @return the string representation
     */
    public String toString(){
        StringBuilder sb = new StringBuilder();
        if(isEmpty())
            sb.append("[]");
        else{
            Node current;
            for (current = last; current.next != null; current = current.next) {
                sb.append('[');
                sb.append(current.data);
                sb.append("], ");
            }
            sb.append("[" + current.data + "]");
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        GeneralQueue GQ = new GeneralQueue();
        Scanner s = new Scanner(System.in);

        while(true){
            System.out.println("e: enqueue d: dequeue s: size quit: quit");
            String input = s.nextLine();
            switch (input){
                case("e"):
                    System.out.print("enter a value: ");
                    GQ.enqueue(s.next());
                    System.out.println(GQ);
                    System.out.println();
                    s.nextLine();
                    break;
                case("d"):
                    System.out.print("enter index: ");
                    GQ.dequeue(Integer.parseInt(s.next()));
                    System.out.println(GQ);
                    System.out.println();
                    s.nextLine();
                    break;
                case("s"):
                    System.out.println(GQ.size);
                    break;
                case("quit"):
                    System.exit(0);
                    break;
            }
            
        }


    }
}
