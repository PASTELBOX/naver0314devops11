package day0327;

import java.util.Stack;

public class Ex5_Stack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//List 인터페이스를 구현한 클래스중 하나
		//IFO 방식 : 먼저 들어간 게 나중에 나오는 방식
		Stack<String> stack1=new Stack<String>();
		//List<String> stack1=new Stack<String>(); push는 오버라이드 메서드가 아님 list로 선언 불가능
		
		stack1.push("사과");
		stack1.push("바나나");
		stack1.push("사과");
		stack1.push("오렌지");
		stack1.push("딸기");
		
		System.out.println("총 개수 : "+stack1.size());
		
		while(!stack1.isEmpty())
		{
			System.out.println(stack1.pop());//마지막으로 추가한 딸기가 먼저 출력됨
		}
		
	}

}
