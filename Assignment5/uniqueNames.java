import java.util.ArrayList;
import java.util.Scanner;

import acm.program.*;

public class uniqueNames extends ConsoleProgram{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void run() {
	
		ArrayList<String> list = new ArrayList<String>();
		ArrayList<String> uniqList = new ArrayList<String>();
		
		readNames(list);
		uniqNames(list, uniqList);
		
		
		
		
	}
	
	public void readNames(ArrayList<String> list) {
		String name = "";
		
		while(true) {
			name = readLine("Enter name: ");
			
			if(name.equals("")) {
				break;
			}else {
				list.add(name);
			}
		}
	}
	
	public void uniqNames(ArrayList<String> list, ArrayList<String> uniqList) {
		
		
		for(int i = 0; i < list.size();i++) {
			if(!uniqList.contains(list.get(i))) {
				uniqList.add(list.get(i));
			}
		}
	

		println("Unique name list contains:		");
		for(int i = 0; i < uniqList.size();i++) {
			println(uniqList.get(i));
		}
			
	}
}
