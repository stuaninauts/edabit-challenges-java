//Consecutive Numbers
//
//Create a function that determines whether elements in an array can be re-arranged to form a consecutive list of numbers where each number appears exactly once.
//
//Examples
//cons([5, 1, 4, 3, 2]) -> true
//// Can be re-arranged to form [1, 2, 3, 4, 5]
//cons([5, 1, 4, 3, 2, 8]) -> false
//cons([5, 6, 7, 8, 9, 9]) -> false
//// 9 appears twice

package hard;

import java.util.Arrays;

public class ConsecutiveNumbers {

	public static void main(String[] args) {
		int[] intVect = new int[] {1,2,2,3,5 };

		System.out.println(cons(intVect));
	}
	
	// an = a1 + (n-1) * r
	public static boolean cons(int[] intVect) {
		Arrays.sort(intVect);
		int min = intVect[0];
		int ratio = 1;
		for (int i = 0; i < intVect.length - 1; i++) {
			if (ratio != intVect[i + 1] - (min + i + 1 - 1)) {
				return false;
			}
		}
		return true;
	}
}
