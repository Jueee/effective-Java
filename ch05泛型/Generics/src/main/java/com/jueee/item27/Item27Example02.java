package com.jueee.item27;

import java.util.AbstractList;
import java.util.Arrays;

public class Item27Example02<T> extends AbstractList<T> {

    transient Object[] elements;
    
    private int size;
    
    // 把注释放在整个方法上
    @SuppressWarnings({"unchecked", "hiding"})
    public <T> T[] toArray(T[] a) {
        if (a.length < size)
           return (T[]) Arrays.copyOf(elements, size, a.getClass());
        System.arraycopy(elements, 0, a, 0, size);
        if (a.length > size)
           a[size] = null;
        return a;
    }
    
    // 声明一个局部变量来保存返回值并标注它的声明
    public <T> T[] toArray2(T[] a) {
        if (a.length < size) {
            @SuppressWarnings("unchecked")
            T[] result = (T[]) Arrays.copyOf(elements, size, a.getClass());
            return result;
        }
        System.arraycopy(elements, 0, a, 0, size);
        if (a.length > size)
           a[size] = null;
        return a;
    }

    @Override
    public T get(int index) {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }
    
    public static void main(String[] args) {
        
    }
}
