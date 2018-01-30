package uitest;

import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Test2 implements ActionListener{
	//test2�� �̺�Ʈ�� ����Ű�ڽ��ϴ�. ��ư �� �Ѱ����� ������ ���Դϴ�.//
	Frame frame;
	Button b1,b2,b3,b4,b5;
	public Test2() {
		frame = new Frame();
		b1 = new Button("Button 1");
		b2 = new Button("Button 2");
		b3 = new Button("Button 3");
		b4 = new Button("Button 4");
		b5 = new Button("Button 5");
		//��ư�� �������̸� �̺�Ʈ�� test2�� �̾߱���//
		
	}
	public void makeUi() {
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		//��⼭ this�� �ڽ� �� class�ǹ�..//
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				frame.dispose();
				//���⼭ frame��� this�� ���� this�� WindowAdapter�� �ǹ��Ѵ�.//
			}
		});
		frame.setSize(300, 200);
		frame.setBackground(Color.PINK);
		frame.setTitle("New Window");
		
		frame.add(b1, "East");
		frame.add(b2, "West");
		frame.add(b3, "South");
		frame.add(b4, "North");
		frame.add(b5, "Center");
		
		frame.setLocation(500, 350);
		frame.setVisible(true);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==b1) {
			b1.setBackground(Color.blue);
		}
		if(e.getSource()==b2) {
			b2.setBackground(Color.red);
		}
		if(e.getSource()==b3) {
			b3.setBackground(Color.cyan);
		}
		if(e.getSource()==b4) {
			b4.setBackground(Color.black);
		}
		if(e.getSource()==b5) {
			b5.setBackground(Color.pink);
		}
		
	}
}
