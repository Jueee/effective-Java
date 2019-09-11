package com.jueee.item02;

import lombok.Data;

// Builder 模式：客户端不直接调用所需的对象，而是调用构造方法(或静态工厂)，并使用所有必需的参数，并获得一个builder对象。
public class Item02Example03 {

    public static void main(String[] args) {
        NutritionFacts3 cocaCola = new NutritionFacts3.Builder(240, 8)
            .calories(100).sodium(35).carbohydrate(27).build();
        System.out.println(cocaCola.getServings());
    }

}

@Data
class NutritionFacts3 {
    private final int servingSize;
    private final int servings;
    private final int calories;
    private final int fat;
    private final int sodium;
    private final int carbohydrate;

    public static class Builder {
        // 必选参数
        private final int servingSize;
        private final int servings;

        // 可选参数 - 设置默认值
        private int calories      = 0;
        private int fat           = 0;
        private int sodium        = 0;
        private int carbohydrate  = 0;

        public Builder(int servingSize, int servings) {
            this.servingSize = servingSize;
            this.servings    = servings;
        }

        public Builder calories(int val) { 
            calories = val;      
            return this;
        }

        public Builder fat(int val) { 
           fat = val;           
           return this;
        }

        public Builder sodium(int val) { 
           sodium = val;        
           return this; 
        }

        public Builder carbohydrate(int val) { 
           carbohydrate = val;  
           return this; 
        }

        public NutritionFacts3 build() {
            return new NutritionFacts3(this);
        }
    }

    private NutritionFacts3(Builder builder) {
        servingSize  = builder.servingSize;
        servings     = builder.servings;
        calories     = builder.calories;
        fat          = builder.fat;
        sodium       = builder.sodium;
        carbohydrate = builder.carbohydrate;
    }
}