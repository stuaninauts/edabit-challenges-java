//12 vs 24 Hours
//
//Create a function that converts 12-hour time to 24-hour time or vice versa. 
//Return the output as a string.
//
//Examples
//convertTime("12:00 am") -> "0:00"
//convertTime("6:20 pm") -> "18:20"
//convertTime("21:00") -> "9:00 pm"
//convertTime("5:05") -> "5:05 am"

package hard;

import java.text.ParseException;

public class Hours12vs24 {

	
	public static void main(String[] args) throws ParseException {
		String time = "6:20 pm";
		
		System.out.println(convertTime2(time));

	}
	
	public static String convertTime(String time) {
		Integer pos = time.indexOf(":");
		Integer hour = Integer.parseInt(time.substring(0, pos));
		Integer newHour = 0;
		
		if (time.endsWith("pm")) {
			newHour = Math.abs(hour + 12);
			time = time.replace(" pm", "").replaceFirst(String.format("%d", hour), String.format("%d", newHour));
		
		} else if (time.endsWith("am")) {
			if (!time.contains("12:00"))
				newHour = hour;
			time = time.replace(" am", "").replaceFirst(String.format("%d", hour), String.format("%d", newHour));

		} else if (hour >= 12) {
			newHour = Math.abs(hour - 12);
			time = time.replaceFirst(String.format("%d", hour), String.format("%d", newHour)) + " pm";
		} else {
			newHour = Math.abs(hour);
			time = time.replaceFirst(String.format("%d", hour), String.format("%d", newHour)) + " am";
		}
		
		return time;
		
	}
	
	public static String convertTime2(String time) {
		int hour = Integer.parseInt((time.split(":")[0]));
		String min = (time.split(":")[1]).substring(0,2);
		if(time.contains("pm")){
			hour=hour<12?hour+12:hour;
			return ""+hour+":"+min;
		}	
		if(time.contains("am")){
			hour=hour>=12?hour-12:hour+12;
			return ""+hour+":"+min;
		}
		return hour<12?""+hour+":"+min+" am":""+(hour-12)+":"+min+" pm";
	}
	
}
