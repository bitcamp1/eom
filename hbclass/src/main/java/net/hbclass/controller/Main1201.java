package net.hbclass.controller;

import net.hbclass.model.BigNum;
import net.hbclass.model.Gugudan;
import net.hbclass.model.Multi5;
import net.hbclass.model.SimpleCalc;

public class Main1201 {
	public static void main(String[] args) {
		Main1201 m = new Main1201();
		//m.getSimpleCalc();
		//m.altShiftM();
		
		//System.out.println("데이터등록처리 50라인");
		//System.out.println("데이터조회처리 23라인");
		//System.out.println("데이터삭제처리 35라인");
		
		//m.getBigNum();
		
		m.getFullGugudan();
		
		
		
	}
	public void getFullGugudan() {
		Gugudan ggd = new Gugudan();
		ggd.getFullGugudan();
	}
	public void getBigNum() {
		BigNum bn = new BigNum();
		int a = 23;
		int b = 79;
		int c = 14;
		bn.getBig(a, b, c);
	}
	public void dbInsert(){}
	public void dbSearch(){}
	public void dbDelete(){}
	

	public void getSimpleCalc() {
		SimpleCalc sc = new SimpleCalc();
		int eng = 85;
		int kor = 90;
		sc.setPlus(eng, kor);
		
		System.out.println(sc.getPlus());
	}

	public void altShiftM() {
		Multi5 dh = new Multi5();
		dh.getDanhang();
	}
}
