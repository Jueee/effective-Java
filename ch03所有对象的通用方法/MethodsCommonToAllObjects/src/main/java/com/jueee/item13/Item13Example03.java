package com.jueee.item13;

import java.util.Arrays;
import java.util.EmptyStackException;

public class Item13Example03 {

    public static void main(String[] args) {
        Stack2 stack1 = new Stack2();
        stack1.push(1);
        stack1.push(2);
        stack1.push(3);
        System.out.println(stack1.pop());    // 3
        
        Stack2 stack2 = null;
        try {
            stack2 = (Stack2)stack1.clone();  
            System.out.println(stack2.pop());    // 2
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        
        System.out.println(stack1.pop());   // 2
        System.out.println(stack2.pop());   // 1
    }
}

class Stack2 implements Cloneable{

    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    public Stack2() {
        this.elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(Object e) {
        ensureCapacity();
        elements[size++] = e;
    }

    public Object pop() {
        if (size == 0)
            throw new EmptyStackException();
        Object result = elements[--size];

        elements[size] = null; // Eliminate obsolete reference
        return result;
    }
    
    public int size() {
        return elements.length;
    }

    // Ensure space for at least one more element.
    private void ensureCapacity() {
        if (elements.length == size)
            elements = Arrays.copyOf(elements, 2 * size + 1);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        try {
            Stack2 result = (Stack2) super.clone();
            result.elements = elements.clone();
            return result;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();  // Can't happen
        }
    }
}