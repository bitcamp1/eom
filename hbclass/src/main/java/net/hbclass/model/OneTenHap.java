package net.hbclass.model;

public class OneTenHap {
	int su,	 hap;
	

	public int getSu() {
		return su;
	}

	public void setSu(int su) {
		this.su = su;
	}

	public int getHap() {
		while (true) {
			su++;
			hap += su;
			if(su == 10){
				break;
			}
		}
		return hap;
	}

	public void setHap(int hap) {
		this.hap = hap;
	}
	
}
