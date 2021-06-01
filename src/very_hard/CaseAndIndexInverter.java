//Case and Index Inverter
//
//Write a function that takes a string input and returns the string in a reversed case and order.
//
//Examples
//invert("dLROW YM sI HsEt") -> "TeSh iS my worlD"
//invert("ytInIUgAsnOc") -> "CoNSaGuiNiTY"
//invert("step on NO PETS") -> "step on NO PETS"
//invert("XeLPMoC YTiReTXeD") -> "dExtErIty cOmplEx"

package very_hard;

public class CaseAndIndexInverter {

	public static void main(String[] args) {
		System.out.println(invert("dLROW YM sI HsEt"));
		System.out.println(invert("ytInIUgAsnOc"));
		System.out.println(invert2("abcdef"));
		
	}
	
	public static String invert(String str) {
		String newStr = "";
		for (int i=str.length()-1; i>=0; i--) {
			if (Character.isUpperCase(str.charAt(i))) {
				newStr += Character.toLowerCase(str.charAt(i));
			} else {
				newStr += Character.toUpperCase(str.charAt(i));
			}
		}

		return newStr;
	}

	public static String invert2(String str) {
		String newStr = "";
		for (String s : str.split("")) {
			newStr = (s.toUpperCase().equals(s)	 ? s.toLowerCase() : s.toUpperCase()) + newStr;
		}
		return newStr;
	}
}
