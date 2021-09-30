package Laboration3.Uppgift2;

import edu.princeton.cs.algs4.Queue;

import java.util.NoSuchElementException;

public class BinarySearchST <Key extends Comparable<Key>, Value> {
    private Key[] keys;
    private Value[] vals;
    private int size;


    public BinarySearchST(int capacity){
        keys = (Key[]) new Comparable[capacity];
        vals = (Value[]) new Object[capacity];
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int getSize(){
        return size;
    }
    public int rank(Key key){
        int lo = 0;
        int hi = size - 1;
        while(lo <= hi){
            int mid = lo +(hi-lo)/2;
            int cmp = key.compareTo(keys[mid]);
            if(cmp < 0)
                hi = mid - 1;
            else if(cmp > 0)
                lo = mid + 1;
            else
                return mid;
        }
        return lo;

    }
    public void put(Key key, Value val)  {

        int i = rank(key);

        // key is already in table
        if (i < size && keys[i].compareTo(key) == 0) {
            vals[i] = val;
            return;
        }

        // insert new key-value pair
        if (size == keys.length) resize(2*keys.length);

        for (int j = size; j > i; j--)  {
            keys[j] = keys[j-1];
            vals[j] = vals[j-1];
        }
        keys[i] = key;
        vals[i] = val;
        size++;

    }
    private void resize(int capacity) {
        assert capacity >= size;
        Key[]   tempk = (Key[])   new Comparable[capacity];
        Value[] tempv = (Value[]) new Object[capacity];
        for (int i = 0; i < size; i++) {
            tempk[i] = keys[i];
            tempv[i] = vals[i];
        }
        vals = tempv;
        keys = tempk;
    }

    public Value get(Key key){
        if(isEmpty()) return null;
        int i = rank(key);
        if(i < size && keys[i].compareTo(key) == 0) return vals[i];
        else
            return null;
    }
    public boolean contains(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to contains() is null");
        return get(key) != null;
    }

    public Key min() {
        if (isEmpty()) throw new NoSuchElementException("called min() with empty symbol table");
        return keys[0];
    }


    public Key max() {
        if (isEmpty()) throw new NoSuchElementException("called max() with empty symbol table");
        return keys[size-1];
    }

    public Iterable<Key> keys() {
        return keys(min(), max());
    }


    public Iterable<Key> keys(Key lo, Key hi) {
        if (lo == null) throw new IllegalArgumentException("first argument to keys() is null");
        if (hi == null) throw new IllegalArgumentException("second argument to keys() is null");

        Queue<Key> queue = new Queue<Key>();
        if (lo.compareTo(hi) > 0) return queue;
        for (int i = rank(lo); i < rank(hi); i++)
            queue.enqueue(keys[i]);
        if (contains(hi)) queue.enqueue(keys[rank(hi)]);
        return queue;
    }



}
