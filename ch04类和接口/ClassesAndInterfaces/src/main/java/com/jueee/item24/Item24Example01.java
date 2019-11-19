package com.jueee.item24;

import java.util.AbstractSet;
import java.util.Iterator;

public class Item24Example01<E> extends AbstractSet<E> {
    
    @Override
    public Iterator<E> iterator() {
        return new MyIterator();
    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        return 0;
    }

    private class MyIterator implements Iterator<E> {

        @Override
        public boolean hasNext() {
            // TODO Auto-generated method stub
            return false;
        }

        @Override
        public E next() {
            // TODO Auto-generated method stub
            return null;
        }
    }
}
