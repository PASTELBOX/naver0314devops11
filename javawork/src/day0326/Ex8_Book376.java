package day0326;

interface Tire
{
	public void roll();
}

class HankookTire implements Tire
{
	@Override
	public void roll() {
		// TODO Auto-generated method stub
	System.out.println("한국 타이어가 굴러갑니다.");	
	}
}

class KumhoTire implements Tire
{
	@Override
	public void roll() {
		// TODO Auto-generated method stub
	System.out.println("금호 타이어가 굴러갑니다.");	
	}
}

class Car
{
	Tire tire1=new HankookTire();
	Tire tire2=new KumhoTire();
	
	public void run()
	{
		tire1.roll();
		tire2.roll();
	}
}

public class Ex8_Book376 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Car myCar=new Car();
		myCar.run();
		myCar.tire1=new KumhoTire();
		myCar.tire2=new HankookTire();
		myCar.run();
	}

}
