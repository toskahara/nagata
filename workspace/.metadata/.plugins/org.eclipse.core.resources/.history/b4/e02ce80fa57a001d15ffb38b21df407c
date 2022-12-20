import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class TextFieldExample extends JFrame implements ActionListener {
	
	public static void main(String[] args) {
		new TextFieldExample(); 
	}
	
	JTextField textField = new JTextField(20);
	JButton clearButton = new JButton("リセット");
	JButton OKButton = new JButton("OK");
	
	TextFieldExample() {
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
