import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

import acm.program.*;

public class FlightPlanner extends ConsoleProgram{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//Instance Variables
	Map<String, List<String>> flightMap = new HashMap<String, List<String>>();
	List<String> airportList = new ArrayList<String>();
	List<String> destinationList = new ArrayList<String>();
	List<String> roundTrip = new ArrayList<String>();
	
	public void run() {
		
		readAirports();
		
	}
	
	
	public void buildRoute() {
		int count = 0;
		
		String route = "";
		String temp;
		while(true) {
			temp = readLine();
			if(flightMap.containsKey(temp)) {
				route = temp;
				roundTrip.add(route);
				if(roundTrip.get(0).equals(route)) {
					++count;
					if(count == 2) {
						break;
					}
						
				}
				
				while(true) {
					println("From " + route + " you can fly directly to: ");
					
						
						if(flightMap.containsKey(route)) {
							List<String> tempList = new ArrayList<String>();
							tempList = flightMap.get(route);
							tempList.forEach(l -> println(l));
							//done = true;
							
							break;
						
						
						}
				}
				
			}else {
				println("You can't get to that city by a direct flight.");
				println("From " + route + " you can fly directly to: ");
				if(flightMap.containsKey(route)) {
					List<String> tempList = new ArrayList<String>();
					tempList = flightMap.get(route);
					tempList.forEach(l -> println(l));
				}
			}
			
			
			
			
		}
		println("The route you've chosen is: ");
		String chosenRoute = "";
		for(int i = 0; i < roundTrip.size(); i++) {
			chosenRoute += roundTrip.get(i);
			if(!((i + 1) >= roundTrip.size())) {
				chosenRoute += " -> ";
			}
			
		}
		println(chosenRoute);
		
		
	}				
	


	
	public void printAirports(List<String> airports) {
		println("Welcome to Flight Planner!");
		println("Here's a list of all cities in our database: ");
		
		println("Let's plan a round-trip route!");
		println("Enter the starting city: ");
		
		buildRoute();
	}
	
	public void readAirports(){
		
		String fileName = "Airports.txt";
		String delimiter = " -> ";
	    String line;
	    
	   try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
		   while((line = br.readLine()) != null){
			   List<String> tempList = new ArrayList<String>();
			   String[] attributes = line.split(delimiter);
			   if(!line.equals("") || !line.equals("\n")) {
				   if(!airportList.contains(attributes[0])) {
					   airportList.add(attributes[0]);
				   }
				   destinationList.add(attributes[1]);
				   if(flightMap.containsKey(attributes[0])) {
					   tempList = flightMap.get(attributes[0]);
					   flightMap.remove(attributes[0]);
					   tempList.add(attributes[1]);
					   flightMap.put(attributes[0], tempList);
				   }
				   else
				   {
					   tempList.add(attributes[1]);
					   flightMap.put(attributes[0], tempList);
				   }
			   }
           		
           
           
           
		   }
		   printAirports(airportList);
	   } catch (Exception e){
	   		System.out.println(e);
	   }
		
		
	}
}
