package data.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

import java.sql.Timestamp;

@NoArgsConstructor
@Data
@Alias("badto")
public class BoardAnswerDto {
    private int aidx;
    private int num;
    private String writer;
    private String myid;
    private String content;
    private Timestamp writday;
}
