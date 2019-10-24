package com.jueee.item18;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

public class Item18Example01 {

    public static void main(String[] args) {
        InstrumentedHashSet<String> set1 = new InstrumentedHashSet<String>();
        set1.add("a");
        set1.add("b");
        set1.add("a");
        System.out.println(set1.getAddCount()); // 3  满足预期
        
        InstrumentedHashSet<String> set2 = new InstrumentedHashSet<>();
        set2.addAll(Arrays.asList("Snap", "Crackle", "Pop"));
        System.out.println(set2.getAddCount()); // 6  不满足预期
    }
}

// 查询 HashSet ，从创建它之后已经添加了多少个元素。
class InstrumentedHashSet<E> extends HashSet<E> {
    // The number of attempted element insertions
    private int addCount = 0;

    public InstrumentedHashSet() {}

    public InstrumentedHashSet(int initCap, float loadFactor) {
        super(initCap, loadFactor);
    }

    @Override
    public boolean add(E e) {
        addCount++;
        return super.add(e);
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        addCount += c.size();
        return super.addAll(c);
    }

    public int getAddCount() {
        return addCount;
    }
}
