package day0315;

public class Ex1_DataType {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 자바에서의 데이터 타입에 대하여 알아보자
		/*
		 *  2024.03.15 수업 둘째날
		 *  자바에서의 주석처리 하는 방법
		 */
		//기본 자료형 공부
		//구역({})안에서 선언하는 변수들은 자동초기화가 되지 않으므로
		//초기값을 지정하거나 나중에 변수에 값을 전달해야 출력이 가능하다
		boolean flag=true;
		boolean flag2;
		flag2=false;
		
		System.out.println(flag);
		System.out.println(flag2);
		System.out.println(!flag);//!(not) : 반대로 출력, true
		System.out.println(!flag2);
		
		// && : 둘다 true 일때만 true
		// || : 둘중 하나만 true라도 결과는 true
		System.out.println(flag && flag2);//false
		System.out.println(flag || flag2);//true
	}

}
