package data.mapper;

import data.dto.ReBoardDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface ReBoardMapperInter {
    public int getMaxNum();
    public void updateRestep(Map<String, Integer> map);//regroup, restep
    public void insertBoard(ReBoardDto dto);
}
