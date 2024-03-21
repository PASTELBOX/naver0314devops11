package day0321;

import java.util.Scanner;

public class Ex4_ArrayAlphaCount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 영어문장을 입력하면 알파벳 기준으로 각각의 갯수를 출력하시오
		 * Have a Nice Day!!
		 * 
		 * 'A' -> 0번지 증가
		 * 'B' -> 1번지 증가
		 * 	alpha['A'-'A']++ :0번지 증가
		 * 	alpha['B'-'A']++ :1번지 증가
		 * 	alpha['C'-'A']++ :2번지 증가
		 * A:3	B:0.......Z:0
		 */
		Scanner sc=new Scanner(System.in);
		String msg,str1;
		int []alpha=new int[26];
		
		System.out.println("영어 문장을 입력");
		msg=sc.nextLine();
//		str1=msg.toUpperCase();
//		String []str1=new String[str1.length]
//		
//		for(int a=0;a<alpha.length;a++)
//		{
//			for(int b='A';b<='Z';b++)
//			{
//				alpha[a]=b;
//			}
//		}
//		
//		for(int i=0;i<str.length();i++)
//		{
//			for(int a='A';a<='Z';a++)
//				if(alpha[a-str[i]]==0)
//					
//		}
		
		for(int i=0;i<msg.length();i++)
		{
			char ch=msg.toUpperCase().charAt(i);//대문자로 변경 후 i번지 글자 얻기
			if(ch>='A' && ch<='Z')
			alpha[ch-'A']++;
		}
		
		System.out.println("** 알파벳별 갯수 구하기 **");
		for(int i=0;i<alpha.length;i++)
		{
			System.out.printf("%c:%d\t",(char)('A'+i),alpha[i]);
			if((i+1)%5==0)
			{
				System.out.println();
			}
		}
		
		
		
	}

}
