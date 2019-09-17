package com.jueee.item06;

public class Item06Example02 {
    // 非常慢！ 你能发现对象的创建吗？
    private static long sumBad() {
        Long sum = 0L;
        for (long i = 0; i <= Integer.MAX_VALUE; i++)
            sum += i;
        return sum;
    }
    
    
    private static long sumGood() {
        long sum = 0L;
        for (long i = 0; i <= Integer.MAX_VALUE; i++)
            sum += i;
        return sum;
    }
    
    public static void main(String[] args) {
        long start1 = System.currentTimeMillis();
        System.out.println(sumBad());
        System.out.println("UseTime1:" + (System.currentTimeMillis() - start1));

        long start2 = System.currentTimeMillis();
        System.out.println(sumGood());
        System.out.println("UseTime2:" + (System.currentTimeMillis() - start2));
    }
}
