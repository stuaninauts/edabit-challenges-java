//Unmix My Strings
//lPaeesh le pemu mnxit ehess rtnisg! 
//Oh, sorry, that was supposed to say: Please help me unmix these strings!
//
//Somehow my strings have all become mixed up; every pair of characters 
//has been swapped. Help me undo this so I can understand my strings again.
//
//Examples
//unmix("123456") -> "214365"
//unmix("hTsii  s aimex dpus rtni.g") -> "This is a mixed up string."
//unmix("badce") -> "abcde"

package hard;

public class UnmixStrings {

	public static void main(String[] args) {
		System.out.println(unmix2("123456"));
	}

	public static String unmix(String str) {
		String unmixedStr = "";
		char[] srcStr = str.toCharArray();
		char[] newStr = srcStr;
		char aux;
		for (int i=0; i<str.length(); i++) {
				if (i % 2 == 0  && i != str.length()-1) {
					aux =  newStr[i];
					newStr[i] = srcStr[i+1];
					newStr[i+1] = aux;
				} 
				unmixedStr += (newStr[i]);
		}
		return unmixedStr;
	}
	
	public static String unmix2(String str) {
		return str.replaceAll("(.)(.)","$2$1");
	}

}
