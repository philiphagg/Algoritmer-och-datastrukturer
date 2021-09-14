package Laboration1.Uppgift2;

/**
 * Class representing a stack with basic functionality
 * the stack contains nodes, that holds chars.
 *
 */

public class Stack {
    public Node first;
    public int size;

    private class Node{
        private Node next;
        private char data;
    }

    /**
     * Constructor for object creation
     */
    public Stack() {
        this.first = null;
        this.size = 0;
    }

    /**
     * checking if the stack is empty
     *
     * @return boolean if stack is empty
     */
    public boolean isEmpty(){

        return first == null;
    }

    /**
     * returns the size of the stack ( amount of nodes in the stack )
     *
     * @return  amount of nodes in the stack
     */
    public int getSize(){

        return size;
    }

    /**
     * Addes element from the stack
     *
     * @param data data that should be added to the stack
     */
    public void push(char data){
        Node copy = first;
        first = new Node();
        first.data = data;
        first.next = copy;
        size++;
    }

    /**
     * removes element from stack. Last in first out.
     *
     * @return  element that was removed.
     */
    public char pop(){
        char data = first.data;
        first = first.next;
        size--;
        return data;
    }

}

