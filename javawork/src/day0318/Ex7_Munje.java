package day0318;

import java.util.Scanner;

public class Ex7_Munje {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 이름(name),기본급(gibon),가족수(familysu)를 키보드로 입력 후
		 * 가족 수가 3인 이상이면 기본급 + (가족수*50000)으로 실수령액(totpay)을 구하고
		 * 가족 수가 3인 미만이면 기본급 +30000원으로 실수령액을 출력하시오
		 * 출력은
		 * 이름
		 * 기본급
		 * 가족수
		 * 실수령액
		 */
		
		Scanner sc=new Scanner(System.in);
		String name;
		int gibon,familysu,totpay = 0;
		
		System.out.println("이름을 입력하시오");
		name=sc.nextLine();
		System.out.println("기본급을 입력하시오");
		gibon=sc.nextInt();
		System.out.println("가족수를 입력하시오");
		familysu=sc.nextInt();
		
		
		if(familysu<=0)
		{
			System.out.println("잘못된 수입니다!");
			return;
		}
		else if(familysu>=3)
		{
			totpay=gibon+(familysu*50000);
		}
		else if(familysu<3)
		{
			totpay=gibon+30000;
		}
		
		System.out.println(name+"은(는) 기본급으로 "+gibon+"을 받고 가족 수는 "+familysu+"명 이므로 실수령액은 "+totpay+"이다");
		
	}

}
