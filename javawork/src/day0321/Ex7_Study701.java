package day0321;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


public class Ex7_Study701 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String []members= {
				"강하윤","공병현","김도훈","김우형","김정호",
				"김창인","민경진","박민지","박보민","박주용",
				"박한경","배동우","서정현","손가원","시바타유니",
				"신완철","우태형","유상곤","이가현","이병현",
				"이장우","이현성","정민석","정상혁","정진욱",
				"정환용","최시현","허승필","황재웅","꽝!!"
		};
		
		//2차원 배열에 5명씩 총 6조
//		String [][]team=new String[6][5];
//		String str;
//		while(true)
//		{
//			String []members= {
//					"강하윤","공병현","김도훈","김우형","김정호",
//					"김창인","민경진","박민지","박보민","박주용",
//					"박한경","배동우","서정현","손가원","시바타유니",
//					"신완철","우태형","유상곤","이가현","이병현",
//					"이장우","이현성","정민석","정상혁","정진욱",
//					"정환용","최시현","허승필","황재웅","꽝!!"
//			};
//			Scanner sc=new Scanner(System.in);
//			str=sc.nextLine();
//			if(str.equalsIgnoreCase("x"))
//			{
//				break;
//			}
//			Loop:
//			for(int i=0;i<members.length;i++)
//			{
//				members[i]=members[(int) (Math.random()*30)];
//				for(int j=0;j<i;j++)
//				{
//					if(members[i]==members[j])
//					{
//						i--;
//						continue Loop;
//					}
//				}
//			}
//			for(int i=0;i<members.length;i++)
//			{
//				for(int j=0;j<members[i].length();j++)
//				{
//					int a=0;
//					team[i][j]=members[a++];
//				}
//			}
//			for(int i=0;i<team.length;i++)
//			{
//				for(int j=0;j<team[i].length;j++)
//				{
//					System.out.println(team[i][j]);
//				}
//			}
//		}
		
		int[]rnd=new int[30];
		//2차원 배열에 5명씩 총 6조
		String [][]team=new String[6][5];
		//0~29까지 서로 중복되지 않게 배열에 임의로 발생시켜 넣고
		Loop:
			for(int i=0;i<members.length;i++)
			{
				rnd[i]=(int)(Math.random()*30);
				for(int j=0;j<i;j++)
				{
					if(rnd[i]==rnd[j])
					{
						i--;
						continue Loop;
					}
				}
			}
		
		int idx=0;
		for(int i=0;i<team.length;i++)
		{
			for(int j=0;j<team[i].length;j++)
			{
				team[i][j]=members[rnd[idx++]];
			}
		}
		
		System.out.println("\t\t**701 스터디팀**\n");
		for(int i=0;i<team.length;i++)
		{
			System.out.printf("[%d조 팀]\t",i+1);
			for(int j=0;j<team[i].length;j++)
			{
				System.out.print(team[i][j]+"\t");
			}
			System.out.println();
		}
		
		//현재 날짜를 출력하시오 (년-월-일)
		Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("YYYY년 MM월 DD일");
		System.out.println("\t"+sdf.format(date)+"\t**701 스터디팀**\n");
		for(int i=0;i<team.length;i++)
		{
			System.out.printf("[%d조 팀]\t",i+1);
			for(int j=0;j<team[i].length;j++)
			{
				System.out.print(team[i][j]+"\t");
			}
			System.out.println();
		}
		
		
	}

}
