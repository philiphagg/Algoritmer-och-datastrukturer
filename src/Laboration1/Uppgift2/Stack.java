package Laboration1.Uppgift2;

public class Stack {
    public Node first;
    public int size;

    //TODO: se till att stack fungerar med crappy inputs
    // TODO: skapa tester
    private class Node{
        private Node next;
        private char data;
    }

    public Stack() {
        this.first = null;
        this.size = 0;
    }
    public boolean isEmpty(){

        return first == null;
    }
    public int getSize(){

        return size;
    }

    public void push(char data){
        Node copy = first;
        first = new Node();
        first.data = data;
        first.next = copy;
        size++;
    }
    public char pop(){
        char data = first.data;
        first = first.next;
        size--;
        return data;
    }

}

