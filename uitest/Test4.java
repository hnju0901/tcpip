package uitest;

import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Test4 implements ActionListener{

	Frame frame;
	Panel p1, p2, p3, p4;
	Button b1,b2;
	TextField tf1;
	Label label;
	public Test4() {
		frame = new Frame();
		p1 =new Panel();
		p2 =new Panel();
		p3 =new Panel();
		p4 =new Panel();
		b1 = new Button("Button 1");
		b2 = new Button("Button 2");
		tf1 = new TextField(10);
		label = new Label("Result : ");
	}
	public void makeUi() {
		b1.addActionListener(this);
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
		
		
		p1.setBackground(Color.LIGHT_GRAY);
		p1.setLayout(new GridLayout(2,1));
		
		
		/*p1.add(tf1);
		p1.add(b1);	*/
		
		p3.add(tf1);
		p4.add(b1);	
		p1.add(p3);
		p1.add(p4);
		
		//panel.add(b2);
		p2.setBackground(Color.ORANGE);
		p2.add(label);
		frame.setLayout(new GridLayout(2,1));
		
		frame.add(p1, "North");
		frame.add(p2, "South");
		frame.setLocation(500, 350);
		frame.setVisible(true);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==b1) {
			String s = tf1.getText();
			tf1.setText("");//가져온 다음 비워줌
			label.setText("Result : "+s);
		}
		
	}
}
