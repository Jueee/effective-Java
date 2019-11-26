package com.jueee.item29;

import java.util.Arrays;
import java.util.EmptyStackException;

public class Item29Example01 {

    // Object-based collection - a prime candidate for generics
    public class Stack {
        private Object[] elements;
        private int size = 0;
        private static final int DEFAULT_INITIAL_CAPACITY = 16;

        public Stack() {
            elements = new Object[DEFAULT_INITIAL_CAPACITY];
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

        public boolean isEmpty() {
            return size == 0;
        }

        private void ensureCapacity() {
            if (elements.length == size)
                elements = Arrays.copyOf(elements, 2 * size + 1);
        }
    }

    public static void main(String[] args) {
        Item29Example01 test = new Item29Example01();
        Stack stack = test.new Stack();
        String[] strings = new String[] {"a", "b", "c"};
        for (String arg : strings)
            stack.push(arg);
        while (!stack.isEmpty())
            System.out.println(stack.pop().toString().toUpperCase());
    }

}
