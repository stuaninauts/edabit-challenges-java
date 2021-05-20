//War of Numbers
//There's a great war between the even and odd numbers. 
//Many numbers already lost their life in this war and 
//it's your task to end this. You have to determine which 
//group sums larger: the even, or the odd. The larger group wins.
//
//Create a function that takes an array of integers, 
//sums the even and odd numbers separately, 
//then returns the difference between sum of even and odd numbers.
//
//Examples
//warOfNumbers([2, 8, 7, 5]) -> 2
//// 2 + 8 = 10
//// 7 + 5 = 12
//// 12 is larger than 10
//// So we return 12 - 10 = 2
//warOfNumbers([12, 90, 75]) -> 27
//warOfNumbers([5, 9, 45, 6, 2, 7, 34, 8, 6, 90, 5, 243]) -> 168

package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WarOfNumbers {

	public static void main(String[] args) {
		int[] numbers = new int[] {12, 90, 75};
		System.out.println(warOfNumbers(numbers));

	}

	public static int warOfNumbers(int[] numbers) {
		return Math.abs(Arrays.stream(numbers).reduce(0, (x, y) -> (y % 2) == 0 ? x + y : x - y));
	}
	
	public static int warOfNumbers2(int[]numbers){
		List<Integer> odd = new ArrayList<>();
		List<Integer> even = new ArrayList<>();
		
		for (int i=0; i<numbers.length; i++) {
			if (numbers[i] % 2 == 0) 
				even.add(numbers[i]);
			else
				odd.add(numbers[i]);
		}
		
		return Math.abs((odd.stream().reduce(0, (x,y) -> x + y)) - (even.stream().reduce(0, (x,y) -> x + y)));
	}
}
