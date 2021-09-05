package Laboration1.Uppgift5;

//TODO 5. Implement a generalized queue which allows the user to remove the kth element from the queue. Assume the most recently added element has index 1. You should print the content of the list after each insertion/deletion of an element.
//TODO TESTER
public class GeneralQueue<T> {
    Node <T> last;
    int size;

    private class Node<T>{
        private Node<T> next;
        private T data;
    }

    public GeneralQueue() {
        Node<T> first = null;
        int size = 0;
    }

    public Node<T> getLast() {
        return last;
    }

    public int getSize() {
        return size;
    }
    public boolean isEmpty(){
        return size == 0;
    }

    public void enqueue(T data){
        if(isEmpty()){
            last = new Node<>();
            last.data = data;
            size++;
        }else{
            Node<T> oldFirst = last;
            last = new Node<>();
            last.data = data;
            last.next = oldFirst;
            size++;
        }
    }
    //TODO
    public T dequeue(int k){
        if(k < 0 || k >= size) throw new IllegalArgumentException();
        int i;
        Node indexNode;

            for(i = 0, indexNode = last; i != k; i++){

            }



        return ;
    }

    public String printQueue(){
        StringBuilder sb = new StringBuilder();
        if(isEmpty()) {
            sb.append("[]");
        }else {
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
}
