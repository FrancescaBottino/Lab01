package it.polito.tdp.parole.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Parole {
	
	List<String> parole;
		
	public Parole() {
		//TODO
		
		parole=new ArrayList<String>();
		
	}
	
	public void addParola(String p) {
		//TODO
		parole.add(p);
			
	}
	
	public List<String> getElenco() {
		//TODO
		
		Collections.sort(parole);
		
		return parole;
	}
	
	public void reset() {
		// TODO
		
		parole.clear();
		
	}
	
	public void removeParola(String s) {
		
		parole.remove(s);
	}
	
	public String toString() {
		
		String risultato ="";
		for(String p: parole) {
			risultato=risultato+p+"\n";
		
		}
		
		return risultato;
	}

}
