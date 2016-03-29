package projectEuler;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


/**
 * Starting in the top left corner of a 2×2 grid, and only being able to move to the right and down, 
 * there are exactly 6 routes to the bottom right corner.<p>
 * 
 * How many such routes are there through a 20×20 grid?
 * @author Alex
 *
 */
public class ProjectEuler015 {
	private int width, height;

	private BigInteger[][] nodePaths;

	public BigInteger solve(final int width, final int height){
		//So recursive method can access
		this.width = width;
		this.height = height;
		
		//Can only move right or down, min/max moves are equal
		int requiredMoves = width + height;		
		
		//Saves the amount of paths from a certain node
		//+1 to both dimensions because a "node" is any corner on the grid
		//i.e. a 3x3 box will have 4x4 nodes.
		nodePaths = new BigInteger[width + 1][height + 1];
		
		//Fill nodePaths with zeroed values
		for(int y = 0; y < nodePaths.length; y++){
			for(int x = 0; x < nodePaths[y].length; x++){
				nodePaths[x][y] = new BigInteger("0");
			}
		}
		
		
		//Call recursive method		
		BigInteger paths = checkNode(requiredMoves, 0, 0);
		
		return paths;
	}
	
	private BigInteger checkNode(final int movesRemain, final int x, final int y){
				
		//Has already been calculated
		if( !(nodePaths[x][y].equals(BigInteger.ZERO))){
			return nodePaths[x][y];
		}	
		
		if(movesRemain > 0){	
			
			BigInteger totalPaths = new BigInteger("0");
			
			//Check right
			if( !(x + 1 > width)){			
				totalPaths = totalPaths.add(checkNode(movesRemain - 1, x + 1, y));
			}		
			//Check down
			if( !(y + 1 > height)){
				totalPaths = totalPaths.add(checkNode(movesRemain - 1, x, y + 1));
			}
			
			nodePaths[x][y] = totalPaths;
			
			return totalPaths;
			
		}
		else{
			return BigInteger.ONE;
		}
	}
}
