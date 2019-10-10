package com.jueee.item13;

public class Item13Example04 {

    public static void main(String[] args) {}
}

class HashTable1 implements Cloneable {
    
    private Entry[] buckets = new Entry[] {};

    private static class Entry {
        final Object key;
        Object value;
        Entry next;

        Entry(Object key, Object value, Entry next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        try {
            HashTable1 result = (HashTable1)super.clone();
            result.buckets = buckets.clone();
            return result;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}