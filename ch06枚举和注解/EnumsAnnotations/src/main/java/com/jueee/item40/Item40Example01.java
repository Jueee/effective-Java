package com.jueee.item40;

import java.util.HashSet;
import java.util.Set;

/**
 * Can you spot the bug?
 * @author hzweiyongqiang
 */
public class Item40Example01 {

	private final char first;
	private final char second;

	public Item40Example01(char first, char second) {
		this.first = first;
		this.second = second;
	}

	public boolean equals(Item40Example01 b) {
		return b.first == first && b.second == second;
	}

	public int hashCode() {
		return 31 * first + second;
	}

	public static void main(String[] args) {
		Set<Item40Example01> s = new HashSet<>();
		for (int i = 0; i < 10; i++) {
			for (char ch = 'a'; ch <= 'z'; ch++) {
				s.add(new Item40Example01(ch, ch));
			}
		}
		System.out.println(s.size());	// 260
	}
}
