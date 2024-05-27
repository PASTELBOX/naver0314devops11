package data.service;

import data.dto.MemberDto;
import data.mapper.MemberMapperInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public void updatePhoto(int num,String photo)
    {
        Map<String, Object> map=new HashMap<>();
        map.put("num",num);
        map.put("photo",photo);
        memInter.updatePhoto(map);
    }

    public void updateMember(MemberDto dto)
    {
        memInter.updateMember(dto);
    }

    public boolean deleteMember(int num,String passwd)
    {
        Map<String, Object> map=new HashMap<String, Object>();
        map.put("num", num);
        map.put("passwd", passwd);
        return memInter.deleteMember(map)==1?true:false;

    }

    public boolean isLoginCheck(String myid,String pass)
    {
        return memInter.isLoginCheck(myid,pass)==1?true:false;
    }
}
