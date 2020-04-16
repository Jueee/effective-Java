package com.jueee.item37;

import java.awt.List;
import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author hzweiyongqiang
 */
public class Item37Example01 {

	/**
	 * 
	 * @author hzweiyongqiang
	 */
	public enum LifeCycle {
		ANNUAL("一年生"), PERENNIAL("多年生"), BIENNIAL("双年生");

		private String action;

		LifeCycle(String action) {
			this.action = action;
		}

		public String getAction() {
			return action;
		}
	}

	public class Plant {

		final String name;
		final LifeCycle lifeCycle;

		Plant(String name, LifeCycle lifeCycle) {
			this.name = name;
			this.lifeCycle = lifeCycle;
		}

		@Override
		public String toString() {
			return name;
		}
	}

	public static void main(String[] args) {
		
		// Using ordinal() to index into an array - DON'T DO THIS!
		Set<Plant>[] plantsByLifeCycle = (Set<Plant>[]) new Set[LifeCycle.values().length];

		for (int i = 0; i < plantsByLifeCycle.length; i++) {
			plantsByLifeCycle[i] = new HashSet<>();
		}

		// Print the results
		for (int i = 0; i < plantsByLifeCycle.length; i++) {
			System.out.printf("%s: %s%n", LifeCycle.values()[i], plantsByLifeCycle[i]);
		}

	}
}
