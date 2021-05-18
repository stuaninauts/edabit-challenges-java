//Recursion: Array Sum
//
//Write a function that finds the sum of an array. Make your function recursive.
//
//Examples
//sum([1, 2, 3, 4]) -> 10
//sum([1, 2]) -> 3
//sum([1]) -> 1
//sum([]) -> 0

package medium;

import java.util.Arrays;

public class RecursionArraySum {

	public static void main(String[] args) {
		
		int[] sumInt = {1,2,3,4};
		
		System.out.println(sum2(sumInt));
	}

	public static int sum(int[] arr) {
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		return sum;
	}

	public static int sum2(int[] arr) {
		if (arr == null || arr.length == 0) {
			return 0;
		}
		if (arr.length == 1) {
			return arr[0];
		}

		return arr[0] + sum2(Arrays.copyOfRange(arr, 1, arr.length));
	}
}
