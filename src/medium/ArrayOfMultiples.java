//Array of Multiples
//
//Create a function that takes two numbers as arguments (num, length)
//and returns an array of multiples of num until the array length reaches length.
//
//Examples
//arrayOfMultiples(7, 5) -> [7, 14, 21, 28, 35]
//arrayOfMultiples(12, 10) -> [12, 24, 36, 48, 60, 72, 84, 96, 108, 120]
//arrayOfMultiples(17, 6) -> [17, 34, 51, 68, 85, 102]
		
package medium;

import java.util.Arrays;
import java.util.stream.IntStream;

public class ArrayOfMultiples {

public static void main(String[] args) {
	
		System.out.println(Arrays.toString(arrayOfMultiples(7, 5)));
		
	}
	
	public static int[] arrayOfMultiples(int num, int length) {
		return IntStream
				.rangeClosed(1, length)
				.map(i -> i * num)
				.toArray();
	}

}
