package com.jueee.item02;

import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

import lombok.Data;

public class Item02Example04 {

    public static void main(String[] args) {
        NyPizza pizza = new NyPizza.Builder(NyPizza.Size.SMALL).addTopping(NyPizza.Topping.SAUSAGE).addTopping(NyPizza.Topping.ONION).build();
        System.out.println(pizza.getSize());
        System.out.println(pizza.toppings);
        
        System.out.println();
        
        Calzone calzone = new Calzone.Builder().addTopping(Calzone.Topping.HAM).sauceInside().build();
        System.out.println(calzone.isSauceInside());
        System.out.println(calzone.toppings);
    }
}

// 各种比萨饼的根层次结构的抽象类
abstract class Pizza {

    public enum Topping {
        HAM, MUSHROOM, ONION, PEPPER, SAUSAGE
    }

    final Set<Topping> toppings;

    abstract static class Builder<T extends Builder<T>> {
        EnumSet<Topping> toppings = EnumSet.noneOf(Topping.class);

        public T addTopping(Topping topping) {
            toppings.add(Objects.requireNonNull(topping));
            return self();
        }

        abstract Pizza build();

        // 子类必选重写该方法并且返回 "this"
        protected abstract T self();
    }

    Pizza(Builder<?> builder) {
        toppings = builder.toppings.clone();
    }
}

// 代表标准的纽约风格的披萨：有一个所需的尺寸参数
@Data
class NyPizza extends Pizza {
    public enum Size {
        SMALL, MEDIUM, LARGE
    }

    private final Size size;

    public static class Builder extends Pizza.Builder<Builder> {
        private final Size size;

        public Builder(Size size) {
            this.size = Objects.requireNonNull(size);
        }

        @Override
        public NyPizza build() {
            return new NyPizza(this);
        }

        @Override
        protected Builder self() {
            return this;
        }
    }

    private NyPizza(Builder builder) {
        super(builder);
        size = builder.size;
    }
}

// 半圆形烤乳酪馅饼：允许指定酱汁是否应该在里面或在外面
@Data
class Calzone extends Pizza {
    private final boolean sauceInside;

    public static class Builder extends Pizza.Builder<Builder> {
        private boolean sauceInside = false; // Default

        public Builder sauceInside() {
            sauceInside = true;
            return this;
        }

        @Override
        public Calzone build() {
            return new Calzone(this);
        }

        @Override
        protected Builder self() {
            return this;
        }
    }

    private Calzone(Builder builder) {
        super(builder);
        sauceInside = builder.sauceInside;
    }
}