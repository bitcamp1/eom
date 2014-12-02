package net.hbclass.stone;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Vector;


public class ToyMachine {
	private Vector<Toy> toys;
	private Toy toy;
	public ToyMachine(){
		this(10,5);
	}
	public ToyMachine(int capa, int increment) {
		toys = new Vector<Toy>(capa,increment);
	}
	public Vector<Toy> getToyByName(String name) {
		Vector<Toy> catchToys = new Vector<Toy>();
		for(int i=0;i<toys.size();i++){
			while(toy instanceof Toy){
				if(toy.getName().equalsIgnoreCase(name)){
					catchToys.add(toy);
				}
				System.out.println(toy.getName()+"인형");
			}
		}
		return catchToys;
	}
	public List<Toy> getToyBySpec(ToySpec spec){
		List<Toy> catchToys = new ArrayList<Toy>();
		Enumeration<Toy> enm = toys.elements();
		while(enm.hasMoreElements()){
			Toy toy = (Toy)enm.nextElement();
			ToySpec ts = toy.getSpec();
			if(ts.equals(spec)){
				catchToys.add(toy);
			}
		}
		return catchToys;
	}
	public List<Toy> getAllToy(){
		return toys;
	}
	public void setToy(String name, int price, ToySpec spec) {
		Toy toy = new Toy(name, price, spec);
		toys.addElement(toy);
	}
	
	
	
}
