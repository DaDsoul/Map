package com.akezhanmussa.impl;

import com.akezhanmussa.adt.Map;

public class LLQueueMap<K, V> implements Map<K,V>{

    private LinkedListQueue<KeyValuePair<K,V>> pairs;
    private int size;

    public LLQueueMap(){
        pairs = new LinkedListQueue();
        size = 0;
    }


    @Override
    public void define(K key, V value) {

        KeyValuePair<K, V> pair = new KeyValuePair(key,value);
        boolean checker = false;

        if (size == 0){
            pairs.enqueue(pair);
            size ++;
        } else {
            int currentSize = size;
            for(int i = 0; i<currentSize; i++){
                try{
                    KeyValuePair<K,V> compareValue = pairs.dequeue();

                    if (compareValue.equals(pair)){
                        checker = false;
                        pairs.enqueue(compareValue);
                        break;
                    } else if (compareValue.getKey().equals(pair.getKey())){
                        pairs.enqueue(pair);
                        checker = false;
                        break;
                    }else {
                        checker = true;
                        pairs.enqueue(compareValue);
                    }

                }catch(Exception ex){
                    System.out.println(ex.getMessage());
                }
            }

            if (checker){
                pairs.enqueue(pair);
                size ++;
            }
        }
    }

    

    @Override
    public V getValue(K key) {
        int currentSize = size;

        for(int i = 0; i<currentSize; i++){
            try{
                KeyValuePair<K,V> compareValue = pairs.dequeue();
                pairs.enqueue(compareValue);

                if (compareValue.getKey().equals(key)){
                    return compareValue.getValue();
                }
            }catch(Exception ex){
                System.out.println(ex.getMessage());
            }
        }

        return null;
    }

    @Override
    public V remove(K key) {
        int currentSize = size;

        for(int i = 0; i<currentSize; i++){
            try{
                KeyValuePair<K,V> compareValue = pairs.dequeue();

                if (compareValue.getKey().equals(key)){
                    size --;
                    return compareValue.getValue();
                } else {
                    pairs.enqueue(compareValue);
                }
            }catch(Exception ex){
                System.out.println(ex.getMessage());
            }
        }

        return null;
    }

    @Override
    public KeyValuePair<K, V> removeAny() throws Exception {
        if (size == 0){
            throw new Exception("The map is empty!!!");
        }

        KeyValuePair<K,V> removalElement = pairs.dequeue();
        size--;
        return removalElement;
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public void clear() {
        pairs = new LinkedListQueue<>();
        size = 0;
    }

    @Override
    public String toString() {
        String result = "[ -- ";
        int currentSize = size;

        for(int i = 0; i<currentSize; i++){
            try{
                KeyValuePair<K,V> somePair = pairs.dequeue();
                pairs.enqueue(somePair);
                result += somePair.toString() + " -- ";
            }catch(Exception ex){
                System.out.println(ex.getMessage());
            }
        }

        result += "]";

        return result;
    }
}
