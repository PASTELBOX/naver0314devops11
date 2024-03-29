package day0328;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.FileDialog;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Ex8_SwingMunje extends JFrame {

	
	JButton btnOpen;
	
	public Ex8_SwingMunje(String title)
	{
		super(title);
		this.setLocation(100, 100);//시작위치
		this.setSize(500, 500);//창크기
		//this.getContentPane().setBackground(new Color(93,199,140));//배경색 변경
		//this.getContentPane().setBackground(Color.yellow);//배경색 변경
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//프레임 종료
		this.initDesign();//각종 컴포넌트 생성
		this.setVisible(true);
	}
	
	class myImage extends Canvas
	{
		@Override
		public void paint(Graphics g) {
			// TODO Auto-generated method stub
			super.paint(g);
			
			Image image=null;
			g.drawImage(image, 80, 100, 220, 260, this);
		}

	}
	
	
	public void initDesign()
	{
		JPanel p=new JPanel();
		myImage imageicon=new myImage();
		
		this.setLayout(null);
		btnOpen=new JButton("사진 불러오기");
		btnOpen.setBounds(50, 10, 400, 100);
		this.add(btnOpen);
		
		this.add("North",p);
		this.add("Center",imageicon);
		
		
		btnOpen.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				FileDialog dlg=new FileDialog(Ex8_SwingMunje.this, "사진 불러오기", FileDialog.LOAD);
				dlg.setVisible(true);
				
				if(dlg.getDirectory()==null)
					return;
				String path=dlg.getDirectory()+dlg.getFile();
				
				FileReader fr=null;
				BufferedReader br=null;
				
				Image image=new ImageIcon(dlg.getFile()).getImage();
				
				
				
				try {
					fr=new FileReader(path);
					br=new BufferedReader(fr);
					
					while(true)
					{
						if(image==null)
							break;
						Image myImage = image;
						
						
					}
				} catch (IOException|NullPointerException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}finally {
					try {
						br.close();
						fr.close();
					}catch (IOException|NullPointerException e2) {

					}
				}
			}
		});
		
	}

public static void main(String[] args) {
	// TODO Auto-generated method stub
	Ex8_SwingMunje a=new Ex8_SwingMunje("이미지");
}

}
