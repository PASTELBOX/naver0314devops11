package day0315;

import java.util.Scanner;

public class Ex13_Munje {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*조건 연산자 문제
		 * 점수(score)를 입력받아
		 * 점수가 90 이상이면 "참 잘했어요!!"
		 * 점수가 80 이상이면 "수고했어요!"
		 * 점수가 70 이상이면 "조금 더 노력하세요!"
		 * 그 나머지는 "재시험입니다!"
		 * 메세지를 저장할 문자열 변수명은 msg
		 */
		
		Scanner sc=new Scanner(System.in);
		int score;
//		String msg;
//		
//		System.out.println("점수는?");
//		score=sc.nextInt();
//		
//		msg=score>90 ? "참 잘했어요!!" :
//			score>80 ? "수고했어요!" :
//			score>70 ? "조금 더 노력하세요!" :
//			"재시험입니다!";
//		System.out.println("msg = "+msg);
		
//		String msg1,msg2,msg3,msg4,msg;
//		msg1="참 잘했어요!!";
//		msg2="수고했어요!";
//		msg3="조금 더 노려하세요!";
//		msg4="재시험입니다!";
//		
//		System.out.println("점수는?");
//		score=sc.nextInt();
//		
//		msg=score>90 ? msg1 :
//			score>80 ? msg2 :
//			score>70 ? msg3 :
//			msg4;
		
		String msg;
		
		System.out.println("점수는?");
		score=sc.nextInt();
		
		msg=score>90 ? args[0] :
			score>80 ? args[1] :
			score>70 ? args[2] :
			args[3];
			
		System.out.println("msg = "+msg);

	}

}
