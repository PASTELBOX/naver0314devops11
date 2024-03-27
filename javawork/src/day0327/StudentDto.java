package day0327;

public class StudentDto {
	private String name;
	private int age;
	private int java;
	private int spring;
	private int html;
	private int total;
	private double avg;
	private String grade;

	//디폴트 생성자
	public StudentDto() {
		super();
	}
	//매개변수 있는 생성자

	public StudentDto(String name, int age, int java, int spring, int html) {
		super();
		this.name = name;
		this.age = age;
		this.java = java;
		this.spring = spring;
		this.html = html;
	}

	//setter & getter
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getJava() {
		return java;
	}

	public void setJava(int java) {
		this.java = java;
	}

	public int getSpring() {
		return spring;
	}

	public void setSpring(int spring) {
		this.spring = spring;
	}

	public int getHtml() {
		return html;
	}

	public void setHtml(int html) {
		this.html = html;
	}
	
	
	//java+spring+html의 합을 반환하는 메서드(getTotal)
	
	public int getTotal()
	{
		return total=java+spring+html;
	}
	
	//getTotal()/3.0으로 나눠서 반환하는 메서드(getAvg)
	
	public double getAvg()
	{
		return avg=total/3.0;
	}
	
	//getAvg()의 값이 90이상이면 "*****",80이상이면 "****", 70이상이면 "***" 나머지는 "*"
	//반환하는 메서드 (getGrade)
	
	public String getGrade()
	{
		if(getAvg()>=90)
		{
			System.out.println("*****");
		}
		else if(getAvg()>=80)
		{
			System.out.println("****");
		}
		else if(getAvg()>=70)
		{
			System.out.println("***");
		}
		else
			System.out.println("*");
		return grade;
	}
	
	
}

//*	1.학생정보추가 : 이름, 나이, 3과목 점수 입력
//*	2.학생정보삭제 : 이름으로 찾아서 삭제 없을 경우 메세지 출력
//*	3.전체요소출력 : 번호,이름,Java,Spring,HTML,총점,평균,등급 출력
//*	4.평균으로검색 : 평균값을 입력하면 그 평균값 이상의 학생들을 출력
//*	5.이름으로검색 : 입력한이름을 포함하고 있으면 출력(contains)
//*	6.저장후종료
//* 
