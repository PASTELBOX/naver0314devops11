package anno.study.ex5;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class Sawon {
	@Value("�����")
	private String name;
	@Value("����")
	private String addr;
	@Value("22")
	private int age;
}
