package net.hbclass.stone;


public class KaupIndex {
	double height;
	double weight;
	int index;
	public KaupIndex(double height, double weight) {
		super();
		this.height = height;
		this.weight = weight;
		this.index = (int)((weight/(height*height))*10000);
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public String getMsg(){
		String msg="";
		if(index>30){
            msg = "비만";
        }else if(index>24){
            msg="과체중";
        }else if(index>20){
            msg="정상";
        }else if(index>15){
            msg="저체중";
        }else if(index>13){
            msg="마름";
        }else if(index>10){
            msg="영양실조";
        }else{
            msg="소모증";
        }
		return msg;
	}
	@Override
	public String toString() {
		return "카우프지수 [키=" + height + "cm, 몸무게=" + weight + "kg" 
	+ "건강지수" +getMsg()+ "]";
	}
	
	
	
	
	
	
}
