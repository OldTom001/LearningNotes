package MyHashMap;

import java.util.Iterator;
import java.util.LinkedList;

public class MyHashMap {
    private class Pair {
        private int key;
        private int value;
        public Pair(){

        }
        public Pair(int key, int value) {
            this.key = key;
            this.value = value;
        }
        public int getKey() {
            return key;
        }
        public int getValue(){
            return value;
        }

        public void setKey(int key) {
            this.key = key;
        }
        public void setValue(int value) {
            this.value = value;
        }
    }

    private static final int BASE = 769;
    private LinkedList[] data = new LinkedList[BASE];

    public MyHashMap() {
        for(int i = 0; i < BASE; i++) {
            data[i] = new LinkedList<Pair>();
        }
    }

    public void put(int key, int value) {
        int h = hash(key);
        Iterator<Pair>  it = data[h].iterator();
        while (it.hasNext()) {
            Pair pair = it.next();
            if(key == pair.getKey()) {
                pair.setValue(value);
                return;
            }
        }
        data[h].offerLast(new Pair(key, value));
    }
    public int get(int key) {
        int h = hash(key);
        Iterator<Pair> it = data[h].iterator();
        while (it.hasNext()) {
            Pair pair = it.next();
            if(key == pair.getKey()) {
                return pair.getValue();
            }
        }

        for(int i = 0; i<data[h].size(); i++) {
            Pair pair = (Pair)(data[h].get(i));
            if(key == pair.getKey()) {
                return pair.getValue();
            }
        }
        return -1;
    }

    public void remove(int key) {
        int h = hash(key);
        Iterator<Pair> it = data[h].iterator();
        while (it.hasNext()) {
            Pair pair = it.next();
            if(key == pair.getKey()) {
                data[h].remove(pair);
                return;
            }
        }
    }

    public int hash(int key) {
        return key % BASE;
    }
}
