package com.jueee.item01;

import java.util.Random;

/**
 * 假设我们需要写一个产生随即数的类RandomIntGenerator，该类有两个成员属性：最小值min和最大值max，
 * 
 * 假设我们的需求是需要创建三种类型的RandomIntGenerator对象，
 * 1、大于min，小于max；
 * 2、大于min 小于Integer.MAX_VALUE；
 * 3、大于Integer.MIN_VALUE 小于max
 * 
 * @author hzweiyongqiang
 */
public class Item01Example05 {

    public static void main(String[] args) {
        RandomIntGenerator1 generator11 = new RandomIntGenerator1(3);
        System.out.println(generator11.getRandom());
        RandomIntGenerator1 generator12 = new RandomIntGenerator1(3,10);
        System.out.println(generator12.getRandom());
        
        System.out.println();

        RandomIntGenerator2 generator21 = RandomIntGenerator2.between(3, 6);
        System.out.println(generator21.getRandom());
        RandomIntGenerator2 generator22 = RandomIntGenerator2.biggerThan(3);
        System.out.println(generator22.getRandom());
        RandomIntGenerator2 generator23 = RandomIntGenerator2.smallerThan(6);
        System.out.println(generator23.getRandom());
    }
}

class RandomIntGenerator1 {
    /**
     * 最小值
     */
    private int min = 0;
    /**
     * 最大值
     */
    private int max = Integer.MAX_VALUE;

    /**
     * 大于min 小于max
     * @param min
     * @param max
     */
    public RandomIntGenerator1(int min, int max) {
        this.min = min;
        this.max = max;
        if (this.min < 0) {
            this.min = 0;
        }
    }

    /**
     * 大于min 小于Integer.MAX_VALUE
     */
    public RandomIntGenerator1(int min) {
        this.min = min;
    }

    // 报错：Duplicate method RandomIntGenerator1(int) in type RandomIntGenerator1
    // /**
    // * 大于Integer.MIN_VALUE 小于max
    // */
    // public RandomIntGenerator1(int max)
    // {
    // this.max = max;
    // }
    
    public int getRandom() {
        Random r = new Random();
        int Result = r.nextInt(max-min) + min;
        return Result;
    }
}

class RandomIntGenerator2 {
    /**
     * 最小值
     */
    private int min = Integer.MIN_VALUE;
    /**
     * 最大值
     */
    private int max = Integer.MAX_VALUE;

    /**
     * 大于min 小于max
     * 
     * @param min
     * @param max
     */
    public RandomIntGenerator2(int min, int max) {
        this.min = min;
        this.max = max;
        if (this.min < 0) {
            this.min = 0;
        }
    }

    /**
     * 大于min 小于max
     * 
     * @param min
     * @param max
     */
    public static RandomIntGenerator2 between(int min, int max) {
        return new RandomIntGenerator2(min, max);
    }

    /**
     * 大于min 小于Integer.MAX_VALUE
     */
    public static RandomIntGenerator2 biggerThan(int min) {
        return new RandomIntGenerator2(min, Integer.MAX_VALUE);
    }

    /**
     * 大于Integer.MIN_VALUE 小于max
     */
    public static RandomIntGenerator2 smallerThan(int max) {
        return new RandomIntGenerator2(Integer.MIN_VALUE, max);
    }
    
    public int getRandom() {
        Random r = new Random();
        int Result = r.nextInt(max-min) + min;
        return Result;
    }
}