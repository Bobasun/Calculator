package com.eclipsercp.swtjface.view;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
	
	public static boolean validate(String value) {
		
		Pattern validationPattern = Pattern.compile("(\\d+\\.?)+");
		Matcher matcher = validationPattern.matcher(value);
		return matcher.matches();
	}
	
}
