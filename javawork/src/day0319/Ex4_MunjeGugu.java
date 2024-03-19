package day0319;

public class Ex4_MunjeGugu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 2x1 3x1 4x1
		// 2x2 3x2 4x2
		
		System.out.printf("%30s\n\n","[구구단]");
		for(int dan=2;dan<=9;dan++)
		{
			System.out.printf("**%d단**\t",dan);
		}
		System.out.println();
		System.out.println("=".repeat(63));
		
		for(int i=1;i<=9;i++)
		{
			for(int dan=2;dan<=9;dan++)
			{
				System.out.printf("%dx%d=%2d\t",dan,i,dan*i);
			}
			System.out.println();
		}
		
		

	}

}
