package day0315;

import java.util.Scanner;

public class Ex12_Operator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 조건(삼항) 연산자
		 * 조건식 ? 참 : 거짓
		 * 두개의 숫자를 입력 후 더 큰 숫자를 출력하시ㅗ
		 */
		Scanner sc=new Scanner(System.in);
//		int su1,su2,max;
//		System.out.println("두개의 숫자 입력");
//		su1=sc.nextInt();
//		su2=sc.nextInt();
//		
//		max=su1>su2?su1:su2;
//		System.out.println("max="+max);
		
		/*
		 * 조건(삼항) 연산자
		 * 조건식 ? 참 : 거짓
		 * 세개의 숫자를 입력 후 더 큰 숫자를 출력하시ㅗ
		 */
		
		int su1,su2,su3,max;
		System.out.println("세개의 숫자 입력");
		su1=sc.nextInt();
		su2=sc.nextInt();
		su3=sc.nextInt();
		
		//max=su1>su2&&su1>su3?su1:
		//	su2>su1&&su2>su3?su2:
		//		su3;
		
		max=su1>su2&&su1>su3?su1:
			su2>su3?su2:su3;
		
		System.out.println("max="+max);

	}

}
