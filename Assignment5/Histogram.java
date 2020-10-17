import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import acm.program.*;


public class Histogram extends ConsoleProgram{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private String name = "Histogram.txt";
	private String line;
	private String placeHold;
	private int replace;
	
	public void run() {
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		
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
				line = rd.readLine();
				placeHold = "";
				if(line == null	) {
					break;
				}else {
					for(int i = 0; i < line.length(); i++) {
						if(line.charAt(i) != ' ') {
							placeHold += line.charAt(i);
						}
					}
					replace = Integer.parseInt(placeHold);
					list.add(replace);

				}
				
			}
		}catch(IOException e){
			println("error");

		}finally{
			try {
				rd.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}

		
		print("00-09: " );
		printHist(0,9, list);
		
		print("10-19: ");
		printHist(10,19, list);
		
		print("20-29: ");
		printHist(20,29, list);
		
		print("30-39: ");
		printHist(30,39, list);
		
		print("40-49: ");
		printHist(40,49, list);
		
		print("50-59: ");
		printHist(50,59, list);
		
		print("60-69: ");
		printHist(60,69, list);
		
		print("70-79: ");
		printHist(70,79, list);
		
		print("80-89: ");
		printHist(80,89, list);
		
		print("90-99: ");
		printHist(90,99, list);
		
		print("  100: ");
		printHist(100,100, list);
		
	}

	public void printHist(int x, int y, ArrayList<Integer> list) {
		for(int i = 0; i < list.size(); i++) {
				if(list.get(i) >= x && list.get(i) <= y) {
					
					print("*");
					list.remove(i);
				
			}

		}
		println("");
	}
}


