package app;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;


//目標,做出外部呼叫方法,與內部呼叫方法
public class  Hrad20_4_寫在外部class事件觸發 extends JFrame implements ActionListener {//我自己去考ActionListener證照,自己內部實作
	private JButton b1, b2, b3;
	private JTextArea textArea;
	
	public Hrad20_4_寫在外部class事件觸發() {
		super("Window Test");
		
		setLayout(new BorderLayout());

		JPanel top = new JPanel(new FlowLayout());
		b1 = new JButton("B1111");
		b2 = new JButton("B2222");
		b3 = new JButton("B3333");
		top.add(b1);top.add(b2);top.add(b3);
		
		add(top, BorderLayout.NORTH);
		
		textArea = new JTextArea();
		add(textArea, BorderLayout.CENTER);
		
		//事件觸發區域
		MyListener listener = new MyListener(b1, b2, b3);//建構式方式觸發外部方法
//		b1.addActionListener(this); 
		b1.addActionListener(listener);
//		b2.addActionListener(this);
//		b3.addActionListener(this);
		
		setSize(640, 480);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	//內部方法呼叫
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == b1) {
			System.out.println("I am B1");
		}else if (e.getSource() == b2) {
			System.out.println("I am B2");
		}else if (e.getSource() == b3) {
			System.out.println("I am B3");
		}
		
		System.out.println("OK2:" + e.getActionCommand());
	}
	
	public static void main(String[] args) {
		new Hrad20_4_寫在外部class事件觸發();
	}

}
	//外部方法呼叫當監聽到要做哪些事
class MyListener implements ActionListener { //外部實作
	private JButton b1, b2, b3; //這個類別設定三個按鈕
	public MyListener(JButton b1, JButton b2, JButton b3) { //建構式(放入參數)
		this.b1 = b1; this.b2 = b2; this.b3 = b3;
	}
	public void actionPerformed(ActionEvent e) {
		System.out.println("OK:" + e.getActionCommand());
		if (e.getSource() == b1) {
			System.out.println("ur B1");
		}else if (e.getSource() == b2) {
			System.out.println("ur B2");
		}else if (e.getSource() == b3) {
			System.out.println("ur B3");
		}
	}
}

