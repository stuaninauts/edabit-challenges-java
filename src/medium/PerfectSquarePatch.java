//Perfect Square Patch
//
//Create a function that takes an integer and outputs an n x n square solely consisting of the integer n.
//
//Examples
//squarePatch(3) -> 
//  [3, 3, 3],
//  [3, 3, 3],
//  [3, 3, 3]
//squarePatch(5) ->  
//  [5, 5, 5, 5, 5],
//  [5, 5, 5, 5, 5],
//  [5, 5, 5, 5, 5],
//  [5, 5, 5, 5, 5],
//  [5, 5, 5, 5, 5]
//squarePatch(1) ->  
//  [1]
//squarePatch(0) ->  []

package medium;

import java.util.stream.Stream;

public class PerfectSquarePatch {

	public static void main(String[] args) {
		int[][] matrix = squarePatch2(5);
		for (int i=0; i<matrix.length; i++) {
			for (int j=0; j<matrix.length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static int[][] squarePatch(int n) {
		int[][] matrix = new int[n][n];
		for (int i=0; i<n; i++) {
			for (int j=0; j<n; j++) {
				matrix[i][j] = n;
			}
		}
		return matrix;	
	}
	
	public static int[][] squarePatch2(int n) {
		int [][] matrix = Stream.generate(() -> n)
		        .limit(n)
		        .map(size -> Stream.generate(() -> size)
		        .limit(size)
		        .mapToInt(Integer::intValue)
		        .toArray())
		        .toArray(int[][]::new);
		return matrix;
	}
}
