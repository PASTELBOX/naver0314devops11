package data.dao;

import java.sql.*;
import java.util.*;

import data.dto.FeedDto;
import db.common.MySqlConnect;

public class FeedDao {

    MySqlConnect connect = new MySqlConnect();

    public void insertFeed(FeedDto dto) 
    {
    	Connection conn=null;
    	PreparedStatement pstmt=null;
    	
        String sql = """
                insert into feed (title, writetime, feedphoto, tag, text)
                values (?, ?, ?, ?, ?)
                """;
        conn=connect.getConnection();

        try {
        	pstmt=conn.prepareStatement(sql);
        	
            pstmt.setString(1, dto.getTitle());
            pstmt.setTimestamp(2, dto.getWritetime());
            pstmt.setString(3, dto.getFeedphoto());
            pstmt.setString(4, dto.getTag());
            pstmt.setString(5, dto.getText());

            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Error inserting feed: " + e.getMessage());
           
        }
    }

    public void updateFeed(FeedDto dto) 
    {
    	Connection conn=null;
		PreparedStatement pstmt=null;
		
        String sql = "update feed set title=?,wirtetime=?,feedphoto=?,tag=?,text=? where num=?";
        conn=connect.getConnection();
        		
        try {
        	pstmt=conn.prepareStatement(sql);
            
            pstmt.setString(1, dto.getTitle());
            pstmt.setTimestamp(2, dto.getWritetime());
            pstmt.setString(3, dto.getFeedphoto());
            pstmt.setString(4, dto.getTag());
            pstmt.setString(5, dto.getText());
            pstmt.setInt(6, dto.getNum());

            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Error updating feed: " + e.getMessage());
        }
    }

    public List<FeedDto> getFeedDatas() {
        List<FeedDto> list = new Vector<FeedDto>();
        Connection conn=null;
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        String sql = "select * from feed";
        
        conn=connect.getConnection();

        try {
        	pstmt=conn.prepareStatement(sql);
    		rs=pstmt.executeQuery();            
            while (rs.next()) {
                FeedDto dto = new FeedDto();
                
                dto.setNum(rs.getInt("num"));
                dto.setTitle(rs.getString("title"));
                dto.setWritetime(rs.getTimestamp("writetime"));
                dto.setFeedphoto(rs.getString("feedphoto"));
                dto.setTag(rs.getString("tag"));
                dto.setText(rs.getString("text"));

                list.add(dto);
            }

        } catch (SQLException e) {
            System.err.println("Error fetching feed data: " + e.getMessage());
        } finally {
        	connect.dbClose(rs, pstmt, conn);
        }

        return list;
    }
}