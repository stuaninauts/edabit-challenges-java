//Recursion: Count The Digits
//
//Create a function that will recursively count the number of digits of a number. 
//Conversion of the number to a string is not allowed, thus, the approach is recursive.
//
//Examples
//digitsCount(4666) -> 4
//digitsCount(544) -> 3
//digitsCount(121317) -> 6
//digitsCount(0) -> 1
//digitsCount(12345) -> 5
//digitsCount(1289396387328L) -> 13

package very_hard;

public class RecursionCountTheDigits {

	public static void main(String[] args) {
		System.out.println(digitsCount2(12345));
	}
	
	public static int count = 1;
	public static int digitsCount(long n) {
		if (n > 9) {
			count +=1;
			digitsCount(n/10);
		} 
		return count;
	}
	
	public static int digitsCount2(long n) {
		return Math.abs(n) < 10L ? 1 : 1 + digitsCount2(n/10L);
	}

}
