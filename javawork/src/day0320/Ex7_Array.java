package day0320;

public class Ex7_Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []data= {23,100,200,-13,67,-123,78,345,3,110,450,-600,1200};
		int max,min;
		max=min=data[0];//무조건 첫데이터를 max또는 min 지정
		System.out.println(data.length);
		
		for(int i=1;i<data.length;i++)
		{
			if(max<data[i])
				max=data[i];
		}
		System.out.println("최대값:"+max);
		
		for(int i=1;i<data.length;i++)
		{
			if(min>data[i])
				min=data[i];
		}
		System.out.println("최소값:"+min);
		
		int pcnt=0,mcnt=0;
		//배열데이터 중 양수의 개수와 음수의 개수를 구하여서 출력해보시오
		for(int i=0;i<data.length;i++)
		{
			if(0<=data[i])
				pcnt++;
		}
		System.out.println("양수의 개수:"+pcnt);
		
		for(int i=0;i<data.length;i++)
		{
			if(0>data[i])
				mcnt++;
		}
		System.out.println("음수의 개수:"+mcnt);
		
	}

}
