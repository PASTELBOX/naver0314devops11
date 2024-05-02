package day0315;

import java.util.Scanner;

public class Ex10_Munje {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 백만단위의 금액(money) 를 입력받은 후
		 * 만원,천원,백원,십원,일원 단위로 몇개인지 출력하시오
		 * 예)
		 * 금액입력
		 * 4,567,893
		 * 만원 : 456장
		 * 천원 : 7장
		 * 백원 : 8개
		 * 십원 : 9개
		 * 일원 : 3개
		 */
		Scanner sc = new Scanner(System.in);
		/*
		 * int money,man,chun,baek,shib,ill;
		 * 
		 * 
		 * System.out.println("금액은?");
		 * money=sc.nextInt();
		 * 
		 * man=money/10000;
		 * money=money-(man*10000);
		 * chun=money/1000;
		 * money=money-(chun*1000);
		 * baek=money/100;
		 * money=money-(baek*100);
		 * shib=money/10;
		 * money=money-(shib*10);
		 * ill=money;
		 * 
		 * 
		 * System.out.println("만원:"+man+"장");
		 * System.out.println("천원:"+chun+"장");
		 * System.out.println("백원:"+baek+"개");
		 * System.out.println("십원:"+shib+"개");
		 * System.out.println("일원:"+ill+"개");
		 */
		int money;
		System.out.println("금액 입력");
		money = sc.nextInt();
		System.out.println("만원:" + (money / 10000) + "장");
		System.out.println("천원:" + (money % 10000 / 1000) + "장");
		System.out.println("백원:" + (money % 1000 / 100) + "개");
		System.out.println("십원:" + (money % 100 / 10) + "개");
		System.out.println("일원:" + (money % 10) + "개");

	}

}
