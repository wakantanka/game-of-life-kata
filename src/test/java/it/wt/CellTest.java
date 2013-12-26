/**
 * 
 */
package it.wt;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author jan
 *
 */
public class CellTest {

	@Before
	public void setUp() throws Exception {
	} 

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testStartCellIsAlive() {
		Board board67 = new Board(6,7);
		int x = 3;
		int y = 4;
		
		board67.summonCell(x,y);
//		System.out.println(board67.getCell(x,y).toString());
		assertEquals(Cell.ALIVE, board67.getCell(x,y));
		board67.showBoard();
//		System.out.println(board66.getCell(x,y).name());
//		assertEquals(Cell.DEAD, board66.getCell(x,y));
	}
 @Test
	public void testStartCellIsAliveButDying() {
		Board board67 = new Board(6,7);
		
		board67.summonCell(1,2);
		System.out.println(board67.getCell(1,2).toString());
		assertEquals(Cell.ALIVE, board67.getCell(1,2));
		board67.nextGenerationTurn();
		assertEquals(Cell.DEAD, board67.getCell(1,2));
//		assertNotEquals(Cell.ALIVE, board67.getCell(1,2));
		board67.showBoard();
	}
	
 @Test
 public void testCountNoLivingSiblingsCellIsDying() {
	 Board board67 = new Board(6,7);
	 
	 board67.summonCell(1,2);
	 assertEquals(Cell.ALIVE, board67.getCell(1,2));
	 assertEquals(0,board67.countLivingSiblings(1, 2));
	 board67.nextGenerationTurn();
	 assertEquals(Cell.DEAD, board67.getCell(1,2));
 }
	@Test
	public void testCount4LivingSiblingsCellIsDying() {
		Board board67 = new Board(6,7);
		
		board67.summonCell(2,3); //cell
		board67.summonCell(2,2);
		board67.summonCell(3,2);
		board67.summonCell(3,3);
		board67.summonCell(1,3);
		assertEquals(Cell.ALIVE, board67.getCell(2,3));
		assertEquals(4,board67.countLivingSiblings(2, 3));
		board67.nextGenerationTurn();
		assertEquals(Cell.DEAD, board67.getCell(2,3));
		board67.showBoard();
	}
	
	@Test
	public void testCount3LivingSiblings() {
		Board board67 = new Board(6,7);
		
		board67.summonCell(2,3); //cell
		board67.summonCell(2,2);
		board67.summonCell(3,2);
		board67.summonCell(3,3);
		board67.showBoard();
		assertEquals(Cell.ALIVE, board67.getCell(2,3));
		assertEquals(3,board67.countLivingSiblings(2, 3));
		
	}
	@Test
	public void testTransform() {
		Board board67 = new Board(6,7);
		
		board67.summonCell(1,2);
		
		assertEquals(Cell.ALIVE, board67.getCell(1,2));
		board67.transform(Cell.ALIVE,Cell.DYING);
		
		assertEquals(Cell.DYING, board67.getCell(1,2));
		
		
	}
	@Test
	public void testGlider() {
		Board board88 = new Board(9,9);
		
		board88.summonCell(0,1);
		board88.summonCell(1,1);
		board88.summonCell(2,1);
		board88.summonCell(2,2);
		board88.summonCell(1,3);

		assertEquals(Cell.ALIVE, board88.getCell(1,3));
		board88.showBoard();
		board88.nextGenerationTurn();
		assertEquals(Cell.DEAD, board88.getCell(1,3));
		assertEquals(Cell.ALIVE, board88.getCell(0,2));

		for (int i = 0; i < 3; i++) {
			board88.showBoard();
			board88.nextGenerationTurn();
		}
			board88.showBoard();
			assertEquals(Cell.ALIVE, board88.getCell(1,0));
		
		
		
		
	}
	

}
