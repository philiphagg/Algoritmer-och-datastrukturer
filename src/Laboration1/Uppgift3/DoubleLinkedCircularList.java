package Laboration1.Uppgift3;


/**
 * TO DO
 * En generisk kö, innebär det att man ska använda sig av items istället för int under data?
 * implementera: You should print the content of the list after each insertion/deletion of an element.
 *
 */
public class DoubleLinkedCircularList {
    Node last;
    int size;
    Node first;

    public class Node{
        private Node prev;
        private int data;
        private Node next;

        public Node(){
            data = 0;
            prev = null;
            next = null;
        }

        public Node(Node prev, int data, Node next) {
            this.prev = prev;
            this.data = data;
            this.next = next;
        }

        public Node(int data) {
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
    public void enqueue(int data){
        if(isEmpty()){
            first = last = new Node(first, data, last);
        }else{
            first.prev = new Node(first.prev, data, first);
            first = first.prev;
            first.prev = last;
            last.next = first;

        }
        size++;
    }

    public String printQueue(){
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

