/**
 * 
 */
package it.wt;

import java.awt.Color;
import java.util.Arrays;

/**
 * @author jan
 * 
 */
public enum Cell {
	ALIVE("green", '+'), DEAD("red", '-'), FOCUS("Magenta", '§'), REBORN(
			"green", '*'), DYING("brown", 'x');

	String colour;
	char sign;
	Color acolour;

	Cell() {
	}

	Cell(String c) {
		colour = c;
	}

	Cell(String c, char s) {
		colour = c;
		sign = s;
	}

	public String getColour() {
		return colour;
	}

	@Override
	public String toString() {
		return "Cell [Status=" + super.toString() + " color="
				+ this.getColour() + "]";
	}

}
