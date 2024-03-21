package day0321;

public class Ex5_ArrayAgeCount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []memberAges= {12,56,34,23,34,59,46,6,11,27,32,49,51,38,44,55,5,7};
		System.out.println("총 인원수 : "+memberAges.length);
		int []ageCount=new int[6];
		/*
		 * 연령별 인원수를 구해서 출력하시오
		 * 
		 * 10대 미만 : 3명
		 * 10대 	   : 5명
		 * 20대	   : 2명
		 *...
		 * 50대                    이런식으로 출력하기
		 */
		for(int i=0;i<memberAges.length;i++)
		{
//			int ages=(int)(memberAges[i]/10);
//			ageCount[ages]++;
			ageCount[memberAges[i]/10]++;
		}
		
		System.out.println("**  연령별 인원수 구하기 **");
		for(int i=0;i<=5;i++)
		{
			if(i==0)
			{
				System.out.printf("10대 미만:%d명\n",ageCount[i]);
			}
			else
			{
				System.out.printf("%d대:%d명\n",i*10,ageCount[i]);
			}
		}
	}

}
