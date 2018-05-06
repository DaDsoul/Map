
package com.akezhanmussa.impl;

import com.akezhanmussa.adt.Stack;

/**
 * Created by talgat on 10.02.18.
 */
public class LinkedListStack<T> implements Stack<T>{

    private Node<T> top;
    private int size;

    public LinkedListStack(){
        top = null;
        size = 0;
    }

    @Override
    public T pop() throws Exception {
        if (size == 0){
            throw new Exception("The stack is empty");
        }

        T oldValue = top.getValue();
        Node<T> link = top.getLink();
        top = link;
        size --;

        return oldValue;
    }

    @Override
    public void push(T value) {
        if (size == 0){
            top = new Node(value);
            top.setLink(null);
        } else {
            Node<T> timeTop = top;
            top = new Node(value);
            top.setLink(timeTop);
        }

        size ++;
    }

    @Override
    public void clear() {
        top = null;
        size = 0;
    }

    @Override
    public int getSize() {

        return size;
    }

    public String toString(){
        Node<T> someNode = top;
        String result = "top[";
        boolean checker = false;

        if (someNode != null){
            checker = true;
        }

        if (checker){

            for(int i = 0; i<size; i++){
                result += " " + someNode.getValue();
                someNode = someNode.getLink();
            }

        }

        result += " ]back";

        return result;
    }


}
