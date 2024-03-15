package day0315;

import java.util.Scanner;

public class Ex8_Munje {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 이름(name),핸드폰(hp),태어난 년도(birthYear) 입력받은 후
		 * 이름,핸드폰,태어난년도,나이(age, 2024-태어난년도)를 출력하는 프로그램을 작성하시오
		 * 선언-입력-계산-출력
		 */
		Scanner sc=new Scanner(System.in);
		String name, hp;
		int birthYear,age;
		
		System.out.println("당신의 이름은?");
		name=sc.nextLine();
		System.out.println("당신의 핸드폰은?");
		hp=sc.nextLine();
		System.out.println("당신이 태어난 년도는?");
		birthYear=sc.nextInt();
		
		//System.out.println("당신의 나이는?");
		//age=sc.nextInt();
		
		//나이 계산
		age=2024-birthYear;
		
		System.out.println("이름:"+name);
		System.out.println("핸드폰:"+hp);
		System.out.printf("태어난년도:%d년\n",birthYear);
		//System.out.printf("나이:%d세",(2024-birthYear));
		System.out.printf("나이:%d세",age);
		//System.out.println("태어난 년도:"+birthYear);
		//System.out.println("나이:"+age);
	}

}
