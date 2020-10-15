package com.jueee.item40;

import java.util.HashSet;
import java.util.Set;

/**
 * @author hzweiyongqiang
 */
public class Item40Example02 {

	private final char first;
	private final char second;

	public Item40Example02(char first, char second) {
		this.first = first;
		this.second = second;
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Item40Example02)) {
		    return false;
		}
		Item40Example02 b = (Item40Example02) o;
		return b.first == first && b.second == second;
	}

	@Override
	public int hashCode() {
		return 31 * first + second;
	}

	public static void main(String[] args) {
		Set<Item40Example02> s = new HashSet<>();
		for (int i = 0; i < 10; i++) {
			for (char ch = 'a'; ch <= 'z'; ch++) {
				s.add(new Item40Example02(ch, ch));
			}
		}
		System.out.println(s.size());	// 26
	}
}
