package prec1;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;

public class Mywindow extends JFrame {
	String [] data = { "Encapsulation","Inheritance","Poly","Information"};
	public Mywindow() {
		setBounds(500,500,500,500);
		setTitle("½ºÀ®");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		
		JList <String> list = new JList <>(data);
		JComboBox <String> combo = new JComboBox(data);
		
		JPanel p = new JPanel();
		
		p.add(list);
		p.add(combo);
		
		add(p);
		
		setVisible(true);
	}
}
