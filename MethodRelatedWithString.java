import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
public class MethodRelatedWithString {
	public static void main(String[] args) {
		// String Method 
		// 			 0123456789012345678
		String s1 = "Hello Jeongin 123 A";
		char ch1 = 'B';
		// 						0123456789012
		String s2 = new String("Hello Mark 41");
		System.out.println(s1);
		System.out.println(s2);
		// the length of s1
		int len1 = s1.length(); 
		System.out.println(len1);
		int len2 = s2.length();
		System.out.println(len2);
		
		// charAt() , codepointAt()
		char c1 = s1.charAt(7); 
		System.out.println(c1); // e 
		System.out.println(s1.codePointAt(15)); // '2'
		System.out.println(s1.codePointAt(18)); // 'A'
		// compareTo
		String s3 = "Jannie";		//	when cast String instance without "new", get the same reference
		String s4 = "Jannie";
		System.out.println((s3 == s4)); // true, compare both references
		System.out.println((s3.equals(s4))); // true, compare both values
		
		String s5 = new String("Jannie");	//	create instance with "new", get the different reference
		String s6 = new String("Jannie");
		System.out.println((s5 == s6)); // false, compare both references
		System.out.println((s5.equals(s6))); // true, compare both values
		
		// change to Upper Case or Lower Case 
		String s7 = "john. f. kennedy";
		String s8 = "John. F. Kennedy";
		System.out.println(s7.toUpperCase());
		System.out.println(s7.toLowerCase());
		System.out.println(s8.toUpperCase());
		System.out.println(s8.toLowerCase());

		System.out.println(s7.equals(s8)); // false
		System.out.println(s7.equalsIgnoreCase(s8)); // true

		// find index number of the element(character or String) 
		// 			 01234567890123
		String s9 = "Hello World!!!";
		int pos = s9.indexOf('o');
		System.out.println(pos); // 4
			
		int pos2 = s9.indexOf('o', pos + 1);	//	count after "Hello"
		System.out.println(pos2); // 7

		int pos3 = s9.indexOf("o", pos2 + 1);	//	count after pos2
		System.out.println(pos3); // -1 : not found

		int pos4 = s9.lastIndexOf('o');		//	the last index of 'o'
		System.out.println(pos4); // 7

		// compareTo
		// s10 > s11 : > 0 positive
		// s10 == s11 : == 0 0, same each other 
		// s10 < s11 : > 0 negative 
		String s10 = "alpha"; 
		String s11 = "beta"; 

		int p1 = s10.compareTo(s11);
		System.out.println(p1); // -1

		int p2 = s7.compareToIgnoreCase(s8);
		System.out.println(p2); // 0 
		// contain the elements
		System.out.println(s9.contains("World")); // true
		System.out.println(s9.contains("world")); // false
		System.out.println(s9.toLowerCase().contains("world")); // true
		// String splits
		String nameStr = "A,B,C,D,F,G,H";
		String[] names = nameStr.split(",");
		for (int i = 0; i < names.length; i++) {
			System.out.println(names[i]);
		}
		String str1 = "abcdef";
		String[] strSplit = str1.split(""); // split by one word and put into strSplit
		System.out.println(Arrays.toString(strSplit));
		// "" + "" : concatenate operator
		String firstName = "Jane";
		String lastName = "Doe";
		String fullName = firstName + " " + lastName;

		// method chaining
		System.out.println(fullName);
		fullName = firstName.concat(" ").concat(lastName);
		System.out.println(fullName);
		// replace 
		String msg = "Hello Java Programming";
		System.out.println(msg);
		String msg2 = msg.replace("Java", "Everybody"); // replace "Java" -> "Everybody"
		System.out.println(msg);
		System.out.println(msg2);
		// substring
		// 				   01234567 
		String hiredate = "20080501";
		
		// linked to the last line(getWeekOfDay(int hYear, int hMonth, int hDate) constructor)
		int hYear = Integer.parseInt(hiredate.substring(0, 3 + 1));
		int hMonth = Integer.parseInt(hiredate.substring(4, 5 + 1));
		int hDate = Integer.parseInt(hiredate.substring(6, 7 + 1));
		String weekDay = getWeekOfDay(hYear, hMonth, hDate);
		System.out.printf("%4dYear %02dMonth %02dDate %sDay\n", hYear, hMonth, hDate, weekDay);
		
		// concatenate operator : StringBuilder is way faster 
		StringBuilder sb = new StringBuilder(); // StringBuilder : add the next String right after the before one 
		sb.append("Hey Hello"); // sb = sb + "Hey Hello"
		sb.append(" "); // sb = sb + " "
		sb.append("World"); // sb = sb + "World"
		System.out.println(sb);
		System.out.println(sb.length());
		System.out.println(sb.toString()); // "Hey Hello World"
		
		// create the function removing the blank between String name01
		
		String name01 = "Jeong In Yun";
		System.out.println(name01);	//	Jeong In Yun
		
		// the first way
		String name02 = "Jeong In Yun";
		System.out.println(name02.replace(" ", ""));	//	JeongInYun
		
		// the second way
		char[] result = delBlank(name01);
		// System.out.println( result );
		String nameNew = new String(result);
		System.out.println(nameNew);	//	JeongInYun
	}

	private static char[] delBlank(String name) {
		// i 0 1 2 3 4
		// char [] orgStr = { 'Jeong', ' ' , 'In', ' ', 'Yun' };
		// char [] newStr = { 'Jeong', In', 'Yun' };
		// pos 0 1 2
		int n = name.length();
		char[] orgStr = new char[n];
		char[] newStr = new char[n];
		for (int i = 0; i < n; i++) {
			orgStr[i] = name.charAt(i);
		}
		int pos = 0;
		for (int i = 0; i < n; i++) {
			if (orgStr[i] != ' ') {
				newStr[pos] = orgStr[i];
				pos = pos + 1;
			}
		}
		return newStr;
	}

	private static String getWeekOfDay(int hYear, int hMonth, int hDate) {
		// 					0 	  1		 2 		3	   4	  5	 	 6
		String[] day = { "Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat" };
		Date theDate = new Date(hYear - 1900, 5 - 1, 1);
		Calendar cal = Calendar.getInstance();
		cal.setTime(theDate);
		int wkday = cal.get(Calendar.DAY_OF_WEEK); // 1 ~
		System.out.println(theDate.toLocaleString());
		String weekDay = day[wkday - 1];
		return weekDay;
	}
}