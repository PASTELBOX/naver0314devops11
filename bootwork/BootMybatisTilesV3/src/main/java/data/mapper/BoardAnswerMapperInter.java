package data.mapper;

import data.dto.BoardAnswerDto;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BoardAnswerMapperInter {
    @Insert("""
            insert into boardanswer (num,writer,myid,content,writeday)
            values (#{num},#{writer},#{myid},#{content},now())
            """)
    public void insertAnswer(BoardAnswerDto dto);
}
