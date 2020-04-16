package com.jueee.item37;

import java.util.EnumMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 
 * @author hzweiyongqiang
 */
public class Item37Example02 {

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
		// Using an EnumMap to associate data with an enum
		Map<LifeCycle, Set<Plant>> plantsByLifeCycle = new EnumMap<>(LifeCycle.class);

		for (LifeCycle lc : LifeCycle.values()) {
			plantsByLifeCycle.put(lc, new HashSet<>());
		}

		System.out.println(plantsByLifeCycle);

	}
}
