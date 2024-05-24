package data.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface MemberMapperInter {
    @Select("select count(*) from memberdb")
    public int getTotalCount();

    @Select("select count(*) from memberdb where myid=#{searchid}")
    public int getIdCheckCount(String searchid);

}
