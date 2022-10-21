import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;


public class MyFrame extends JFrame implements ActionListener{
	
	public static boolean testBooleanFraGUI;
	
	JButton button;
	
	MyFrame() {
		
		button = new JButton();
		button.setBounds(100, 100, 250, 100);
		button.addActionListener(e -> testBooleanFraGUI=true);
		button.setText("Hopp!");
		button.setFocusable(false);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setSize(500, 500);
		this.setVisible(true);
		this.add(button);
	}
	
	
}
