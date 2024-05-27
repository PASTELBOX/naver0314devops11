package data.service;

import data.dto.ReBoardDto;
import data.mapper.ReBoardMapperInter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ReBoardService {
    @NonNull
    private ReBoardMapperInter boardMapper;

    public int getMaxNum()
    {
        return boardMapper.getMaxNum();
    }

    public void updateRestep(int regroup,int restep)
    {
        Map<String, Integer> map=new HashMap<>();
        map.put("regroup",null);
        map.put("restep",null);

        boardMapper.updateRestep(map);
    }

    public void insertBoard(ReBoardDto dto)
    {

    }
}
