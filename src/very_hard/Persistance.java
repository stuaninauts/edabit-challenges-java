//Persistance
//The additive persistence of an integer, n, 
//is the number of times you have to replace n 
//with the sum of its digits until n becomes a single digit integer.
//
//The multiplicative persistence of an integer, n, 
//is the number of times you have to replace n 
//with the product of its digits until n becomes a single digit integer.
//
//Create two functions that take an integer as an argument and:
//Return its additive persistence.
//Return its multiplicative persistence.
//
//Examples: Additive Persistence
//additivePersistence(1679583) -> 3
//// 1 + 6 + 7 + 9 + 5 + 8 + 3 = 39
//// 3 + 9 = 12
//// 1 + 2 = 3
//// It takes 3 iterations to reach a single-digit number.
//additivePersistence(123456) -> 2
//// 1 + 2 + 3 + 4 + 5 + 6 = 21
//// 2 + 1 = 3
//additivePersistence(6) -> 0
//// Because 6 is already a single-digit integer.
//
//Examples: Multiplicative Persistence
//multiplicativePersistence(77) -> 4
//// 7 x 7 = 49
//// 4 x 9 = 36
//// 3 x 6 = 18
//// 1 x 8 = 8
//// It takes 4 iterations to reach a single-digit number.
//multiplicativePersistence(123456) -> 2
//// 1 x 2 x 3 x 4 x 5 x 6 = 720
//// 7 x 2 x 0 = 0
//multiplicativePersistence(4) -> 0
//// Because 4 is already a single-digit integer.

package very_hard;

import java.util.ArrayList;
import java.util.List;

public class Persistance {

	public static void main(String[] args) {
		System.out.println(additivePersistence(12345));
		System.out.println(multiplicativePersistence(77));
	}

	public static int additivePersistence(int n) {
		int count = 0;
		
		if (n > 9) {
			while (n > 9) {
				List<Integer> list = new ArrayList<>();
				while (n > 0) {
					list.add(n%10);
					n /= 10;
				}
				n = list.stream().reduce(0, (x,y) -> x + y);
				count ++;
			}
		}

		return count;
	}

	public static int multiplicativePersistence(int n) {
		int count = 0;
		
		if (n > 9) {
			while (n > 9) {
				List<Integer> list = new ArrayList<>();
				while (n > 0) {
					list.add(n % 10);
					n /= 10;
				}
				n = list.stream().reduce(1, (x,y) -> x * y);
				count++;
			}
		}
		
		return count;
	}
}
