//Persistent Little Bugger
//
//Create a function that takes a number and returns its multiplicative persistence, which is the number of times you must multiply the digits in num until you reach a single digit.
//
//Examples
//bugger(39) -> 3
// // Because 3 * 9 = 27, 2 * 7 = 14, 1 * 4 = 4 and 4 has only one digit.
//bugger(999) -> 4
// // Because 9 * 9 * 9 = 729, 7 * 2 * 9 = 126, 1 * 2 * 6 = 12, and finally 1 * 2 = 2.
//bugger(4) -> 0
// // Because 4 is already a one-digit number.

package hard;

import java.util.ArrayList;
import java.util.List;


public class PersistentLittleBugger {

	public static void main(String[] args) {		
	
		System.out.println("Bugger: " + bugger(1111));
	}

	public static int bugger(int num) {
		int count = 0;
		if (num > 9) {
			while (num > 9) {
				List<Integer> numList = new ArrayList<>();
				while (num > 0) {
					numList.add(num % 10);
					num = num / 10;
				}
				num = numList.stream().reduce(1, (x, y) -> x * y);
				count++;
			}
		}
		return count;
	}
}
