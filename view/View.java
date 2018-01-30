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
public class View implements ActionListener {

	Frame frame;
	Panel p1, p2, p3, p4, p5;
	Button b1, b2, b3, b4, b5, b6;
	TextField tf;
	Label label, label2;
	List alist;
	ArrayList<UserVO> list;
	UserVO user;
	String id;
	String pwd;
	String name;
	UserBiz biz;

	public View() {
		frame = new Frame();
		p1 = new Panel();
		p2 = new Panel();
		p3 = new Panel();
		p4 = new Panel();
		p5 = new Panel();

		b1 = new Button("ȸ�� ���� �Ϸ�");
		b2 = new Button("�������� ���� �Ϸ�");
		b3 = new Button("�������� ���� �Ϸ�");
		b4 = new Button("ȸ�� ��ȸ �Ϸ�");
		b5 = new Button("�� ȸ�� ��ȸ �Ϸ�");
		b6 = new Button("��");

		tf = new TextField(50);
		label = new Label(">> ȸ������ (ID, PWD, �̸�) �� �Է��ϼ���.");
		label2 = new Label("Result >>");
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
				label2.setText(">> ID, ���, �̸�: "+result);
			}
		});

		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		
		frame.setSize(600, 400);
		frame.setBackground(Color.BLACK);
		frame.addWindowListener(new WindowAdapter() {
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
		/* p1.add(b6); */

		p2.setBackground(Color.ORANGE);
		p2.setLayout(new GridLayout(4, 1));
		p2.add(label);

		p2.add(tf);

		p2.add(alist);
		p2.add(label2);

		/*
		 * p2.add(p3); p2.add(p4); p2.add(p5);
		 */
		frame.setLayout(new GridLayout(1, 2));
		frame.add(p2);
		frame.add(p1);
		frame.setLocation(350, 250);
		frame.setVisible(true);
	}

	/*
	 * public void IdInsert() { String idInsert = ">> ID�� �Է��ϰ� ���� ��������";
	 * label.setText(idInsert); id = tf.getText(); tf.setText(""); } public void
	 * PwdInsert() { String pwdInsert = ">> ��й�ȣ�� �Է��ϰ� ���� ��������";
	 * label.setText(pwdInsert); pwd = tf.getText(); tf.setText(""); } public void
	 * NameInsert() { String nameInsert = ">> �̸��� �Է��ϰ� ���� ��������";
	 * label.setText(nameInsert); name = tf.getText(); tf.setText(""); }
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == b1) {
			String s = tf.getText();
			String[] arr = s.split(" ");
			id = arr[0];
			pwd = arr[1];
			name = arr[2];
			user = new UserVO(id, pwd, name);
			try {
				biz.register(user);
				label2.setText(">>1�� �Է¿Ϸ�");
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}

		if (e.getSource() == b2) {
			String s = tf.getText();
			String[] arr = s.split(" ");
			id = arr[0];
			pwd = arr[1];
			name = arr[2];
			user = new UserVO(id, pwd, name);
			try {
				biz.modify(user);
				label2.setText(">>1�� �����Ϸ�");
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}

		if (e.getSource() == b3) {
			String id = tf.getText();
			try {
				biz.remove(id);
				label2.setText(">>1�� �����Ϸ�");
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}

		if (e.getSource() == b4) {
			String id = tf.getText();
			try {
				user = biz.get(id);
				label2.setText(">>1�� ��ȸ�Ϸ�: " + user.getId() + " " + user.getPwd() + " " + user.getName());

			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}

		if (e.getSource() == b5) {
			try {
				alist.removeAll();
				list = biz.get();
				label2.setText(">>��� ��ȸ�Ϸ�");
				for (UserVO u : list) {
					alist.add(u.getId());
				}
				

			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}

}
