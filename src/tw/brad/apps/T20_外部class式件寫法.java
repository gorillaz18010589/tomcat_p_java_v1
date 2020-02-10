package tw.brad.apps;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class T20_外部class式件寫法  extends JFrame {
	JButton b1,b2,b3;
	JTextArea text;
	public T20_外部class式件寫法 () { //建構式
		super("這是我的程式");
		setLayout(new BorderLayout());
		JPanel top = new JPanel(new FlowLayout());
		b1 = new JButton("B1");
		b2 = new JButton("B2");
		b3 = new JButton("B3");
		
		top.add(b1);top.add(b2);top.add(b3);
		add(top,BorderLayout.NORTH);
		
		JTextArea text = new JTextArea();
		 add(text,BorderLayout.CENTER);
		 
		 //委託頃聽者 呼叫外部class近來
		 ActionListener Listener = new MyActionListener(); 
		b1.addActionListener(Listener); //自己的按鈕就是朕我自己,點下去就呼叫自己的方法
		
		setSize(680, 460);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	
	public static void main(String[] args) {
		new T20_外部class式件寫法 ();
	}

}
 //建一個外部Class
class MyActionListener implements  ActionListener {
	public void actionPerformed(ActionEvent e) {
		 System.out.println("OK:");
		 System.out.println(e.getActionCommand());
		
	}
}
