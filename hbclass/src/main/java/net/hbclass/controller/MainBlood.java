package net.hbclass.controller;

import java.util.Scanner;

import net.hbclass.stone.KaupIndex;

public class MainBlood {
	public static void main(String[] args) {
		MainBlood m = new MainBlood();
		m.getKaupIndex();
	}

	public void getKaupIndex() {
		Scanner s = new Scanner(System.in);
        System.out.println("키를 입력해주세요");
        double height = s.nextDouble();
        System.out.println("몸무게를 입력해주세요");
        double weight = s.nextDouble();
		KaupIndex k = new KaupIndex(height, weight);
		
		System.out.println(k.toString());
        System.out.print("완료");
	}
}
