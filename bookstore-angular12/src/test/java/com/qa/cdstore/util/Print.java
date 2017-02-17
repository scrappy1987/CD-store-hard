package com.qa.cdstore.util;

public class Print
{
	public static String fixedString(String input, int length)
	{
		String output = input;
		for(int i = 0; i < (length - input.length()); i++)
			output += " ";
		return output;
	}
	
	public static String header(String title, int width)
	{	
		width = ((width - title.length())/2);
		String output = "";
		
		for(int i= 0; i <= width; i++)
			output += "=";
		
		output += title;
		
		for(int i= 0; i <= width; i++)
			output += "=";
		return output;
	}
}
