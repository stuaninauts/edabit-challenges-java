//How Many "Prime Numbers" Are There?
//
//Create a function that finds how many prime numbers there are, up to the given integer.
//
//Examples
//primeNumbers(10) -> 4
// // 2, 3, 5 and 7
//primeNumbers(20) -> 8
// // 2, 3, 5, 7, 11, 13, 17 and 19
//primeNumbers(30) -> 10
// // 2, 3, 5, 7, 11, 13, 17, 19, 23 and 29

package hard;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


public class HowManyPrimeNumbers {

	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		
		System.out.println(primeNumbers(sc.nextInt()));

		
		sc.close();
	}
	
	public static int primeNumbers(int num) {
		Set<Integer> nonPrimeSet = new HashSet<>();
		int divisors;
		int nonPrime;
		
		for (int i=2; i<=num; i++) {
			if (!nonPrimeSet.contains(i)) {
				divisors = 0;
				for (int j=1; j<=i; j++) {
					if (i % j == 0) {
						divisors += 1;
						if (divisors > 2) {
							break;
						}
					}
				}	
				if (divisors == 2) {
					nonPrimeSet.add(i);
				}	
			} 	
		}
		nonPrime = nonPrimeSet.size();
				
		return nonPrime;
	}
}
