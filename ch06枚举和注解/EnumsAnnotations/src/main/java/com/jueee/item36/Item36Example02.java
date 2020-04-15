package com.jueee.item36;

import java.util.EnumSet;
import java.util.Set;

/**
 * 
 * @author hzweiyongqiang
 */
public class Item36Example02 {
	
    public enum Style { 
    	BOLD, ITALIC, UNDERLINE, STRIKETHROUGH 
    }

	// EnumSet - a modern replacement for bit fields
	public class Text {
	    // Any Set could be passed in, but EnumSet is clearly best
	    public void applyStyles(Set<Style> styles) {
	    	System.out.println(styles);
	    }
	}

	
	public static void main(String[] args) {
		Item36Example02 example = new Item36Example02();
		Text text = example.new Text();
		
		// EnumSet 类提供了一组丰富的静态工厂，可以轻松创建集合
		text.applyStyles(EnumSet.of(Style.BOLD, Style.ITALIC));	// 3
	}
}
