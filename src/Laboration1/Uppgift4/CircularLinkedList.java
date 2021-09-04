package Laboration1.Uppgift4;


import java.util.Iterator;
import java.util.NoSuchElementException;

//TODO 4. Implement a generic iterable circular linked list which allows the user to insert and remove elements to/from the front and back end of the queue. Be careful when designing the API. You should print the content of the list after each insertion/deletion of an element.
public class CircularLinkedList<T> implements Iterable<T>  {
    private Node<T> last;
    private Node<T> first;
    private int size;

    private class Node<T>{
        private Node<T> next;
        private T data;
    }

    public CircularLinkedList() {
        this.last = null;
        this.first = null;
        this.size = 0;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public Node<T> getLast() {
        return last;
    }

    public Node<T> getFirst() {
        return first;
    }
    public T getFirstData(){
        return first.data;
    }
    public T getLastData(){
        return last.data;
    }


    public int getSize() {
        return size;
    }


    public void addFirst(T data){
        if(isEmpty()){
            last = first = new Node<T>();
            first.data = data;
            first.next = last;
            last.next = first;
            size++;
        }else{
            Node<T> oldFirst = first;
            first = new Node<T>();
            first.data = data;
            first.next = oldFirst;
            last.next = first;
            size++;
        }
    }

    public void addLast(T data){
        if(isEmpty()){
            last = first = new Node<T>();
            last.data = data;
            last.next = first;
            first.next = last;
            size++;
        }else{
            Node oldLast = last;
            last = new Node<T>();
            last.data = data;
            last.next = first;
            oldLast.next = last;
            size++;
        }



    }
    //TODO when list is zero and when list only has one element
    public T removeFirst(){
        T data = first.data;
        first = first.next;
        last.next = first;

        size--;
        return data;
    }
    //TODO Method that removes item last
    public T removeLast(){
        T data = first.data;




        size--;
        return data;
    }

    public String printCircularLinkedList(){
        StringBuilder sb = new StringBuilder();
        CircularLinkedListIterator cli = new CircularLinkedListIterator();
        if(isEmpty())
            return "[]";
        else{
            while(cli.hasNext()){
                sb.append("["+cli.current.data+"], ");
                cli.next();
            }
            sb.append("["+cli.current.data+"]");
        }
        return sb.toString();
    }

    @Override
    public Iterator iterator() {
        return new CircularLinkedListIterator();
    }
    private class CircularLinkedListIterator implements Iterator<T>{
        private Node<T> current = first;

        //TODO hasNext()
        @Override
        public boolean hasNext() {
            return current.next != last.next;
        }
        //TODO Next()
        @Override
        public T next() {
            if(!hasNext())
            {
                throw new NoSuchElementException();
            }
            current = current.next;
            return current.data;
        }
    }
}
