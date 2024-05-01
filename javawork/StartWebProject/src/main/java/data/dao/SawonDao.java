package data.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import data.dto.SawonDto;
import db.common.MySqlConnect;

public class SawonDao {
	MySqlConnect db=new MySqlConnect();

	//추가
	public void insertSawon(SawonDto dto)
	{
		Connection conn=null;
		PreparedStatement pstmt=null;
		
		String sql="""
				insert into mysawon(name,buseo,age,addr,photo,gender,birthday)
				values (?,?,?,?,?,?,?)
				""";
		
		conn=db.getConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getBuseo());
			pstmt.setInt(3, dto.getAge());
			pstmt.setString(4, dto.getAddr());
			pstmt.setString(5, dto.getPhoto());
			pstmt.setString(6, dto.getGender());
			pstmt.setString(7, dto.getBirthday());
			
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn);
		}
	}
	
	public void deleteSawon(int num)
	{
		Connection conn=null;
		PreparedStatement pstmt=null;
		
		String sql="delete from mysawon where num=?";
		
		conn=db.getConnection();
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn);
		}
		
	}
	
	public void updateSawon(SawonDto dto)
	{
		Connection conn=null;
		PreparedStatement pstmt=null;
		
		String sql="update mysawon set photo=?,name=?,addr=?,age=?,birthday=?,buseo=?,gender=? where num=?";
		
		conn=db.getConnection();
		
		try {
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getPhoto());
			pstmt.setString(2, dto.getName());
			pstmt.setString(3, dto.getAddr());
			pstmt.setInt(4, dto.getAge());
			pstmt.setString(5, dto.getBirthday());
			pstmt.setString(6, dto.getBuseo());
			pstmt.setString(7, dto.getGender());
			pstmt.setInt(8, dto.getNum());
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn);
		}
		
	}
	
	//전체출력
	public List<SawonDto> getAllSawons()
	{
		List<SawonDto> list=new Vector<SawonDto>();
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		String sql="""
				select * from mysawon order by name asc
				""";
		
		conn=db.getConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				SawonDto dto=new SawonDto();
				
				dto.setNum(rs.getInt("num"));
				dto.setName(rs.getString("name"));
				dto.setAddr(rs.getString("addr"));
				dto.setAge(rs.getInt("age"));
				dto.setBirthday(rs.getString("birthday"));
				dto.setBuseo(rs.getString("buseo"));
				dto.setGender(rs.getString("gender"));
				dto.setPhoto(rs.getString("photo"));
				
				list.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(rs, pstmt, conn);
		}
		
		return list;
	}
	
	//한개 반환
	public SawonDto getData(int num)
	{
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		SawonDto dto=new SawonDto();
		String sql="""
				select * from mysawon where num=?
				""";
		
		conn=db.getConnection();
		try {
			pstmt=conn.prepareStatement(sql);	
			pstmt.setInt(1, num);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {				
				dto.setNum(rs.getInt("num"));
				dto.setName(rs.getString("name"));
				dto.setAddr(rs.getString("addr"));
				dto.setAge(rs.getInt("age"));
				dto.setBirthday(rs.getString("birthday"));
				dto.setBuseo(rs.getString("buseo"));
				dto.setGender(rs.getString("gender"));
				dto.setPhoto(rs.getString("photo"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(rs, pstmt, conn);
		}
		
		return dto;
	}
	
	
	//성별 분석 데이터 반환
	public List<Map<String,String>> getGenderAnalysis()
	{
		List<Map<String,String>> list=new Vector<Map<String,String>>();
		String sql="""
				select gender,count(*) count,round(avg(age),1) age
				from mysawon group by gender
				""";
		Connection conn=db.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				Map<String, String> map=new HashMap<String, String>();
				String gender=rs.getString("gender");
				String count=rs.getString("count");
				String age=rs.getString("age");
				
				//map 에 넣기
				map.put("gender", gender);
				map.put("count", count);
				map.put("age", age);
				
				//list 에 추가
				list.add(map);				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(rs, pstmt, conn);
		}
		return list;
	}
	
	//부서 분석 데이터 반환
	public List<Map<String, String>> getBuseoAnalysis()
	{
		List<Map<String,String>> list=new Vector<Map<String,String>>();
		String sql ="""
				select buseo,count(*) count,round(avg(age),1) age 
				from mysawon group by buseo
				""";
		
		Connection conn=db.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			while(rs.next())
			{
				Map<String, String> map=new HashMap<String, String>();
				String buseo=rs.getString("buseo");
				String count=rs.getString("count");
				String age=rs.getString("age");
				
				map.put("buseo", buseo);
				map.put("count", count);
				map.put("age", age);
				
				list.add(map);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(rs, pstmt, conn);
		}
		return list;
	}

	
	
}
