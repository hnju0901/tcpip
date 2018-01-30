package uitest;

import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
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

public class Test3 implements ActionListener{
//버튼이 여러개여서 implement한것//
	Frame frame;
	Panel p1, p2;
	Button b1,b2;
	TextField tf1;
	Label label;
	List alist;
	ArrayList<UserVO> list ;
	public Test3() {
		frame = new Frame();
		p1 =new Panel();
		p2 =new Panel();
		b1 = new Button("Button 1");
		b2 = new Button("Delete");
		tf1 = new TextField(10);
		label = new Label("Result : ");
		alist= new List();
		list = new ArrayList<>();
	}
	public void makeUi() {
		b1.addActionListener(this);
		b2.addActionListener(this);
		
		alist.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				int position = (int) e.getItem();
				alist.getItem(position);
				//System.out.println(e.getItem());//
				//arraylist의 위치를 나타냄//
				UserVO user = list.get(position);
				String result = user.getId()+" "+user.getPwd()+" "+user.getName();
				label.setText(result);
			}
		});
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				frame.dispose();
				//여기서 frame대신 this로 쓰면 this는 WindowAdapter을 의미한다.//
			}
		});
		frame.setSize(300, 200);
		frame.setBackground(Color.PINK);
		frame.setTitle("New Window");
		
		
		p1.setBackground(Color.pink);
		p1.add(tf1);
		p1.add(b1);
		p1.add(b2);
		
		//panel.add(b2);
		p2.setBackground(Color.ORANGE);
		p2.add(label);
		//=================================
		getData();
		//=================================
		frame.add(p1, "North");
		frame.add(p2, "South");
		frame.add(alist, "Center");
		frame.setLocation(500, 350);
		frame.setVisible(true);
		
	}
	private void getData() {
		list.clear();
		alist.removeAll();
		list.add(new UserVO("id", "일본", "오사카"));
		list.add(new UserVO("id2", "일본", "교토"));
		list.add(new UserVO("id3", "일본", "아리마"));
		list.add(new UserVO("id4", "미국", "볼티모어"));
		list.add(new UserVO("id5", "미국", "샌디에고"));
		list.add(new UserVO("id6", "스페인", "세비아"));
		for(UserVO u : list) {
			alist.add(u.getId()+" "+u.getName());
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==b1) {
			String s = tf1.getText();
			tf1.setText("");//가져온 다음 비워줌//
			label.setText("Result : "+s);
		}
		else if(e.getSource()==b2) {
			int index = alist.getSelectedIndex();
			list.remove(index);
			//데이터를다시 출력한다.
			getData();
		}
		
	}
}
