package day0408;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import db.common.DbConnect;

public class Ex2_DBSawonMine extends JFrame {
	
	DbConnect db=new DbConnect();
	JTable table;
	JTextField tfName,tfScore;
	JComboBox<String> cbGender,cbBuseo;
	JButton btnAdd,btnDel;
	DefaultTableModel tableModel;
	int order=1;
	

	public Ex2_DBSawonMine(String title)
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
	
	public void initDesign()
	{
		JPanel p1=new JPanel();
		
		p1.add(new JLabel("이름"));
		tfName=new JTextField(5);
		p1.add(tfName);
		
		p1.add(new JLabel("점수"));
		tfScore=new JTextField(5);
		p1.add(tfScore);
		
		String []cb1= {"남자","여자"};
		cbBuseo=new JComboBox<String>(cb1);
		p1.add(new JLabel("출력순서"));
		p1.add(cbBuseo);
		
		String []cb2= {"홍보부","인사부","교육부"};
		cbBuseo=new JComboBox<String>(cb2);
		p1.add(new JLabel("출력순서"));
		p1.add(cbBuseo);
		
		this.add("North",p1);
		
		//////////////////////////////////////////////////////////////
		
		String []title= {"시퀀스","이름","점수","성벌","부서"};
		tableModel=new DefaultTableModel(title,0);
		table=new JTable();
		this.add("Center",table);
		
		//////////////////////////////////////////////////////////////		
		
		JPanel p2=new JPanel();
		btnAdd=new JButton("추가");
		btnDel=new JButton("삭제");
		p2.add(btnAdd);
		p2.add(btnDel);
		
		String []cb3= {"홍보부","인사부","교육부"};
		cbBuseo=new JComboBox<String>(cb3);
		p2.add(new JLabel("출력순서"));
		p2.add(cbBuseo);
		this.add("South",p2);
		
		cbBuseo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				order=cbBuseo.getSelectedIndex()+1;
				writeSawon();
			}
		});
		
		btnAdd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(tfName.getText().length()==0)
					return;
				if(tfScore.getText().length()==0)
					return;
				
				Connection conn=db.getConnection();
				PreparedStatement pstmt=null;
				String sql="insert into sawon values (null,?,?,gender,buseo)";
				
				try {
					pstmt=conn.prepareStatement(sql);
					
					pstmt.setString(1, tfName.getText());
					pstmt.setInt(2, Integer.parseInt(tfScore.getText()));
					pstmt.setString(3, cbGender.getSelectedItem().toString());
					pstmt.setString(4, cbBuseo.getSelectedItem().toString());
					
					
					pstmt.execute();
					
					tfName.setText("");
					tfScore.setText("");
					
					writeSawon();					
					
				} catch (SQLException|NullPointerException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}finally {
					db.dbClose(pstmt, conn);
				}
			}
		});
		
		//삭제 이벤트
		btnDel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//테이블의 선택한 행번호 row를 얻는다
				int row=table.getSelectedRow();
				//row가 -1이면 경고메세지후 이벤트 종료
				if(row==-1) {
					JOptionPane.showMessageDialog(Ex2_DBSawonMine.this, "삭제할 행을 선택해주세요");
					return;
				}
				//row행의 0번열에 있는 시퀀스값을 얻는다 getValueAt
				String num=table.getValueAt(row, 0).toString();
				
				//그 시퀀스에 해당하는 db데이타를 삭제하는 sql문 작성
				String sql="delete from student where num=?";
				
				//Connection,PreparedStatement 생성후 sql 문 실행
				Connection conn=db.getConnection();
				PreparedStatement pstmt=null;
				
				try {
					pstmt=conn.prepareStatement(sql);
					pstmt.setString(1, num);
					pstmt.execute();//db 에서 삭제
					
					//db 다시 불러오기
					writeSawon();					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}finally {
					db.dbClose(pstmt, conn);
				}
			}
		});
		
		//출력 메서드 호출
		writeSawon();	
		
		
		
		
	}
	
	public void writeSawon()
	{
		Connection conn=db.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="";
		if(order==1)
			sql="select * from sawon where buseo='홍보부'";
		else if(order==2)
			sql="select * from sawon where buseo='인사부'";
		else if(order==3)
			sql="select * from sawon where buseo='교육부'";

		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();

			while(rs.next())
			{
				Vector<String> data=new Vector<String>();
				data.add(rs.getString("num"));
				data.add(rs.getString("name"));
				data.add(rs.getString("score"));
				data.add(rs.getString("gender"));
				data.add(rs.getString("buseo"));

				//table에 추가
				tableModel.addRow(data);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn, rs);
		}
	}

public static void main(String[] args) {
	// TODO Auto-generated method stub
	Ex2_DBSawonMine a=new Ex2_DBSawonMine("사원관리");
}
	
}
