package Laboration1.Uppgift4;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;


/**
 * class represents a circular singly linked list.
 *
 * @param <T> for generic purposes
 */
public class CircularSinglyLinkedList<T> implements Iterable<T> {
    private Node<T> head;
    private int size;

    private class Node<T>{
        private Node<T> next;
        private T data;
    }

    /**
     * constructor for object creation.
     */
    public CircularSinglyLinkedList (){
        this.head = new Node<>();
        this.size = 0;
    }

    /**
     *
     * @return if the queue is empty
     */
    public boolean isEmpty() {
        return size == 0;
    }

    public void addfirst(T data){
        if(isEmpty()){
            head.next = new Node<T>();
            head.next.data = data;
            head.next.next = head;
        }else{
            Node<T> oldFirst = new Node<T>();
            oldFirst = head.next;
            head.next = new Node<T>();
            head.next.data = data;
            head.next.next = oldFirst;
        }
        size++;
    }

    /**
     * adds element to the end of the list
     *
     * @param data that should be added.
     */
    public void addLast(T data){
        CircularSinglyLinkedListIterator cli = new CircularSinglyLinkedListIterator();
        if(isEmpty()){
            head.next = new Node<T>();
            head.next.data = data;
            head.next.next = head;
        }else {
            int i = 0;
            while (++i < size) {
                cli.next();
            }
            Node oldLast = cli.current;
            Node<T> last = new Node<T>();
            last.data = data;
            oldLast.next = last;
            last.next = head;
        }
        size++;

    }

    /**
     * Removes the first element from the queue
     *
     * @return element that was removed
     */
    public T removeFirst(){
        T data = head.next.data;
        if(isEmpty())
            throw new NoSuchElementException("Cant remove element from empty queue");
        else if (size == 1){
            head.next = null;
            size--;
        }else{
            head.next = head.next.next;
            size--;
        }

        return data;
    }

    /**
     * removes the element from the back of the queue
     *
     * @return  element that was removed
     */
    public T removeLast(){
        T data;
        if(isEmpty())
            throw new NoSuchElementException("Cant remove element from empty queue");
        else if(size == 1){
            data = head.next.data;
            head.next = null;
            size--;
        }else{
            CircularSinglyLinkedListIterator cli = new CircularSinglyLinkedListIterator();
            int i = 1;
            while (++i < size) {
                cli.next();
            }
            data = cli.current.data;
            cli.current.next = null;
            size--;
        }

        return data;
    }

    /**
     * convers the list to a string representation
     *
     * @return the string representation
     */
    public String toString(){
        CircularSinglyLinkedListIterator cli = new CircularSinglyLinkedListIterator();
        StringBuilder sb = new StringBuilder();
        int i = 0;
        if(isEmpty())
            sb.append("[]");
        else{
            while(++i < size){
                sb.append("["+cli.current.data+"], ");
                cli.next();
            }
            sb.append("["+cli.current.data+"]");

        }
        return sb.toString();
    }

    /**
     * Iterator
     * @return custom made iterator
     */
    @Override
    public Iterator iterator() {
        return new CircularSinglyLinkedListIterator();
    }
    private class CircularSinglyLinkedListIterator implements Iterator<T>{
        private Node<T> current = head.next;


        @Override
        public boolean hasNext() {
            return current != head;
        }

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

    public static void main(String[] args) {
        CircularSinglyLinkedList cli = new CircularSinglyLinkedList();
        Scanner s = new Scanner(System.in);

        while(true){
            System.out.println("af: add first | al: add last | rf: remove first | rl: remove last | s: size | quit: quit");
            String input = s.nextLine();
            switch (input){
                case("af"):
                    System.out.print("enter a value: ");
                    cli.addfirst(s.next());
                    System.out.println(cli);
                    System.out.println();
                    s.nextLine();
                    break;
                case("rf"):
                    cli.removeFirst();
                    System.out.println(cli);
                    System.out.println();
                    break;
                case("al"):
                    cli.addLast(s.next());
                    System.out.println(cli);
                    System.out.println();
                    s.nextLine();
                    break;
                case("rl"):
                    cli.removeLast();
                    System.out.println(cli);
                    System.out.println();
                    s.nextLine();
                case("s"):
                    System.out.println(cli.size);
                    break;
                case("quit"):
                    System.exit(0);
                    break;
            }

        }

    }
}
