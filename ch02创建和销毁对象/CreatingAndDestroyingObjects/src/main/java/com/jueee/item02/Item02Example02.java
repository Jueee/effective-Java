package com.jueee.item02;

import lombok.Data;

// JavaBeans 模式：调用一个无参数的构造函数来创建对象，然后调用setter方法来设置每个必需的参数和可选参数
public class Item02Example02 {

    public static void main(String[] args) {
        NutritionFacts2 cocaCola = new NutritionFacts2();
        cocaCola.setServingSize(240);
        cocaCola.setServings(8);
        cocaCola.setCalories(100);
        cocaCola.setSodium(35);
        cocaCola.setCarbohydrate(27);
        System.out.println(cocaCola.getServings());
    }

}

@Data
class NutritionFacts2 {
    private int servingSize; // (mL) required
    private int servings; // (per container) required
    private int calories; // (per serving) optional
    private int fat; // (g/serving) optional
    private int sodium; // (mg/serving) optional
    private int carbohydrate; // (g/serving) optional

    public NutritionFacts2() {}
}