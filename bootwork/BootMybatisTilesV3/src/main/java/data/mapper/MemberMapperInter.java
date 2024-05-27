package data.mapper;

import data.dto.MemberDto;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface MemberMapperInter {
    @Select("select count(*) from memberdb")
    public int getTotalCount();

    @Select("select count(*) from memberdb where myid=#{searchid}")
    public int getIdCheckCount(String searchid);

    @Insert("""
            insert into memberdb (name, myid, passwd, addr, hp, email, photo, birthday, gaipday) 
            VALUES (#{name},#{myid},#{passwd},#{addr},#{hp},#{email},#{photo},#{birthday},now())
            """)
    public void insertMember(MemberDto dto);

    @Select("select * from memberdb order by num desc")
    public List<MemberDto> getAllMembers();

    @Select("select * from memberdb where num=#{num}")
    public MemberDto getData(int num);

    @Select("select * from memberdb where myid=#{myid}")
    public MemberDto getDataByID(String myid);

    @Update("update memberdb set photo=#{photo} where num=#{num}")
    public void updatePhoto(Map<String, Object> map);

    @Update("update memberdb set name=#{name},hp=#{hp},email=#{email},addr=#{addr},birthday=#{birthday} where num=#{num}")
    public void updateMember(MemberDto dto);

    @Delete("delete from memberdb where num=#{num} and passwd=#{passwd}")
    public int deleteMember(Map<String, Object> map);

    @Select("""
            select count(*) from memberdb where myid=#{myid} and passwd=#{pass}
            """)
    public int isLoginCheck(String myid, String pass);

}
