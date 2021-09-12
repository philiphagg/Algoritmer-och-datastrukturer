package Laboration1.Uppgift5;


import java.util.Scanner;

//TODO TESTER
public class GeneralQueue<T> {
    Node <T> last;
    int size;

    private class Node<T>{
        private Node<T> next;
        private T data;
    }

    public GeneralQueue() {
        Node<T> last = null;
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
        }else{
            Node<T> oldFirst = last;
            last = new Node<>();
            last.data = data;
            last.next = oldFirst;
        }
        size++;

    }
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

    public void printQueue(){
        if(isEmpty()) {
            System.out.println("[]");
        }
        else {
            Node current;
            for (current = last; current.next != null; current = current.next) {
                System.out.print('[');
                System.out.print(current.data);
                System.out.print("], ");
            }
            System.out.print("[" + current.data + "]");

        }


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
                    GQ.printQueue();
                    System.out.println();
                    s.nextLine();
                    break;
                case("d"):
                    System.out.print("enter index: ");
                    GQ.dequeue(Integer.parseInt(s.next()));
                    GQ.printQueue();
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
