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
		
		board67.summonCell(1,2);
		System.out.println(board67.getCell(1,2).toString());
		assertEquals(Cell.ALIVE, board67.getCell(1,2));
		board67.showBoard();
//		System.out.println(board66.getCell(1,1).name());
//		assertEquals(Cell.DEAD, board66.getCell(1,1));
	}
 @Test
	public void testStartCellIsAliveButDying() {
		Board board67 = new Board(6,7);
		
		board67.summonCell(1,2);
		System.out.println(board67.getCell(1,2).toString());
		assertEquals(Cell.ALIVE, board67.getCell(1,2));
		board67.nextGenerationTurn();
		assertEquals(Cell.DEAD, board67.getCell(1,2));
		assertNotEquals(Cell.ALIVE, board67.getCell(1,2));
		board67.showBoard();
	}
	
	@Test
	public void testCountNoLivingSiblings() {
		Board board67 = new Board(6,7);
		
		board67.summonCell(1,2);
		System.out.println(board67.getCell(1,2).toString());
		assertEquals(Cell.ALIVE, board67.getCell(1,2));
		assertEquals(0,board67.countLivingSiblings(1, 2));
//		nextTurn
//		assertEquals(Cell.DEAD, board67.getCell(1,2));
	}
	
	@Test
	public void testCount3LivingSiblings() {
		Board board67 = new Board(6,7);
		
		board67.summonCell(1,2);
		board67.summonCell(1,1);
		board67.summonCell(2,1);
		board67.summonCell(2,2);
		board67.showBoard();
		assertEquals(Cell.ALIVE, board67.getCell(1,2));
		assertEquals(3,board67.countLivingSiblings(1, 2));
		
	}
	@Test
	public void testTransform() {
		Board board67 = new Board(6,7);
		
		board67.summonCell(1,2);
		 
		assertEquals(Cell.ALIVE, board67.getCell(1,2));
		board67.transform(Cell.ALIVE,Cell.DYING);
		
		assertEquals(Cell.DYING, board67.getCell(1,2));
		
		
	}
	

}
