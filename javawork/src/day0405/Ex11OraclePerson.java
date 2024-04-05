package day0405;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Ex11OraclePerson {
	static final String ORACLE_DRIVER="oracle.jdbc.OracleDriver";
	static final String ORACLE_URL="jdbc:oracle:thin:@localhost:1521/xe";//강사 PC 오라클 192.168.0.59로 변경
	static final String USERNAME="angel";
	static final String PASSWORD="a1234";

	public Ex11OraclePerson() {
		// TODO Auto-generated constructor stub
		try {
			Class.forName(ORACLE_DRIVER);
			//System.out.println("오라클 드라이버 성공!");
		} catch (ClassNotFoundException e) {
			System.out.println("오라클 드라이버 실패 : "+e.getMessage());
		}
	}
	
	public void insertPerson(String name,String blood,int age)
	{
		
	}
	
	public void writePerson()
	{
		String sql="""
				select pnum,pname,page||'세' page,upper(pblood)||'형' pblood,to_char(ipsaday,'yyyy-mm-dd hh:mi') ipsaday from person
				""";
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			conn=DriverManager.getConnection(ORACLE_URL, USERNAME, PASSWORD);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException|NullPointerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex11OraclePerson ex11=new Ex11OraclePerson();
		Scanner sc=new Scanner(System.in);
		int menu=0;
		String name,blood;
		int age;
		
		while(true)
		{
			System.out.println("1.데이터 추가 2.전체출력 3.종료");
			menu=Integer.parseInt(sc.nextLine());
			switch(menu)
			{
			case 1:
				System.out.println("이름입력");
				name=sc.nextLine();
				System.out.println("혈액형은?");
				blood=sc.nextLine();
				System.out.println("나이는?");
				age=Integer.parseInt(sc.nextLine());
				
				ex11.insertPerson(name, blood, age);
				break;
			case 2:
				ex11.writePerson();
				break;
			default :
				System.out.println("프로그램을 종료합니다");
				System.exit(0);
			}
			System.out.println();
		}
	}

}
