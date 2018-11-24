package array.problems;

import static org.junit.Assert.*;

import java.rmi.server.SocketSecurityException;
import java.util.HashMap;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class RobotGrid {

	public static boolean percolate( boolean[][] grid) {
		if(grid == null || grid.length == 0) {
			throw new IllegalArgumentException("Array cant be null or empty");
		}
		return percolateHelper( grid, grid.length -1, grid[0].length - 1);
	}
	
	public static boolean percolateHelper(boolean[][] grid, int row, int col) {
		if (row == 0 && col == 0) return true;
		if (row < 0 || col < 0 || !grid[row][col]) {
			return false;
		}
		else {
			return percolateHelper(grid, row-1, col) || percolateHelper(grid, row, col-1);
		}
	}

	public boolean percolateDynamic(boolean[][] grid) {
		System.out.println("start");
		if (grid == null || grid.length == 0) {
			throw new IllegalArgumentException("Array cant be null or empty");
		}
		HashMap<String, Boolean> cache = new HashMap<>();
		
		return percolateDynamicHelper(grid, grid.length - 1, grid[0].length -1,cache);
	}
	
	public boolean percolateDynamicHelper(boolean[][] grid, int row, int col, HashMap<String,Boolean> cache) {
		
		if (row < 0 || col < 0 || !grid[row][col]) {
			return false;
		}
		
		String p = String.valueOf(row)+String.valueOf(col);
		//System.out.println(cache.size());
		if (cache.containsKey(p)) {
			System.out.println("cache used");
			return cache.get(p);
		}
		//System.out.println("something");
		boolean isAtOrigin = row == 0 && col == 0;
		
		if(isAtOrigin) {
			System.out.println("here");
			cache.put(p, true);
			return true;
		}
		boolean success = percolateDynamicHelper(grid, row-1, col, cache) || percolateDynamicHelper(grid, row, col-1, cache);
		System.out.println(success);
		cache.put(p,success);
		System.out.println(cache.size());
		return success;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	
	@Test
	public void testdynamic() {
		boolean[][] grid = new boolean[][] {
			new boolean[] { true, false, false, false},
			new boolean[] { true, true, true, false},
			new boolean[] { true, false, true, true},
			new boolean[] { true, false, false, true}
		};
		RobotGrid r = new RobotGrid();
		assertEquals(true, r.percolateDynamic(grid));
		
	}
	
	@Test
	public void testFalse() {
		boolean[][] grid = new boolean[][] {
			new boolean[] { true, false, false, false},
			new boolean[] { true, true, true, false},
			new boolean[] { true, false, true, true},
			new boolean[] { true, false, false, false}
		};
		assertEquals(false, percolate(grid));
		
	}
	
	@Test
	public void testTrue() {
		boolean[][] grid = new boolean[][] {
			new boolean[] { true, false, false, false},
			new boolean[] { true, true, true, true},
			new boolean[] { true, false, false, true},
			new boolean[] { true, false, false, true}
		};
		
		assertEquals(true, percolate(grid));
	}
	@Rule
	public ExpectedException e= ExpectedException.none();
	
	@Test//to be 
	public void testNull() {
		e.expect(IllegalArgumentException.class);
//		e.expectMessage("");
		percolate(null);
	}

}
