package net.hbclass.model;

public class Multi5 {
	
	public void getDanhang(){
		System.out.println("1부터 20까지 구하기");
		int su=0;
		while(true){
			su++;
			System.out.print(su+ "\t");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(su%5==0){
				System.out.println();
			}
			if(su==20){
				break;
			}
		}
	}
}
