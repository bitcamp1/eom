package net.hbclass.model;

public class BigNum {
	int big;
	
	public void getBig(int a, int b,int c) {
		
		if(a>b && a>c){
			System.out.println("가장 큰 수는"+a+"입니다.");
		}else if(b>a && b>c){
			System.out.println("가장 큰 수는"+b+"입니다.");
		}else{
			System.out.println("가장 큰 수는"+c+"입니다.");
		}
		
		
	}
	
	
	
	
	
}
