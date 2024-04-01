package day0329;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/*
 * 버튼 2개 (btnAdd,btnDelete)
테이블 table
콤보 박스1개(레이블 4개)(name blood.toupper addr rank)
name(aaa,bbb,ccc)
blood.toupper(A,B,O,AB)
addr(seoul,busan...)
rank(부,차,과,대,사,사,인)무한상사
 */

public class Ex7_SwingFileMunje extends JFrame {

	JComboBox<String> comboBlood,comboAddr,comboRank;
	int selectComboBlood=0;
	int selectComboAddr=0;
	int selectComboRank=0;
	String []comboBloodLabel= {"A형","B형","O형","AB형"};
	String []comboAddrLabel= {"강남구","영등포구","서초구","강서구","마포구"};
	String []comboRankLabel= {"부장","차장","과장","대리","사원","인턴"};	
	DefaultTableModel tableModel;
	JButton btnAdd,btnDelete;
	JTable table;
	String name,blood,addr,rank;
	JTextField tfName;
		
	final static String FILENAME="c:/naver0314/sawon.txt";

	public Ex7_SwingFileMunje(String title)
	{
		super(title);
		this.setLocation(100, 100);//시작위치
		this.setSize(400, 500);//창크기
		//getContentPane().setBackground(new Color(93,199,140));//배경색 변경
		//this.getContentPane().setBackground(Color.yellow);//배경색 변경
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//프레임 종료
		this.initDesign();//각종 컴포넌트 생성
		this.setVisible(true);
		this.sawonFileRead();
		this.addWindowListener(new WindowAdapter() 
		{
			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub
				super.windowClosed(e);
				FileWriter fw=null;
				try {
					fw=new FileWriter(FILENAME);
					for(int i=0;i<table.getRowCount();i++)
					{
						String name=table.getValueAt(i, 0).toString();
						String blood=table.getValueAt(i, 1).toString();
						String addr=table.getValueAt(i, 2).toString();
						String rank=table.getValueAt(i, 3).toString();
						
						String s=name+","+blood.toUpperCase()+","+addr+","+rank;
						fw.write(s);
						
					}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}finally {
					try {
						fw.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				System.exit(0);
				
			}
			
		});
	}
	
	public void sawonFileRead()
	{
		FileReader fr=null;
		BufferedReader br=null;
		
		try
		{
			fr=new FileReader(FILENAME);
			br=new BufferedReader(fr);
			
			while(true)
			{
				String s=br.readLine();
				if(s==null)
					break;
				
				
			}
		}catch (FileNotFoundException e) {
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			try
			{
				br.close();
				fr.close();
			}catch(IOException|NullPointerException e) {
				
			}
		}
	}
	
	
	public void initDesign()
	{
		JPanel pTop=new JPanel();
		btnAdd=new JButton("사원정보추가");
		btnDelete=new JButton("사원정보삭제");
		pTop.add(btnAdd);
		pTop.add(btnDelete);
		this.add("North",pTop);
		
		String []title= {"이름","혈액형","지역","직급"};
		tableModel=new DefaultTableModel(title,0);
		table=new JTable(tableModel);
		this.add("Center",new JScrollPane(table));
		
		tfName=new JTextField(7);
		comboBlood=new JComboBox<String>(comboBloodLabel);
		comboAddr=new JComboBox<String>(comboAddrLabel);
		comboRank=new JComboBox<String>(comboRankLabel);
		
		JPanel pBottom=new JPanel();
		pBottom.add(new JLabel("이름"));
		pBottom.add(tfName);
		pBottom.add(new JLabel("혈액형"));
		pBottom.add(comboBlood);	
		pBottom.add(new JLabel("주소"));
		pBottom.add(comboAddr);
		pBottom.add(new JLabel("직급"));
		pBottom.add(comboRank);
		
		comboBlood.setSelectedIndex(selectComboBlood);
		comboBlood.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				selectComboBlood=comboBlood.getSelectedIndex()+1;
			}
		});
		comboAddr.setSelectedIndex(selectComboAddr);
		comboAddr.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				selectComboAddr=comboBlood.getSelectedIndex()+1;
			}
		});
		comboRank.setSelectedIndex(selectComboRank);
		comboRank.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				selectComboRank=comboBlood.getSelectedIndex()+1;
			}
		});
		

		
		this.add("South",pBottom);
		
		btnAdd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(tfName.getText().length()==0)
				{
					JOptionPane.showMessageDialog(Ex7_SwingFileMunje.this, "이름을 입력해주세요");
				}
				String name=tfName.getText();
				String blood=(String)comboBlood.getSelectedItem();
				String addr=(String)comboAddr.getSelectedItem();
				String rank=(String)comboRank.getSelectedItem();
				Vector<String> data=new Vector<String>();
				data.add(name);
				data.add(blood);
				data.add(addr);
				data.add(rank);
				
				tableModel.addRow(data);
				
				tfName.setText("");
				
				
			}
		});
		
		btnDelete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int row=table.getSelectedRow();
				if(row==-1)
				{
					JOptionPane.showMessageDialog(Ex7_SwingFileMunje.this, "삭제할 행을 선택해주세요");
				}
				else
				{
					tableModel.removeRow(row);
				}
				
			}
		});
		
		
	}

public static void main(String[] args) {
	// TODO Auto-generated method stub
	Ex7_SwingFileMunje a=new Ex7_SwingFileMunje("사원");
}

}
