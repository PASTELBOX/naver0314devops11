package day0326;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/*
 * score.txt를 읽어서 총갯수와 총점, 평균을 구하시오
 * 단, 점수에 문자가 있는 경우 갯수에서 제외하고 총점에서도 제외하고 출력을 되도록 하기
 * 
 * 갯수 : 13 개
 * 총점 : 990
 * 평균 : 78.99
 */
public class Ex17_ExceptionMunje {

	static final String FILENAME3="c:/naver0314/score.txt";
	static public void readMemo3()
	{
		int su=0,tot=0;
		BufferedReader br1=null;
		FileReader fr1=null;

		try {
			fr1=new FileReader(FILENAME3);
			System.out.println("** score 파일을 읽습니다");
			br1=new BufferedReader(fr1);

			while(true)
			{
				String line=br1.readLine();
				try{
					if(line==null)
						break;
					int num=Integer.parseInt(line);
					su++;
					tot+=num;
				}catch(NumberFormatException e) {
					System.out.println(line);
				}
			}
			double avg=tot/(double)su;
			System.out.println("갯수 : "+su);
			System.out.println("총점 : "+tot);
			System.out.println("평균 : "+avg);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("파일이 없어요 : "+e.getMessage());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				br1.close();
				fr1.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		readMemo3();
	}

}
