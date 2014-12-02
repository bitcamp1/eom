package net.hbclass.model;

public class Juso {
	
	public void arrayTest(){
		String[] juso = {"시청","서울","잠실"};
		int[] su = new int[3];
		su[0] = 23;
		su[1] = 35;
		su[2] = 17;
		
		for(int i=0;i<juso.length;i++){
			System.out.print(juso[i]+" ");
		}
		System.out.println();
		for(int i=0;i<su.length;i++){
			System.out.println("su["+i+"] = "+su[i]+"");
		}
	}
}
