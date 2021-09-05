package Laboration1.Uppgift3;


import java.util.NoSuchElementException;

//TODO iterable betyder det att den ska implementera interface iterable?
    //TODO Se till att den fungerar för crappy input
    //TODO Skapa tester
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
    //TODO: You should print the content of the list after each insertion/deletion of an element.
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
    //TODO: You should print the content of the list after each insertion/deletion of an element.
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
        StringBuilder sb = new StringBuilder();
        if(isEmpty()) {
            sb.append("[]");
        }else {
            Node current;

            for (current = first; current != last; current = current.next) {
                sb.append('[');
                sb.append(current.data);
                sb.append("], ");
            }
            sb.append("[" + current.data + "]");
        }
        return sb.toString();

    }

}

