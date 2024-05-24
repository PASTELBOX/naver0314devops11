package data.service;

import data.dto.MemberDto;
import data.mapper.MemberMapperInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {
    @Autowired
    private MemberMapperInter memInter;

    public int getTotalCount()
    {
        return memInter.getTotalCount();
    }

    public int getIdCheckCount(String searchid)
    {
        return memInter.getIdCheckCount(searchid);
    }

    public void insertMember(MemberDto dto)
    {
        memInter.insertMember(dto);
    }

    public List<MemberDto> getAllMembers()
    {
        return memInter.getAllMembers();
    }

    public MemberDto getData(int num)
    {
        return memInter.getData(num);
    }
}
