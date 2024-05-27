package data.service;

import data.mapper.ReBoardMapperInter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReBoardService {
    @NonNull
    private ReBoardMapperInter boardMapper;
}
