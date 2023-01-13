import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class Bcc extends JFrame implements ActionListener {
	
	public static void main(String[] args) {
		new TextFieldExample(); 
	}
	
	JTextField textField = new JTextField(20);
	JButton clearButton = new JButton("リセット");
	JButton OKButton = new JButton("OK");
	
	void TextFieldExample() {
		getContentPane().setLayout(new FlowLayout());		
		getContentPane().add(textField);
		getContentPane().add(clearButton);
		getContentPane().add(OKButton);
		clearButton.addActionListener(this);
		OKButton.addActionListener(this);		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300, 100);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == clearButton) {
			textField.setText("");
		} else if(e.getSource() == OKButton) {
			System.out.println("値は[" + textField.getText() + "]です");
		}
	}
}
