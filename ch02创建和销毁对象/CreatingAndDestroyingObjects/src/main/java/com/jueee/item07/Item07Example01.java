package com.jueee.item07;

import java.util.Arrays;
import java.util.EmptyStackException;

public class Item07Example01 {

    public static void main(String[] args) {
        StackBad stack = new StackBad();
        stack.push("a");
        stack.push("b");
        stack.push("c");
        
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        
        StackGood stack2 = new StackGood();
        stack2.push("a");
        stack2.push("b");
        stack2.push("c");
        
        System.out.println(stack2.pop());
        System.out.println(stack2.pop());
    }
}

// 堆栈实现
class StackBad {
    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    public StackBad() {
        elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(Object e) {
        ensureCapacity();
        elements[size++] = e;
    }

    public Object pop() {
        if (size == 0)
            throw new EmptyStackException();
        return elements[--size];
    }

    /**
     * 确保至少有一个元素的空间，每次阵列需要增长时，容量大致加倍。
     */
    private void ensureCapacity() {
        if (elements.length == size)
            elements = Arrays.copyOf(elements, 2 * size + 1);
    }
}

//堆栈实现
class StackGood {
 private Object[] elements;
 private int size = 0;
 private static final int DEFAULT_INITIAL_CAPACITY = 16;

 public StackGood() {
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
     elements[size] = null; // 设置元素过期！
     return result;
 }

 /**
  * 确保至少有一个元素的空间，每次阵列需要增长时，容量大致加倍。
  */
 private void ensureCapacity() {
     if (elements.length == size)
         elements = Arrays.copyOf(elements, 2 * size + 1);
 }
}