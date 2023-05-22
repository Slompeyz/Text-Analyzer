package cen3024;

import java.net.*;
import java.io.*;

public class TextAnalyzer {
	public static void main(String[] args) throws Exception{
		
		
		URL url = new URL("https://www.gutenberg.org/files/1065/1065-h/1065-h.htm");
		BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
		
		String text = reader.readLine();
		boolean poemText = false;
		
		//while the end of the text has not been reached, prints lines that are part of the poem
		//and removes html tags
		while(text != null) {
			text = text.replaceAll("<.*?>", "");
			
			//sets poemText to true or false when the beginning and end of the poem are reached
			if(text.equals("The Raven")) {
				poemText = true;
			}
			if(text.equals("*** END OF THE PROJECT GUTENBERG EBOOK THE RAVEN ***")) {
				poemText = false;
			}
			
			//prints the current line if it is part of the poem
			if(poemText) {
				System.out.println(text);
			}
			
			//iterator moves to the next line of the text
			text = reader.readLine();
		}
		
		reader.close();
	}
}
