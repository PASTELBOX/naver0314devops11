package day0329;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Ex6_SwingTableShop extends JFrame {
	
	JTable table;
	DefaultTableModel tableModel;
	JButton btnAdd,btnDelete;
	JTextField tfSang,tfSu,tfDan;
	
	public Ex6_SwingTableShop(String title)
	{
		super(title);
		this.setLocation(100, 100);//시작위치
		this.setSize(400, 500);//창크기
		this.getContentPane().setBackground(new Color(93,199,140));//배경색 변경
		//this.getContentPane().setBackground(Color.yellow);//배경색 변경
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//프레임 종료
		this.initDesign();//각종 컴포넌트 생성
		this.setVisible(true);
	}
	
	public void initDesign()
	{
		//상단에는 추가,삭제 버튼
		JPanel pTop=new JPanel();
		btnAdd=new JButton("상품정보추가");
		btnDelete=new JButton("상품정보삭제");
		pTop.add(btnAdd);
		pTop.add(btnDelete);
		this.add("North",pTop);
	}

public static void main(String[] args) {
	// TODO Auto-generated method stub
	Ex6_SwingTableShop a=new Ex6_SwingTableShop("기본창");
}

}
