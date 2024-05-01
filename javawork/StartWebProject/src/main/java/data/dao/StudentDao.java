package data.dao;

import java.util.List;
import java.util.Vector;

import data.dto.StudentDto;
import db.common.MySqlConnect;

public class StudentDao {
	MySqlConnect db=new MySqlConnect();
	
	//추가
	public void insertStudent(StudentDto dto)
	{
		
	}
	
	//목록 출력
	
	public List<StudentDto> getAllStudent()
	{
		List<StudentDto> list=new Vector<StudentDto>();
		
		return list;
	}
	
	//디테일
	public StudentDto getData(int num)
	{
		StudentDto dto=new StudentDto();
		
		return dto;
	}
}
