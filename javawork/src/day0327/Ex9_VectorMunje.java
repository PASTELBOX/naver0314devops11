package day0327;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 *	1.학생정보추가 : 이름, 나이, 3과목 점수 입력
 *	2.학생정보삭제 : 이름으로 찾아서 삭제 없을 경우 메세지 출력
 *	3.전체요소출력 : 번호,이름,Java,Spring,HTML,총점,평균,등급 출력
 *	4.평균으로검색 : 평균값을 입력하면 그 평균값 이상의 학생들을 출력
 *	5.이름으로검색 : 입력한이름을 포함하고 있으면 출력(contains)
 *	6.저장후종료
 *	System.out.println("컴퓨터.contains("컴"));//true
 *	System.out.println("컴퓨터.contains("하"));//false
 *
 */

public class Ex9_VectorMunje {

	List<StudentDto> list=new ArrayList<StudentDto>();
	Scanner sc=new Scanner(System.in);
	static final String FILENAME="c:/naver0314/student.txt";

	public Ex9_VectorMunje()
	{
		studentReadFile();
	}

	public int getMenu()
	{
		int menu=0;
		System.out.println("1.학생정보추가");
		System.out.println("2.학생정보삭제");
		System.out.println("3.전체요소출력");
		System.out.println("4.평균으로검색");
		System.out.println("5.이름으로검색");
		System.out.println("6.저장후종료");

		try 
		{
			menu=Integer.parseInt(sc.nextLine());
		}
		catch(NumberFormatException e){
			System.out.println("잘못된 번호입니다."+e.getMessage());
		}
		return menu;
	}

	public void studentReadFile()
	{
		FileReader fr=null;
		BufferedReader br=null;
		
		try
		{
			fr=new FileReader(FILENAME);
			br=new BufferedReader(fr);
			while(true)
			{
				
			}
		}
	}
	
	public void studentFileSave()
	{
		FileWriter fw=null;
		fw=new FileWriter(FILENAME);
		for
	}

	public void addStudent()
	{
		System.out.println("이름을 입력하세요");
		String name=sc.nextLine();
		System.out.println("나이를 입력하세요");
		int age=sc.nextInt();
		System.out.println("java 점수를 입력하세요");
		int java=sc.nextInt();
		System.out.println("spring 점수를 입력하세요");
		int spring=sc.nextInt();
		System.out.println("html 점수를 입력하세요");
		int html=sc.nextInt();

		StudentDto dto=new StudentDto(name,age,java,spring,html);
		list.add(dto);
		System.out.println(list.size()+"명의 정보를 추가하셨습니다!!!");

	}

	public void deleteStudent()
	{
		boolean f=false;
		System.out.println("삭제하려는 학생의 이름을 입력하세요");
		String name=sc.nextLine();
		for(int i=0;i<list.size();i++)
		{
			StudentDto dto=list.get(i);
			if(name.equals(dto.getName()))
			{
				f=true;
				list.remove(i);
				System.out.println(name+"님의 정보는 삭제되었습니다");
			}
		}
		if(!f)
			System.out.println(name+"님의 정보는 없습니다");
	}

	public void listStudent()
	{
		for(int i=0;i<list.size();i++)
		{
			StudentDto dto=list.get(i);
			System.out.println(i+1+dto.getName()+"\t"+dto.getJava()+"\t"+dto.getSpring()
			+"\t"+dto.getHtml()+"\t"+dto.getTotal()+"\t"+dto.getAvg()+"\t"+dto.getGrade());
		}
	}

	public void avgStudent()
	{
		System.out.println("검색하고 싶은 평균의 점수를 입력하세요");
		int avg=Integer.parseInt(sc.nextLine());
		boolean f=false;
		for(int i=0;i<list.size();i++)
		{
			StudentDto dto=list.get(i);
			if(dto.getAvg()>=avg)
			{
				f=true;
				System.out.println(list.get(i));
			}
			
		}
		if(!f)
			System.out.println(avg+"이상의 평균값을 가진 학생은 없습니다.");
		
	}

	public void searchStudnt()
	{
		System.out.println("검색하고 싶은 이름을 입력하세요");
		String name=sc.nextLine();
		for(int i=0;i<list.size();i++)
		{
			StudentDto dto=list.get(i);
			if(dto.getName().contains(name))
			{
				System.out.println(name+"은 리스트에 있습니다");
			}
			else
			{
				System.out.println(name+"은 리스트에 없습니다.");
			}
		}
	}




	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex9_VectorMunje ex=new Ex9_VectorMunje();
		
		while(true)
		{
			int menu=ex.getMenu();
			
			switch(menu)
			{
			case 1:
				ex.addStudent();
				break;
			case 2:
				ex.deleteStudent();
				break;
			case 3:
				ex.searchStudnt();
				break;
			case 4:
				ex.avgStudent();
				break;
			case 5:
				ex.searchStudnt();
				break;
			case 6:
				ex.studentFileSave();
				System.out.println("** 멤버 정보를 저장 후 종료합니다 **");
				System.exit(0);//종료
			default :
				System.out.println("잘못된 번호입니다");
		}
	}

}
