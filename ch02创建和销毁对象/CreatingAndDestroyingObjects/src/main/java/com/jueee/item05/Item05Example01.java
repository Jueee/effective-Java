package com.jueee.item05;

import java.util.List;
import java.util.Objects;

public class Item05Example01 {

}

class Lexicon{}

class SpellChecker01 {
    private final Lexicon dictionary = new Lexicon();
    
    private SpellChecker01() {} // 不可实例化的

    public static boolean isValid(String word) {
        return false;
    }

    public static List<String> suggestions(String typo) {
        return null;
    }
}

class SpellChecker02 {
    private final Lexicon dictionary = new Lexicon();
    
    private SpellChecker02() {}

    public static SpellChecker02 INSTANCE = new SpellChecker02();

    public boolean isValid(String word) {
        return false;
    }

    public List<String> suggestions(String typo) {
        return null;
    }
}

class SpellChecker03 {
    private final Lexicon dictionary;

    public SpellChecker03(Lexicon dictionary) {
        this.dictionary = Objects.requireNonNull(dictionary);
    }
    
    public boolean isValid(String word) {
        return false;
    }

    public List<String> suggestions(String typo) {
        return null;
    }
}