import acm.program.*;
import java.io.*;

public class WordCount extends ConsoleProgram{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void run() {
			int wordCount = 0;
			int lineCount = 0;
			int charCount = 0;
			char space = ' ';
			String name = "lear.txt";
		
			BufferedReader rd = null;
			
			while(rd == null) {
				try {
					rd = new BufferedReader(new FileReader(name));
				} catch(IOException e) {
					println("File does not exist");
				}
			}
			
			
			try {
				
				while(true) {
				
					String line = rd.readLine();
					if(line == null) {
						break;
					}
					lineCount++;
					for(int i = 0; i < line.length(); i++) {
						space = line.charAt(i);
						if(!Character.isLetterOrDigit(space)) {
							wordCount++;
						}
						if(space != '\n') {
							charCount++;
						}
					}
					
					
				} 
				rd.close();
					
			}catch(IOException e) {
				e.printStackTrace();	
			}
			
			println("File: " + name);
			println("Lines = " + lineCount);
			println("Words = " + wordCount);
			println("Chars = " + charCount);
		
	}

}
