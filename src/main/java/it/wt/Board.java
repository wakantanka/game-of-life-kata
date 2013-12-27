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

	public Board(int x, int y) {
		//@TODO unentdlich grosse welt
		//@TODO kugeloberfläche (geht auf der anderen Seite weiter)
		//@TODO 3d welt
		worldOfCells = new Cell[x][y];
		for (int i = 0; i < worldOfCells.length; i++) {
			for (int j = 0; j < worldOfCells[i].length; j++) {
				worldOfCells[i][j] = Cell.DEAD;
			}
		}

	}

	public void summonCell(int x, int y) {
		//@TODO check against borders
//		worldOfCells[x-1][y-1] = Cell.ALIVE;
		worldOfCells[x][y] = Cell.ALIVE;

	}
	//@TODO check against borders
	public Cell getCell(int x, int y) {
//		return worldOfCells[x-1][y-1];
		return worldOfCells[x][y];
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
//@TODO refactor
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

	public void showBoard_bad() {
		for (int i = worldOfCells.length - 1; i >= 0; i--) {
//			System.out.print(" \n" + (i) + " ");
			for (int j = (worldOfCells[i].length - 1); j >= 0 ; j--) {
				System.out.print(worldOfCells[i][j].sign);
			}
			System.out.println();
		}
	}
	
	public void showBoard2() {
		for (int i = 0; i < worldOfCells.length; i++) {
			for (int j = (worldOfCells[i].length - 1); j >= 0 ; j--) {
				
				System.out.print(worldOfCells[i][j].sign );
			}
			System.out.println();
		}
	}
	public void showBoard() {
		 int j = worldOfCells[0].length - 1;
				
				for ( ; j >= 0 ; j--) {	
					for (int i = 0; i < worldOfCells.length; i++) {
				System.out.print(worldOfCells[i][j].sign );
				
			}
					System.out.println();
		}
				System.out.println("___________________");
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
