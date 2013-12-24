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
		for (int i = worldOfCells.length - 1; i >= 0; i--) {
			for (int j = 0; j < worldOfCells[i].length; j++) {
				if (worldOfCells[i][j].equals(Cell.ALIVE)) {
					if (countLivingSiblings(i, j) == 2
							|| countLivingSiblings(i, j) == 3) {
						continue;
					} else {
						worldOfCells[i][j] = Cell.DYING;
						continue;
					}
				} 
				
				if (worldOfCells[i][j].equals(Cell.DEAD)) {
					if (countLivingSiblings(i, j) == 3)
						worldOfCells[i][j] = Cell.REBORN;
//				else	assert cell stays dead
				}
			}
		}
//		cleanup-transform
		transform(Cell.REBORN, Cell.ALIVE);
		transform(Cell.DYING, Cell.DEAD);
		
		
	}

	/* private */ int countLivingSiblings(int x, int y) {
		int c = 0;
		try {
			if (worldOfCells[(x + 1)][(y + 1)].equals(Cell.ALIVE))
				c++;
		} catch (ArrayIndexOutOfBoundsException e) {
		}
		try {
			if (worldOfCells[x + 1][y].equals(Cell.ALIVE))
				c++;
		} catch (ArrayIndexOutOfBoundsException e) {
		}
		try {
			if (worldOfCells[x + 1][y - 1].equals(Cell.ALIVE))
				c++;
		} catch (ArrayIndexOutOfBoundsException e) {
		}
		try {
			if (worldOfCells[x][y - 1].equals(Cell.ALIVE))
				c++;
		} catch (ArrayIndexOutOfBoundsException e) {
		}
		try {
			if (worldOfCells[x][y + 1].equals(Cell.ALIVE))
				c++;
		} catch (ArrayIndexOutOfBoundsException e) {
		}
		try {
			if (worldOfCells[x - 1][y + 1].equals(Cell.ALIVE))
				c++;
		} catch (ArrayIndexOutOfBoundsException e) {
		}
		try {
			if (worldOfCells[x - 1][y].equals(Cell.ALIVE))
				c++;
		} catch (ArrayIndexOutOfBoundsException e) {
		}
		try {
			if (worldOfCells[x - 1][y - 1].equals(Cell.ALIVE))
				c++;
		} catch (ArrayIndexOutOfBoundsException e) {
		}
		try {
			if (worldOfCells[(x + 1)][(y + 1)].equals(Cell.DYING))
				c++;
		} catch (ArrayIndexOutOfBoundsException e) {
		}
		try {
			if (worldOfCells[x + 1][y].equals(Cell.DYING))
				c++;
		} catch (ArrayIndexOutOfBoundsException e) {
		}

		try {
			if (worldOfCells[x + 1][y - 1].equals(Cell.DYING))
				c++;
		} catch (ArrayIndexOutOfBoundsException e) {
		}
		try {
			if (worldOfCells[x][y - 1].equals(Cell.DYING))
				c++;
		} catch (ArrayIndexOutOfBoundsException e) {
		}
		try {
			if (worldOfCells[x][y + 1].equals(Cell.DYING))
				c++;
		} catch (ArrayIndexOutOfBoundsException e) {
		}
		try {
			if (worldOfCells[x - 1][y + 1].equals(Cell.DYING))
				c++;
		} catch (ArrayIndexOutOfBoundsException e) {
		}
		try {
			if (worldOfCells[x - 1][y].equals(Cell.DYING))
				c++;
		} catch (ArrayIndexOutOfBoundsException e) {
		}
		try {
			if (worldOfCells[x - 1][y - 1].equals(Cell.DYING))
				c++;
		} catch (ArrayIndexOutOfBoundsException e) {
		}

		return c;

	}

	public void showBoard() {
		for (int i = worldOfCells.length - 1; i >= 0; i--) {
			System.out.print(" \n" + (i) + " ");
			for (int j = 0; j < worldOfCells[i].length; j++) {
				System.out.print(worldOfCells[i][j].sign);
			}
		}
	}

	 /* private */ void transform(Cell from, Cell to) {
			for (int i = worldOfCells.length - 1; i >= 0; i--) {
				for (int j = 0; j < worldOfCells[i].length; j++) {
					 if(worldOfCells[i][j].equals(from))
						 worldOfCells[i][j] = to ;
				}
			}
	}

}
