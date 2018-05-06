package com.akezhanmussa.impl;

import com.akezhanmussa.adt.Map;

public class LLStackMap<K,V> implements Map<K,V>{

    LinkedListStack<KeyValuePair<K,V>> pairs;
    int size;

    public LLStackMap(){
        pairs = new LinkedListStack();
        size = 0;
    }

    @Override
    public void define(K key, V value) {

        KeyValuePair<K,V> pair = new KeyValuePair(key,value);
        boolean checker = false;
        LinkedListStack<KeyValuePair<K,V>> dublicates = new LinkedListStack();

        if (size == 0){
            pairs.push(pair);
            size++;
        }else{
            try{
                int currentSize = size;
                for(int i = 0; i<currentSize; i++){
                    KeyValuePair<K,V> compareValue = pairs.pop();

                    if (compareValue.equals(pair)){
                        checker = false;
                        dublicates.push(compareValue);
                        break;
                    } else if (compareValue.getKey().equals(pair.getKey())){
                        pairs.push(pair);
                        checker = false;
                        break;
                    }else {
                        checker = true;
                        dublicates.push(compareValue);
                    }
                }

                int dublicateSize = dublicates.getSize();

                for(int i = 0; i<dublicateSize; i++){
                    pairs.push(dublicates.pop());
                }

                if (checker){
                    pairs.push(pair);
                    size += 1;
                }

            } catch(Exception ex){
                System.out.println(ex.getMessage());
            }
        }
    }

    @Override
    public V getValue(K key) {

        LinkedListStack<KeyValuePair<K,V>> dublicates = new LinkedListStack();
        int currentSize = size;
        V value = null;

        for(int i = 0; i<currentSize; i++){
            try{
                KeyValuePair<K,V> compareValue = pairs.pop();
                dublicates.push(compareValue);

                if (compareValue.getKey().equals(key)){
                    value = compareValue.getValue();
                    break;
                }

            }catch(Exception ex){
                System.out.println(ex.getMessage());
            }
        }

        int anotherSize = dublicates.getSize();
        for(int i = 0; i<anotherSize; i++) {
            try {
                pairs.push(dublicates.pop());
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }

        }

        return value;
    }

    @Override
    public V remove(K key) {

        LinkedListStack<KeyValuePair<K,V>> dublicates = new LinkedListStack();
        int currentSize = size;
        V value = null;

        for(int i = 0; i<currentSize; i++){
            try{
                KeyValuePair<K,V> compareValue = pairs.pop();

                if (compareValue.getKey().equals(key)){
                    size--;
                    value = compareValue.getValue();
                    break;
                }

                dublicates.push(compareValue);
            }catch(Exception ex){
                System.out.println(ex.getMessage());
            }
        }

        int anotherSize = dublicates.getSize();

        for(int i = 0; i<anotherSize; i++) {
            try {
                pairs.push(dublicates.pop());
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }

        }

        return value;
    }

    @Override
    public KeyValuePair<K, V> removeAny() throws Exception {
        KeyValuePair<K,V> element = null;
        if (size == 0){
            throw new Exception("the stack is empty!");
        }

        try{
            element = pairs.pop();
            this.size --;
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }

        return element;
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public void clear() {
        pairs = new LinkedListStack();
        size = 0;
    }

    @Override
    public String toString() {
        int currentSize = this.size;
        LinkedListStack<KeyValuePair<K,V>> dublicates = new LinkedListStack();
        String result = "[-- ";

        try{
            for(int i = 0; i<currentSize; i++){
                KeyValuePair<K,V> element = pairs.pop();
                dublicates.push(element);
                result += element + " --";
            }

            int dublicateSize = dublicates.getSize();

            for(int i = 0; i<dublicateSize; i++){
                pairs.push(dublicates.pop());
            }

            result += "]";


        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }

        return result;
    }
}
