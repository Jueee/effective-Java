package com.jueee.item26;

import java.util.Set;

public class Item26Example04 {
    
    public static void main(String[] args) {
        
    }

    // 需要两个集合并返回它们共同拥有的元素的数量
    // Use of raw type for unknown element type - don't do this!
    private static int numElementsInCommon(Set s1, Set s2) {
        int result = 0;
        for (Object o1 : s1)
            if (s2.contains(o1))
                result++;
        return result;
    }

}
