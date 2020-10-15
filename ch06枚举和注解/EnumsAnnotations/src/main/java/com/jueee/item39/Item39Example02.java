package com.jueee.item39;

public class Item39Example02 {

    @Item39Example01 
    public static void m1() { }  // Item39Example01 should pass

    public static void m2() { }

    @Item39Example01 
    public static void m3() {     // Item39Example01 should fail
        throw new RuntimeException("Boom");
    }

    public static void m4() { }

    @Item39Example01 
    public void m5() { } // INVALID USE: nonstatic method

    public static void m6() { }

    @Item39Example01 
    public static void m7() {    // Item39Example01 should fail
        throw new RuntimeException("Crash");
    }

    public static void m8() { }
}
