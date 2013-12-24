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

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testStartCellIsAlive() {
		Board board66 = new Board(6,6);
		
		board66.summonCell(1,1);
		assertEquals(Cell.ALIVE, board66.getCell(1,1));
		board66.nextGenerationTurn();
//		assertEquals(Cell.DEAD, board66.getCell(1,1));
	}

}
