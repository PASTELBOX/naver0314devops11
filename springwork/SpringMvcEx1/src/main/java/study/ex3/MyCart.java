package study.ex3;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Setter
public class MyCart {
	Person person;
	@NonNull
	private String sangpum;
	@NonNull
	private int price;
	
//	public MyCart(String sangpum,int price) {
//		// TODO Auto-generated constructor stub
//		this.sangpum=sangpum;
//		this.price=price;
//	}
//	
//	public void setPerson(Person person) {
//		this.person = person;
//	}
	
	public void showInfo()
	{
		System.out.println("�����ѻ�� �̸� :"+person.getName());
		System.out.println("�����ѻ�� �ڵ��� :"+person.getPhone());
		System.out.println("��ǰ�� : "+sangpum);
		System.out.println("��ǰ���� : "+price);
		
	}
}