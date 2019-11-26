package com.jueee.item28;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Item28Example03 {

    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("a");
        list.add("b");
        list.add("c");
        Chooser2<String> chooser = new Chooser2<String>(list);
        System.out.println(chooser.choose());
    }
}

// Chooser2 - a class badly in need of generics!
class Chooser2<T> {
    
    private final T[] choiceArray;

    public Chooser2(Collection<T> choices) {
        choiceArray = (T[])choices.toArray();
    }

    // 返回随机选择的集合的一个元素。 
    public Object choose() {
        Random rnd = ThreadLocalRandom.current();
        return choiceArray[rnd.nextInt(choiceArray.length)];
    }
}
