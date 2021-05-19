//Product of Digits of Sum
//
//Create a function that takes numbers as arguments, adds them together, and returns 
//the product of digits until the answer is only 1 digit long.
//
//Examples
//sumDigProd(16, 28) -> 6
//// 16 + 28 = 44
//// 4 * 4 =  16
//// 1 * 6 = 6
//sumDigProd(0) -> 0
//sumDigProd(1, 2, 3, 4, 5, 6) -> 2

package very_hard;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class ProductOfDigitsOfSum {

	public static void main(String[] args) {
		System.out.println(sumDigProd2(16, 28));
	}
	
	public static long sumDigProd(int ... arr) {
		int result = 0;
		
		for (int i : arr) {
			result += i;
		}
		
		if (result > 9) {
			do {		
				List<Integer> digitsList = new ArrayList<>();
				while (result > 0) {
					digitsList.add(result % 10);
					result /= 10;
				}	
				result = digitsList.stream().reduce(1, (x,y) -> x * y);		
			} while (result > 9);
			return result;	
		} else {
			return result;
		}
	}
	
	public static long sumDigProd2(int ... arr) {
		int sum = IntStream.of(arr).sum();
		while(sum > 9){
			sum = IntStream
					.of(Integer.toString(sum)
					.chars()
					.map(z -> z - '0')
					.toArray())
					.reduce(1, (x, y) -> x * y);
		}
		return sum;
	}
}
