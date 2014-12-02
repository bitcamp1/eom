package net.hbclass.stone;

public class Toy {
	String name;
	int price;
	ToySpec spec;
	public Toy(String name, int price, ToySpec spec) {
		super();
		this.name = name;
		this.price = price;
		this.spec = spec;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public ToySpec getSpec() {
		return spec;
	}
	public void setSpec(ToySpec spec) {
		this.spec = spec;
	}
	
	public boolean equals(String name) {
		String curName = name;
		String targetName = this.getName();
		return curName.equalsIgnoreCase(targetName);
	}
	@Override
	public String toString() {
		return "인형 [이름=" + getName() + "\n 가격=" + getPrice() + ""
				+ "\n 사양=" + getSpec()
				+ "]";
	}
	
	
	
	
}
