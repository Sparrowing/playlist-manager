package sparrowing.playlistmanager.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Functions {
	
	/**
	 * Returns whether or not a String matches a supplied regular expression pattern
	 * 
	 * @param regex Regex string to check against
	 * @param match String to check against the regular expression
	 * @return True if String matches the pattern, else false
	 */
	public static boolean isRegexMatch(String regex, String match) {
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(match);
		return matcher.matches();
	}
	
	/**
	 * Small utility function to determine if a String is completely empty (or null)
	 * 
	 * @param s String to be checked
	 * @return True if String is empty, else false
	 */
	public static boolean isStringEmpty(String s) {
		return s == null || s == "";
	}

}
