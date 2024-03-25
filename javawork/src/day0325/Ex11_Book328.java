package day0325;
//교재 328 페이지 예제 해보기
//단 Animal,Dog,Cat은 이미 구현되어 있으므로
//Animal2,Dog2,Cat2로 구현하세요
//추상 클래스에 대한 예제임/ 내일 주로 이 내용으로 예쩨 할거예요

class Animal2
{
	public void sound()
	{
		System.out.println("소리 낸다.");
	}
}

class Cat2 extends Animal2
{
	@Override
	public void sound() {
		// TODO Auto-generated method stub
		super.sound();
		System.out.println("야옹");
	}
}

class Dog2 extends Animal2
{
	@Override
	public void sound() {
		// TODO Auto-generated method stub
		super.sound();
		System.out.println("멍멍");
	}
}

public class Ex11_Book328 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Animal2 ani2=null;
		ani2=new Cat2();
		ani2.sound();
		
		ani2=new Dog2();
		ani2.sound();
	}

}
