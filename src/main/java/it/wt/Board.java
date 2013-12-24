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
		for (int j2 = 0; j2 < worldOfCells.length; j2++) {
			for (int k = 0; k < worldOfCells[j2].length; k++) {
				worldOfCells[j2][k] = Cell.DEAD;
			}
		}

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
		for (int i = worldOfCells.length-1; i >= 0; i--) {
			System.out.print(" \n" + (i) + " ");
			for (int j = 0; j < worldOfCells[i].length; j++) {
				if (worldOfCells[i][j]==null)
				{
					System.out.print(" # ");
				continue;
				}
				if (worldOfCells[i][j].equals(Cell.ALIVE)) {
					countLivingSiblings(i, j);
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

	/* private*/ int countLivingSiblings(int x, int y) {
		int c=0;
		if ((worldOfCells[(x+1)][(y+1)]!=null) && (worldOfCells[(x+1)][(y+1)].equals(Cell.ALIVE))) c++;
		if (worldOfCells[x+1][y].equals(Cell.ALIVE)) c++;
		if (worldOfCells[x+1][y-1].equals(Cell.ALIVE)) c++;
		if (worldOfCells[x][y-1].equals(Cell.ALIVE)) c++;
		if (worldOfCells[x][y+1].equals(Cell.ALIVE)) c++;
		if (worldOfCells[x-1][y+1].equals(Cell.ALIVE)) c++;
		if (worldOfCells[x-1][y].equals(Cell.ALIVE)) c++;
		if (worldOfCells[x-1][y-1].equals(Cell.ALIVE)) c++;
		
		return c;
		
	}

}
