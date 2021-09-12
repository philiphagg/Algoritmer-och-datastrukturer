package Laboration1.Uppgift3;


import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Den här uppgiften blev inte rätt implementerad. Det finns en ny fil som är korrekt
 */

/**
 * A linked list with reference on first element in list and last
 * element in list.
 *
 *
 * @param <T>   Generic parameters
 */
public class DoubleLinkedCircularList<T> implements Iterable<T> {
    Node<T> last;
    int size;
    Node<T> first;

    @Override
    public Iterator<T> iterator() {

        return new dlcIterator();
    }
    private class dlcIterator implements Iterator<T> {
        private Node<T> current = first;

        @Override
        public boolean hasNext() {
            return current != first.prev;
        }

        @Override
        public T next() {
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

    public DoubleLinkedCircularList() {
        this.last = null;
        this.size = 0;
        this.first = null;
    }
    public boolean isEmpty(){
        return first == null;
    }
    public Node getFirstInQueue(){
        return last;
    }
    public Node getLastInQueue(){
        return first;
    }
    public int getSize(){
        return size;
    }

    /**
     * Adds a member to the queue
     *
     * @param data  Data for the new member to hold
     */

    public void enqueue(T data){
        if(isEmpty()){
            first = last = new Node<T>(first, data, last);
        }else{
            first.prev = new Node<T>(first.prev, data, first);
            first = first.prev;
            first.prev = last;
            last.next = first;
        }
        printQueue();
        size++;
    }

    public T dequeue(){
        T data = last.data;
        if(size == 1){
            first = last = null;
        }else {
            last = last.prev;
            first.prev = last;
            last.next = first;
        }
        size--;
        printQueue();
        return data;
    }


    public void printQueue() {
        if (isEmpty()) {
            System.out.print("[]");
        } else {
            Node current;
            for (current = first; current != last; current = current.next) {
                System.out.print('[');
                System.out.print(current.data);
                System.out.print("], ");

            }
            System.out.print("[" + current.data + "]");
            System.out.println();
        }
    }

}

