package com.jueee.item28;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Item28Example04 {

    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("a");
        list.add("b");
        list.add("c");
        Chooser3<String> chooser = new Chooser3<String>(list);
        System.out.println(chooser.choose());
    }
}

// Chooser3 - a class badly in need of generics!
class Chooser3<T> {
    
    private final List<T> choiceArray;

    public Chooser3(Collection<T> choices) {
        choiceArray = new ArrayList<>(choices);
    }

    // 返回随机选择的集合的一个元素。 
    public Object choose() {
        Random rnd = ThreadLocalRandom.current();
        return choiceArray.get(rnd.nextInt(choiceArray.size()));
    }
}
