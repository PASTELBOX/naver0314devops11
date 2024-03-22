package day0321;

import java.util.Scanner;

public class Book199_9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 학생수(student)와 각 학생들의 점수(score)를 입력받고
		 * (while문 Scanner의 nextLine()을 이용)
		 * 최고 점수(best), 평균점수(avg)를 출력
		 * --------------------------------------
		 * 1.학생수 2.점수입력 3.점수리스트 4.분석 5.종료
		 * -------------------------------------
		 * 선택> 1
		 * 학생수> 3
		 */

		//			System.out.println("학생수를 입력");
		//			student=sc.nextInt();
		//			int []score=new int[student];
		//			
		//			for(int i=0;i<student;i++) 
		//			{
		//				System.out.println("점수 입력");
		//				score[i]=sc.nextInt();
		//			}

		//			for(int i=0;i<score.length;i++)
		//			{
		//				for(int j=1+1;j<score.length;j++)
		//				{
		//					if(score[i]<score[j])
		//					{
		//						int stemp=score[i];
		//						score[i]=score[j];
		//						score[j]=stemp;
		//					}
		//				}
		//			}
		//			best=score[0];
		//			for(int i=0;i<score.length;i++)
		//			{
		//				avg+=(double)(score[i]/3.0);
		//			}




		//정답 1
		//		Scanner sc=new Scanner(System.in);
		//		int student = 0,best,want;
		//		double avg=0;
		//		int []score=new int[3];
		//		Loop:
		//			while(true) 
		//			{
		//
		//				System.out.println("원하는 정보를 입력");
		//				want=sc.nextInt();
		//				switch(want) 
		//				{
		//				case 1:
		//				{
		//					System.out.println("학생수를 입력");
		//					student=sc.nextInt();
		//					break;
		//				}
		//				case 2:
		//				{
		//					System.out.println("점수 입력");
		//					for(int i=0;i<student;i++) 
		//					{
		//						score[i]=sc.nextInt();
		//					}
		//					break;
		//				}
		//				case 3:
		//				{
		//					for(int i=0;i<score.length;i++)
		//					{
		//						for(int j=1+1;j<score.length;j++)
		//						{
		//							if(score[i]<score[j])
		//							{
		//								int stemp=score[i];
		//								score[i]=score[j];
		//								score[j]=stemp;
		//							}
		//						}
		//					}
		//					for(int i=0;i<score.length;i++)
		//					{
		//						System.out.println("점수 리스트는 : "+score[i]);
		//					}
		//					break;
		//
		//				}
		//				case 4:
		//				{
		//					best=score[0];
		//					for(int i=0;i<score.length;i++)
		//					{
		//						avg+=(double)(score[i]/3.0);
		//					}
		//					System.out.println("분석 결과 최고 점수는"+best+"평균은"+avg);
		//				}
		//				break;
		//				case 5:
		//				{
		//					break Loop;
		//				}
		//				default:
		//				{
		//					System.out.println("해당 번호와 연관된 정보가 없습니다.");
		//					break;
		//				}
		//
		//
		//
		//
		//				}
		//			}




		//정답2
		Scanner sc=new Scanner(System.in);
		int inwon=0,num=0,max=0,sum=0;
		double avg=0;
		int []score=null;
		
		Exit:
		while(true)
		{
			System.out.println("-".repeat(50));
			System.out.println("1.학생수 | 2. 점수입력 | 3.점수리스트 | 4.분석 | 5.종료");
			System.out.println("-".repeat(50));
			num=sc.nextInt();
		
			switch(num)
			{
				case 1:
					System.out.print("학생수 >>");		
					inwon=sc.nextInt();
					//배열 메모리 할당
					score=new int[inwon];
					break;
				case 2:
					for(int i=0;i<score.length;i++)
					{
						System.out.print("scores["+i+"] >>");
						score[i]=sc.nextInt();
					}
					break;
				case 3:
					System.out.println("** 입력한 점수들 **");
					for(int i=0;i<score.length;i++)
					{
						System.out.printf("%d 번째 점수 : %d점\n",i+1,score[i]);
					}
					break;
				case 4:
					//최대값 구하기
					max=score[0];//첫번째 점수를 일단 max 로 지정
					//1번 데이타부터 비교후 max보다 클경우 max변경
					for(int i=1;i<score.length;i++)
					{
						if(max<score[i])
							max=score[i];
					}
					
					//총점,평균 구하기
					sum=0;
					for(int s:score)
						sum+=s;
					//평균
					avg=(double)sum/inwon;
					System.out.println("** 성적 분석 결과 **");
					System.out.println("최고점수 : "+max);
					System.out.println("합 계 : "+sum);
					System.out.printf("평 균 : %5.2f\n",avg);					
					break;

				default:
					System.out.println("** 프로그램을 종료합니다 **");
					break Exit;
			}
			System.out.println();
		}










		//		구분=============================================

	}





}


