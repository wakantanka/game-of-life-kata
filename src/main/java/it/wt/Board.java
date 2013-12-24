/**
 * 
 */
package it.wt;

import java.util.Arrays;

/**
 * @author jan
 * 
 */
public class Board {
	private Cell[][] worldOfCells;

	public Board(int i, int j) {
		worldOfCells = new Cell[i][j];

	}

	public void summonCell(int i, int j) {
		worldOfCells[i][j] = Cell.ALIVE;

	}

	public Cell getCell(int i, int j) {
		return worldOfCells[i][j];
	}

	@Override
	public String toString() {
		return "Board [worldOfCells=" + Arrays.toString(worldOfCells) + "]";
	}

	public void nextGenerationTurn() {
		for (int i = worldOfCells.length-1; i > 0; i--) {
			System.out.print(" \n" + (i+1) + " ");
			for (int j = 0; j < worldOfCells.length; j++) {
				if (worldOfCells[i][j].equals(Cell.ALIVE)) {
					System.out.print(" + ");
				}
				else if   (worldOfCells[i][j].equals(Cell.DEAD)) {
					System.out.print(" - ");
				}
				else if  (worldOfCells[i][j].equals(Cell.REBORN)) {
					System.out.print(" * ");
				}
				else if  (worldOfCells[i][j].equals(Cell.DYING)) {
					System.out.print(" x ");
				}
				else{
					System.out.print(" # ");
				}
				// System.out.println( "Cell=" + worldOfCells[i][j] + "");
			}

		}

	}

}
