package day0326;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

class NewFrame extends JFrame
{
	public NewFrame()
	{
		super("Hello");
		this.setLocation(300, 100);//시작위치
		this.setSize(300, 300);//너비,높이
		//윈도우 이벤트 추가-인터페이스를 요구하는 인자에 익명 내부 클래스 형태로 구현
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub
				super.windowClosed(e);
				System.out.println("윈도우를 종료합니다");
				System.exit(0);
			}
		});
		
		//프레임 보이게 하기
		this.setVisible(true);
		
	}
}



public class Ex11_AnonyWindow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
