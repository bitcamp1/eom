package net.hbclass.model;

public class StarPrinter {
	int i,j,k;

	
	public void m1(){
		System.out.println("정사각형");
		for(i=0;i<5;i++){
			for(j=0;j<5;j++){
				System.out.print("★");
			}
			System.out.println();
		}
	}
	
	public void m2(){
		System.out.println("오른쪽 직각삼각형");
		for (i=0;i<5;i++) {
			for (j=0; j<i; j++) {
				
				System.out.print("★");
			}
			System.out.println();
		}
	}
	public void m3(){
		System.out.println("역 오른쪽 직각삼각형");
		for(i=5;i>0;i--){
			for(j=0;j<i;j++){
				System.out.print("★");
			}
			System.out.println();
		}
	}
	public void m4(){
		System.out.println("정삼각형");
		for(i=1;i<6;i++){
			for(j=1;j<6-i;j++){
				System.out.print(" ");
			}
			for(j=1;j<=2*i-1;j++){
				System.out.print("★");
			}
			System.out.println();
		}
	}
	
}
