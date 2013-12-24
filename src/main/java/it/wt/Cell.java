/**
 * 
 */
package it.wt;

import java.util.Arrays;

/**
 * @author jan
 *
 */
public enum Cell {
	ALIVE("green"), DEAD, FOCUS, REBORN, DYING;

	String colour;	
	Cell() {}
			
	Cell(String c) { colour = c; }
	
	public String getColour() {
		return colour;
	}

	@Override
	public String toString() {
		return "Cell [Status=" + super.toString() + " color="+ this.getColour() + "]";
	}


}
