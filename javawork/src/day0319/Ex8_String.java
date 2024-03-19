package day0319;

public class Ex8_String {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("** String 객체의 Method 공부하기 **");
		String str1="Have a Nice Day";
		String str2="apple";
		String str3="Apple";
		
		System.out.println(str1.charAt(7));//7번 인덱스의 문자 : N
		System.out.println(str1.charAt(0));//0번 인덱스의 문자 : H
		System.out.println(str1.indexOf('a'));//첫번째 'a'의 위치 : 1
		System.out.println(str1.indexOf('X'));//첫번째 'X'의 위치 : -1(없을 경우 -1)
		System.out.println(str1.lastIndexOf('a'));//마지막 'a'의 위치 : 13
		System.out.println(str1.length());//str1의 총 길이 : 15
		System.out.println(str2.concat("***"));//str2 문자에 *** 추가해서 반환
		System.out.println(str2+"***");//위와 같다
		System.out.println(str1.toLowerCase());//모두 소문자로 변환해서 변환
		System.out.println(str1.toUpperCase());//모두 대문자로 변환해서 변환
		
		//문자열 비교시(값으로 비교시 equal 사용)
		System.out.println("apple".equals(str2));//true
		System.out.println("apple".equals(str3));//false
		System.out.println(str2.equals(str3));//false : 대소문자가 다르므로 false
		System.out.println(str2.equalsIgnoreCase(str3));//대소문자 상관없이 비교 : true
		System.out.println(str2==str3);//객체시에는 주소를 비교 : 주소가 다르므로 false(==동등연산자는 기본값 비교시에만 사용)
		
		//문자열 추출
		System.out.println(str1.substring(7));//7번 인덱스부터 끝까지 추출 : Nice Day
		System.out.println(str1.substring(7,10));//7번 인덱스부터 9번 인덱스까지 추출 : Nic
		
		//문자열 비교
		System.out.println(str1.startsWith("Have"));//str1이 Have로 시작하면 true : true
		System.out.println(str1.startsWith("Nice"));//str1이 Nice로 시작하면 true : false
		
		System.out.println(str1.endsWith("Day"));//str1이 Day로 끝날 경우 true : true
		System.out.println(str1.endsWith("day"));//str1이 day로 끝날 경우 true : false
		System.out.println(str1.toLowerCase().endsWith("day"));//str1이 소문자로 변환 후 day로 끝나는지 비교 : true
		
		//반복
		System.out.println(str2.repeat(3));
		System.out.println("*".repeat(10));
		
		//일부변경
		System.out.println(str1.replace('a', '*'));//H*ve * Nice D*y
		System.out.println(str1.replace("Nice", "Good"));//Have a Good Day
		
		
		
		

	}

}
