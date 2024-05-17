package anno.study.ex5;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class Sawon {
	@Value("장원영")
	private String name;
	@Value("강남")
	private String addr;
	@Value("22")
	private int age;
}
