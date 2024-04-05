package day0404db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.xdevapi.DeleteStatement;

public class Ex3DBMunje {
	static final String MYSQL_DRIVER="com.mysql.cj.jdbc.Driver";
	static final String MYSQL_URL="jdbc:mysql://localhost:3306/bit701?serverTimezone=Asia/Seoul";
	static final String USERNAME="root";
	static final String PASSWORD="1234";

	public Ex3DBMunje() {
		// TODO Auto-generated constructor stub
		try {
			Class.forName(MYSQL_DRIVER);
			System.out.println("mysql 드라이버 연결 성공!");
		} catch (ClassNotFoundException e) {
			System.out.println("mysql 드라이버 연결 실패!"+e.getMessage());
		}
	}


	static public void showTitle()
	{
		System.out.println("=".repeat(40));
		System.out.println("부서\t인원수\t최고점수\t평균점수");
		System.out.println("=".repeat(40));
	}

	public void writeSawon2()
	{
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;

		String sql="select buseo,count(*) inwon,max(score) maxscore,ceiling(avg(score)) avgscore from sawon group by buseo";

		try {
			conn=DriverManager.getConnection(MYSQL_URL, USERNAME, PASSWORD);
			System.out.println("mysql 서버 연결 성공!");

			showTitle();

			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);

			while(rs.next())
			{
				String buseo=rs.getString("buseo");
				int inwon=rs.getInt("inwon");
				int maxscore=rs.getInt("maxscore");
				int avgscore=rs.getInt("avgscore");

				System.out.println(buseo+"\t"+inwon+"\t"+maxscore+"\t"+avgscore);
			}
		} catch (SQLException e) {
			System.out.println("mysql 서버 연결 실패!"+e.getMessage());
		}finally {
			try {
				rs.close();	
				stmt.close();
				conn.close();
			} catch (SQLException|NullPointerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}


	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex3DBMunje ex3=new Ex3DBMunje();
		ex3.writeSawon2();
	}

}
