package com.jueee.item31;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.EmptyStackException;
import java.util.List;

public class Item31Example01 {

    // Initial attempt to generify Stack - won't compile!
    public class Stack<E> {
        private E[] elements;
        private int size = 0;
        private static final int DEFAULT_INITIAL_CAPACITY = 16;

        @SuppressWarnings("unchecked")
        public Stack() {
            elements = (E[])new Object[DEFAULT_INITIAL_CAPACITY];
        }

        public void push(E e) {
            ensureCapacity();
            elements[size++] = e;
        }

        public E pop() {
            if (size == 0)
                throw new EmptyStackException();
            E result = elements[--size];
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
        
        // Wildcard type for a parameter that serves as an E producer
        public void pushAll(Iterable<? extends E> src) {
            for (E e : src)
                push(e);
        }
        
        // Wildcard type for parameter that serves as an E consumer
        public void popAll(Collection<? super E> dst) {
            while (!isEmpty())
                dst.add(pop());
        }

    }

    public static void main(String[] args) {
        Item31Example01 test = new Item31Example01();
        Stack<Number> numberStack = test.new Stack<>();
        Iterable<Integer> integers = Arrays.asList(1,2,3) ;
        numberStack.pushAll(integers);
        System.out.println(numberStack.pop());
        
        List<Number> result = new ArrayList<>();
        numberStack.popAll(result);
        System.out.println(result);
    }
}
