package data.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import data.dto.ProfileDto;
import db.common.MySqlConnect;

public class ProfileDao {
	
	MySqlConnect connect=new MySqlConnect();
	
	public void insertProfile(ProfileDto dto)
	{
		Connection conn=null;
		PreparedStatement pstmt=null;
		
		String sql="""
				insert into instaprofile (name,email,username,password,introduce,profilephoto)
				values (?,?,?,?,?,?)
				""";
		conn=connect.getConnection();
		
		try {
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getEmail());
			pstmt.setString(3, dto.getUsername());
			pstmt.setString(4, dto.getPassword());
			pstmt.setString(5, dto.getIntroduce());
			pstmt.setString(6, dto.getProfilephoto());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			connect.dbClose(pstmt, conn);
		}
	}
	
	public void updateProfile(ProfileDto dto)
	{
		Connection conn=null;
		PreparedStatement pstmt=null;
		
		String sql="update instaprofile set name=?,email=?,username=?,password=?,introduce=?,profilephoto=?";
		conn=connect.getConnection();//db 연결
		try {
			pstmt=conn.prepareStatement(sql);
			//바인딩
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getEmail());
			pstmt.setString(3, dto.getUsername());
			pstmt.setString(4, dto.getPassword());
			pstmt.setString(5, dto.getIntroduce());
			pstmt.setString(6, dto.getProfilephoto());
			//실행
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("update 오류:"+e.getMessage());
		}finally {
			connect.dbClose(pstmt, conn);
		}
		
	}
	
	public List<ProfileDto> getProfileDatas()
	{
		List<ProfileDto> list=new Vector<ProfileDto>();
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="select * from instaprofile";
		
		conn=connect.getConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				ProfileDto dto=new ProfileDto();
				
				dto.setPnum(rs.getString("pnum"));
				dto.setName(rs.getString("name"));
				dto.setEmail(rs.getString("email"));
				dto.setUsername(rs.getString("usernmae"));
				dto.setPassword(rs.getString("password"));
				dto.setIntroduce(rs.getString("introduce"));
				dto.setProfilephoto(rs.getString("profilephoto"));				
				
				list.add(dto);				
			}
		} catch (SQLException e) {
			System.out.println("select 오류:"+e.getMessage());
		}finally {
			connect.dbClose(rs, pstmt, conn);
		}
		
		return list;
	}
	
	
}
