package data.service;

import data.dto.BoardAnswerDto;
import data.mapper.BoardAnswerMapperInter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardAnswerService {

    @Autowired
    public BoardAnswerMapperInter anInter;

    public void insertAnswer(BoardAnswerDto dto)
    {
        anInter.insertAnswer(dto);
    }
}
