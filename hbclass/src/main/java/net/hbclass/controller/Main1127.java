package net.hbclass.controller;

import java.util.Scanner;

import net.hbclass.model.Gugudan;
import net.hbclass.model.NowTime;

public class Main1127 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("단 입력? ");
		Gugudan ggd = new Gugudan();
		ggd.getGugudan(sc.nextInt());
		
		
		NowTime nt = new NowTime();
		System.out.println("\n\n 현재시간 ? "+nt.getCurTime());
		
		System.out.println("국어점수 ? ");
		int kor=0,eng=0;
		kor=sc.nextInt();
		System.out.println("영어점수 ? ");
		eng=sc.nextInt();
		
		System.out.println("국어="+kor);
		System.out.println("영어="+eng);
		System.out.println("합계="+(kor+eng));
	}
}
