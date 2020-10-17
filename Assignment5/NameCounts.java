import acm.program.*;
import java.util.*;


public class NameCounts extends ConsoleProgram{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public void run() {
	HashMap<String, Integer> nameMap = new HashMap<String, Integer>();
	
	addNames(nameMap);
	
	printNames(nameMap);
	
	}
	
	
	public void addNames(HashMap<String, Integer> map) {
		String name = "";
		while(true) {
			name = readLine("Enter a name: ");
			if(name.equals("")) {
				break;
			}
			
			Integer count = map.get(name);
			if(count == null) {
				count = new Integer(1);
			}else {
				count = new Integer(count + 1);
			}
			
			map.put(name, count);
			
			
		}
	}
	
	public void printNames(HashMap<String, Integer> map) {
		Iterator<String> iter = map.keySet().iterator();
		
		while(iter.hasNext()) {
			String name = iter.next();
			int count = map.get(name);
			println("Entry [" + name + "] has count " + count);
			
		}
	}
	
}
