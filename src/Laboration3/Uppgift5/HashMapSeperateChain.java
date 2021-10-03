package Laboration3.Uppgift5;

public class HashMapSeperateChain<Key,Value> {
    private int N;
    private int M;
    private SeqST<Key,Value>[] st;
    private static final int INIT_CAPACITY = 4;


    public HashMapSeperateChain() {
        this(INIT_CAPACITY);
    }
    public HashMapSeperateChain(int M){
        this.M = M;
        st = (SeqST<Key,Value>[]) new SeqST[M];
        for(int i = 0; i < M; i++){
            st[i] = new SeqST<Key,Value>();
        }
    }
}

