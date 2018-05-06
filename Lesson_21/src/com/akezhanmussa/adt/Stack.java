package com.akezhanmussa.adt;

/**
 * Created by talgat on 25.01.18.
 */
public interface Stack<T> {
    /**
     * Puts the given number on the top of the stack
     *
     * @param value element to be added on the top of the stack
     */

    public void push(T value);

    /**
     * Removes and returns the top most element of the stack.
     * Throwing the exception in case of the empty stack
     *
     *
     *
     * @return the last element of the stack
     * @throws Exception in case when the stack is empy
     */

    public T pop() throws Exception;

    /**
     *Getting the size of the stack
     *
     *
     * @return the size of the stack
     */

    public int getSize();


    /**
     * Remove the elements from the stack
     */

    public void clear();

    /**
     *Returning the String representation of the
     * specific object
     *
     *
     *
     * @return a String representation of the stack
     */

    @Override
    public String toString();

}
