package uitest;

import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Test {

	Frame frame;
	Button b1,b2;
	public Test() {
		frame = new Frame();
		b1 = new Button("Button 1");
		b2 = new Button("Button 2");
	}
	public void makeUi() {
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
		
		frame.add(b1);
		frame.add(b2);
		
		frame.setLocation(500, 350);
		frame.setVisible(true);
		
	}
}
