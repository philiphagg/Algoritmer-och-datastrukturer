package Laboration3.Uppgift5;

public class SeqST<Key, Value> {
    int size;
    private Node first;

    private class Node {
        private Key key;
        private Value val;
        private Node next;

        public Node(Key key, Value val, Node next) {
            this.key = key;
            this.val = val;
            this.next = next;
        }
    }
    public int getSize(){
        return size;
    }
    private boolean isEmpty(){
        return size == 0;
    }
    public boolean contains (Key key){
        return get(key) != null;
    }

    private Value get(Key key) {
        for(Node current = first; current != null; current = current.next){
            if(key.equals(current.key))
                return current.val;
        }
        return null;
    }

    public void put(Key key,Value val){
        for(Node current = first; current != null; current = current.next){
            if(key.equals(current.key)) {
                current.val = val;
                return;
            }
        }
        first = new Node(key,val,first);
        size++;
    }
    public Iterable<Key> keys()
    {
        Queue<Key> queue = new Queue<>();
        for (Node x = first; x != null; x = x.next)
            queue.enqueue(x.key);
        return queue;
    }


}
