/**
 * 
 */
package it.wt;

/**
 * @author jan
 *
 */
public class Board {
	private Cell[][] worldOfCells;

	public Board(int i, int j) {
		worldOfCells =  new Cell[i][j];
		
	}

	public void summonCell(int i, int j) {
		worldOfCells[i][j] = Cell.ALIVE;
				
	}

	public Cell getCell(int i, int j) {
		return worldOfCells[i][j];
	}

	public void nextGenerationTurn() {
		// TODO Auto-generated method stub
		
	}
   
}
