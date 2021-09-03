package Laboration1.Uppgift3;


import java.util.NoSuchElementException;

/**
 * TO DO
 *
 * implementera: You should print the content of the list after each insertion/deletion of an element.
 * Se till att den fungerar för crappy input
 * skapa test
 *
 */
public class DoubleLinkedCircularList<T> {
    Node<T> last;
    int size;
    Node<T> first;

    public class Node<T>{
        private Node<T> prev, next;
        private T data;

        public Node(){
            data = null;
            prev = null;
            next = null;
        }

        public Node(Node<T> prev, T data, Node<T> next) {
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
    public Node getFirst(){
        return first;
    }
    public Node getLast(){
        return last;
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
        return data;
    }

    public String printQueue(){
        if(isEmpty()) throw new NoSuchElementException("Queue is empty");
        Node cnt;
        StringBuilder sb = new StringBuilder();
        for(cnt = first; cnt != last; cnt = cnt.next) {
            sb.append('[');
            sb.append(cnt.data);
            sb.append("], ");
        }
        sb.append("["+cnt.data+"]");

        return sb.toString();

    }

}

