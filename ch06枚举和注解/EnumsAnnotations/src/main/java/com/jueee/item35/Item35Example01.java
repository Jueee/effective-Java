package com.jueee.item35;

/**
 * 
 * @author hzweiyongqiang
 */
public class Item35Example01 {

	/**
	 * Abuse of ordinal to derive an associated value - DON'T DO THIS
	 * @author hzweiyongqiang
	 */
	public enum Ensemble {
	    SOLO,   DUET,   TRIO, QUARTET, QUINTET,
	    SEXTET, SEPTET, OCTET, NONET,  DECTET;

	    public int numberOfMusicians() { return ordinal() + 1; }
	}

}
