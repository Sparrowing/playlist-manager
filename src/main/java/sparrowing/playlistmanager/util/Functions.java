package sparrowing.playlistmanager.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Functions {
	
	/*
	 * Returns whether or not String match matches the supplied regex pattern
	 */
	public static boolean isRegexMatch(String regex, String match) {
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(match);
		return matcher.matches();
	}

}
