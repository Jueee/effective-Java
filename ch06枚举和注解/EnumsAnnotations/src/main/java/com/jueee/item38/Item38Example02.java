package com.jueee.item38;

import java.util.Arrays;
import java.util.Collection;

/**
 * 
 * @author hzweiyongqiang
 */
public class Item38Example02 {

	private static void test(Collection<? extends Operation> opSet, double x, double y) {
		for (Operation op : opSet) {
			System.out.printf("%f %s %f = %f%n", x, op, y, op.apply(x, y));
		}
	}

	public static void main(String[] args) {
		String[] testArgs = new String[] {"3.6", "4.9"}; 
		
		double x = Double.parseDouble(testArgs[0]);
		double y = Double.parseDouble(testArgs[1]);
		test(Arrays.asList(ExtendedOperation.values()), x, y);
	}

}