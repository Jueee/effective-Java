package com.jueee.item13;

public class Item13Example05 {

    public static void main(String[] args) {}
}

class HashTable2 implements Cloneable {

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

        Entry deepCopy() {
            return new Entry(key, value, next == null ? null : next.deepCopy());
        }
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        try {
            HashTable2 result = (HashTable2)super.clone();
            result.buckets = new Entry[buckets.length];
            for (int i = 0; i < buckets.length; i++) {
                if (buckets[i] != null) {
                    result.buckets[i] = buckets[i].deepCopy();
                }
            }
            return result;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}