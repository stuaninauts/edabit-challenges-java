//Almost Palindrome
//A string is an almost-palindrome if, by changing only one character, 
//you can make it a palindrome. Create a function that returns true 
//if a string is an almost-palindrome and false otherwise.
//
//Examples
//almostPalindrome("abcdcbg") -> true
//// Transformed to "abcdcba" by changing "g" to "a".
//almostPalindrome("abccia") -> true
//// Transformed to "abccba" by changing "i" to "b".
//almostPalindrome("abcdaaa") -> false
//// Can't be transformed to a palindrome in exactly 1 turn.
//almostPalindrome("1234312") -> false

package hard;

public class AlmostPalindrome {

	public static void main(String[] args) {
		String str = "abcdaaa";
		System.out.println(almostPalindrome2(str));
	}

	public static boolean almostPalindrome(String str) {
		int changes = 0;
		char[] letters = str.toCharArray();
		
		for (int i=0; i<str.length()/2; i++) 
			if (letters[i] != str.charAt(str.length()-1-i)) 
				changes++;
		
		return changes==1;
	}
	 
	public static boolean almostPalindrome2(String str) {
		int changes = 0;
		
		for (int i=0, j=str.length()-1; i<j || changes<2; i++, j--) 
			if (str.charAt(i) != str.charAt(j))
				changes++;
		
		return changes==1;
	}
		
}
