package com.jueee.item08;

import java.lang.ref.Cleaner;

public class Item08Example01 {
    
    // Cleaner机制将调用State的run方法。
    public static void Adult() {
        try (Room myRoom = new Room(7)) {
            System.out.println("Goodbye");
        }
    }
    
    public static void Teenager() {
        new Room(99);
        System.out.println("Peace out");
    }
    
    public static void NoClean() {
        Room myRoom = new Room(99);
        System.out.println("Peace out");
    }
    // 通过调用Room的close方法内调用Cleanable的clean方法来触发State类的run()方法
    public static void Clean() {
        Room myRoom = new Room(99);
        myRoom.close();
        System.out.println("Peace out");
    }
    
    public static void main(String[] args) {
        System.out.println("Adult:");
        Adult();
        
        System.out.println("-----");
        
        System.out.println("Teenager:");
        Teenager();
        
        System.out.println("-----");
        
        System.out.println("NoClean:");
        NoClean();
        
        System.out.println("-----");
        
        System.out.println("Clean:");
        Clean();
    }
}

// 使用 Cleaner 作为安全网的自动关闭类
class Room implements AutoCloseable {

    // Cleaner 类位于 JDK 9，java.lang.ref.Cleaner
    private static final Cleaner cleaner = Cleaner.create();

    // 静态内部State类拥有Cleaner机制清理房间所需的资源。
    // State类实现了Runnable接口，其run方法最多只能调用一次，只能被我们在Room构造方法中用Cleaner机制注册State实例时得到的Cleanable调用。
    private static class State implements Runnable {
        int numJunkPiles; // 代表混乱房间的数量

        State(int numJunkPiles) {
            this.numJunkPiles = numJunkPiles;
        }

        // Invoked by close method or cleaner
        @Override
        public void run() {
            System.out.println("Cleaning room");
            numJunkPiles = 0;
        }
    }

    // The state of this room, shared with our cleanable
    private final State state;

    // Our cleanable. Cleans the room when it’s eligible for gc
    private final Cleaner.Cleanable cleanable;

    public Room(int numJunkPiles) {
        state = new State(numJunkPiles);
        cleanable = cleaner.register(this, state);
    }

    @Override
    public void close() {
        cleanable.clean();
    }
}