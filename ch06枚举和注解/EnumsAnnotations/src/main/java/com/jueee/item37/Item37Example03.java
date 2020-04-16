package com.jueee.item37;

import java.awt.List;
import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author hzweiyongqiang
 */
public class Item37Example03 {

	/**
	 * Using ordinal() to index array of arrays - DON'T DO THIS!
	 * @author hzweiyongqiang
	 */
	public enum Phase {
	    SOLID, LIQUID, GAS;

	    public enum Transition {
	        MELT, FREEZE, BOIL, CONDENSE, SUBLIME, DEPOSIT;
	        // Rows indexed by from-ordinal, cols by to-ordinal
	        private static final Transition[][] TRANSITIONS = {
	            { null,    MELT,     SUBLIME },
	            { FREEZE,  null,     BOIL    },
	            { DEPOSIT, CONDENSE, null    }
	        };

	        // Returns the phase transition from one phase to another
	        public static Transition from(Phase from, Phase to) {
	            return TRANSITIONS[from.ordinal()][to.ordinal()];
	        }
	    }
	}

}
