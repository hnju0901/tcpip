package view;

import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.List;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import org.omg.CORBA.BAD_QOS;

import com.user.UserBiz;
import com.vo.UserVO;

@SuppressWarnings("unused")
public class View2 implements ActionListener {

	Frame frame;
	Frame frame2;
	Frame frame3;
	Frame frame4;
	Frame frame5;
	Panel p1, p2, p3, p4, p5, p6, p7, pp1;
	Button b1, b2, b3, b4, b5, b6, bb1, bb2, bb3, bb4, bb5;
	TextField tf1, tf2, tf3;
	Label lb1, lb2, lb3, lb4, lb5;
	List alist;
	ArrayList<UserVO> list;
	UserVO user;
	String id;
	String pwd;
	String name;
	UserBiz biz;
	
	public View2() {
		frame = new Frame();
		frame2 = new Frame();
		frame3 = new Frame();
		frame4 = new Frame();
		frame5 = new Frame();
		
		p1 = new Panel();
		pp1 = new Panel();
		p2 = new Panel();
		p3 = new Panel();
		p4 = new Panel();
		p5 = new Panel();
		p6 = new Panel();
		p7 = new Panel();

		bb1 = new Button("ȸ�� ����");
		bb2 = new Button("�������� ����");
		bb3 = new Button("�������� ����");
		bb4 = new Button("ȸ�� ��ȸ");
		bb5 = new Button("�� ȸ�� ��ȸ");

		b1 = new Button("���� �� �Ϸ�");
		b2 = new Button("���� �� �Ϸ�");
		b3 = new Button("���� �� �Ϸ�");
		b4 = new Button("��ȸ �� �Ϸ�");
		b5 = new Button("�����ȸ �� �Ϸ�");

		b6 = new Button("��");

		tf1 = new TextField(50);
		tf2 = new TextField(50);
		tf3 = new TextField(50);

		lb1 = new Label(">> ");
		lb2 = new Label("Result >>");
		lb3 = new Label("ID");
		lb4 = new Label("PW");
		lb5 = new Label("NAME");
		alist = new List();
		biz = new UserBiz();

	}

	public void makeUi() {
		alist.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				int position = (int) e.getItem();
				alist.getItem(position);
				UserVO user = list.get(position);
				String result = user.getId() + ", " + user.getPwd() + ", " + user.getName();
				lb2.setText(">> ID, ���, �̸�: " + result);
			}
		});

		bb1.addActionListener(this);
		b1.addActionListener(this);
		bb2.addActionListener(this);
		b2.addActionListener(this);
		bb3.addActionListener(this);
		b3.addActionListener(this);
		bb4.addActionListener(this);
		b4.addActionListener(this);
		bb5.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);

		frame.setSize(600, 400);
		frame.setBackground(Color.BLACK);
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				frame.dispose();
			}
		});
		frame2.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				frame.dispose();
			}
		});
		
		p1.setBackground(Color.white);

		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.white);

		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.white);

		b3.setBackground(Color.BLACK);
		b3.setForeground(Color.white);

		b4.setBackground(Color.BLACK);
		b4.setForeground(Color.white);

		b5.setBackground(Color.BLACK);
		b5.setForeground(Color.white);

		b6.setBackground(Color.darkGray);
		b6.setForeground(Color.white);

		p1.setLayout(new GridLayout(5, 1));
		p1.add(b1);
		p1.add(b2);
		p1.add(b3);
		p1.add(b4);
		p1.add(b5);

		pp1.setBackground(Color.white);

		bb1.setBackground(Color.darkGray);
		bb1.setForeground(Color.white);

		bb2.setBackground(Color.darkGray);
		bb2.setForeground(Color.white);

		bb3.setBackground(Color.darkGray);
		bb3.setForeground(Color.white);

		bb4.setBackground(Color.darkGray);
		bb4.setForeground(Color.white);

		bb5.setBackground(Color.darkGray);
		bb5.setForeground(Color.white);

		pp1.setLayout(new GridLayout(5, 1));
		pp1.add(bb1);
		pp1.add(bb2);
		pp1.add(bb3);
		pp1.add(bb4);
		pp1.add(bb5);

	/*	p2.setBackground(Color.ORANGE);
		p2.setLayout(new GridLayout(4, 1));
		p2.add(lb1);

		p2.add(p3);
		p3.setLayout(new GridLayout(1, 4));

		p3.setBackground(Color.DARK_GRAY);
		p3.setForeground(Color.white);
		tf1.setForeground(Color.BLUE);
		tf2.setForeground(Color.BLUE);
		tf3.setForeground(Color.BLUE);
		
		p4.setLayout(new GridLayout(2, 1));
		p4.add(lb3);
		p4.add(tf1);
		p5.setLayout(new GridLayout(2, 1));
		p5.add(lb4);
		p5.add(tf2);
		p6.setLayout(new GridLayout(2, 1));
		p6.add(lb5);
		p6.add(tf3);

		p3.add(p4);
		p3.add(p5);
		p3.add(p6);
		// p3.add(b6);

		p2.add(alist);
		p2.add(lb2);*/

		// frame.setLayout(new GridLayout(1, 3));
		//.setBackground(Color.ORANGE);
		p2.setLayout(new GridLayout(4, 1));
		p2.add(lb1);
		
		frame.add(pp1, "West");
		frame.add(p2, "Center");
		frame.add(p1, "East");
		frame.setLocation(350, 250);
		frame.setLocation(300, 250);	
		frame.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == bb1) {
			frame2.setVisible(true);
			
			String messege = ">> ID, PW, NAME�� �Է��ϰ� ���ϷḦ ��������";
			lb1.setText(messege);
		}
		if (e.getSource() == b1) {
			id = tf1.getText();
			pwd = tf2.getText();
			name = tf3.getText();
			user = new UserVO(id, pwd, name);
			try {
				biz.register(user);
				lb2.setText(">>1�� �Է¿Ϸ�");
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		if (e.getSource() == bb2) {
			String messege = ">> ID, PW, NAME�� �Է��ϰ� ���ϷḦ ��������";
			lb1.setText(messege);
		}
		if (e.getSource() == b2) {
			id = tf1.getText();
			pwd = tf2.getText();
			name = tf3.getText();
			user = new UserVO(id, pwd, name);
			try {
				biz.modify(user);
				lb2.setText(">>1�� �����Ϸ�");
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		if (e.getSource() == bb3) {
			String messege = ">> ������ ID �Է��ϰ� ���ϷḦ ��������";
			lb1.setText(messege);
		}
		if (e.getSource() == b3) {
			String id = tf1.getText();
			try {
				biz.remove(id);
				lb2.setText(">>1�� �����Ϸ�");
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		if (e.getSource() == bb4) {
			String messege = ">> ��ȸ �� ID �Է��ϰ� ���ϷḦ ��������";
			lb1.setText(messege);
		}

		if (e.getSource() == b4) {
			String id = tf1.getText();
			try {
				user = biz.get(id);
				lb2.setText(">>1�� ��ȸ�Ϸ�: " + user.getId() + " " + user.getPwd() + " " + user.getName());

			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		
		if (e.getSource() == bb5) {
			try {
				lb1.setText(">> ���ϷḦ ��������");
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}

		if (e.getSource() == b5) {
			try {
				alist.removeAll();
				list = biz.get();
				lb2.setText(">> ��� ��ȸ�Ϸ�");
				for (UserVO u : list) {
					alist.add(u.getId());
				}

			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}

}
