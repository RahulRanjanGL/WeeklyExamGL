/*Q.1.)i. Develop a java class with a instance variable M1 (HashMap) create a method saveCountryCapital(String CountryName, String capital) , the method should add the passed country and capital as key/value in the map M1 and return the Map (M1).

Key- Country Value - Capital

India Delhi

Japan Tokyo

ii. Develop a method getCapital(String CountryName) which returns the capital for the country passed, from the Map M1 created in step 1.

iii. Develop a method getCountry(String capitalName) which returns the country for the capital name, passed from the Map M1 created in step 1.

iv. Develop a method which iterates through the map M1 and creates another map M2 with Capital as the key and value as Country and returns the Map M2.

Key – Capital Value – Country

Delhi India

Tokyo Japan

v. Develop a method which iterates through the map M1 and creates an ArrayList with all the Country names stored as keys. This method should return the ArrayList.

NOTE: You can test the methods using a main method.*/

package com;

import java.util.*;
class Country{
	
	//i.)
	public static Map<String, String> M1 = new HashMap<>();
	
	public Map<String, String> saveCountryCapital(String countryName, String capital) {
		M1.put(countryName, capital);
		return M1;
	}
	
	//ii.)
	public String getCapital(String countryName) {
		
		Iterator<Map.Entry<String, String>> itr = M1.entrySet().iterator();
		
		while(itr.hasNext()) {
			Map.Entry<String, String> entry = itr.next();
			if(entry.getKey().equals(countryName))
				return entry.getValue();
		}
		return null;
	}
	
	//iii.) 
	public String getCountry(String capitalName) {
		
		Iterator<Map.Entry<String, String>> itr = M1.entrySet().iterator();
		
		while(itr.hasNext()) {
			Map.Entry<String, String> entry = itr.next();
			if(entry.getValue().equals(capitalName))
				return entry.getKey();
		}
		return null;
	}
	
	//iv.)
	public Map<String,String> getAnotherMap(Map<String,String> m){
		
		Map<String, String> M2 = new HashMap<>();
		Iterator<Map.Entry<String, String>> itr = M1.entrySet().iterator();
		
		while(itr.hasNext()) {
			Map.Entry<String, String> entry = itr.next();
			M2.put(entry.getValue(), entry.getKey());
		}
		return M2;
	}
	
	//v.)
	public ArrayList<String> getArrayList(Map<String, String> m){
		
		ArrayList<String> list = new ArrayList<>();
		Iterator<Map.Entry<String, String>> itr = M1.entrySet().iterator();
		

		while(itr.hasNext()) {
			Map.Entry<String, String> entry = itr.next();
			list.add(entry.getKey());
		}
		return list;
	}
}

public class TestCountryCapital {

	public static void main(String[] args) {
		
		Country c = new Country();
		
		c.saveCountryCapital("India", "Delhi");
		c.saveCountryCapital("Japan", "Tokyo");
		c.saveCountryCapital("Australia", "Canberra");
		
		System.out.println("Itterating through Map M1--->");
		Iterator<Map.Entry<String, String>> itr1 = Country.M1.entrySet().iterator();

		while(itr1.hasNext()) {
			Map.Entry<String, String> entry = itr1.next();
			System.out.println(entry);
		}
		System.out.println();
		
		System.out.println("Get Capital Names : ");
		System.out.println("India Capital = "+c.getCapital("India"));
		System.out.println("SriLanka Capital = "+c.getCapital("SriLanka"));
		System.out.println();
		
		System.out.println("Get Country Names : ");
		System.out.println("Kochi is capital of "+c.getCountry("Kochi"));
		System.out.println("Delhi is capital of "+c.getCountry("Delhi"));
		System.out.println();
		
		System.out.println("After Storing in another Map and exchanging key and value --->");
		Iterator<Map.Entry<String, String>> itr = c.getAnotherMap(Country.M1).entrySet().iterator();
		
		while(itr.hasNext()) {
			Map.Entry<String, String> entry = itr.next();
			System.out.println(entry);
		}
		System.out.println();
		
		System.out.println("Storing Country Names from the map to ArrayList ---->");
		Iterator<String> it = c.getArrayList(Country.M1).iterator();
		
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
	}
}
