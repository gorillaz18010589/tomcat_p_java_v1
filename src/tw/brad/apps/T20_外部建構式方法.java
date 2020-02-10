package tw.brad.apps;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class T20_外部建構式方法  extends JFrame  { //直接內部實作這張ActionListener
	JButton b1,b2,b3;
	JTextArea text;
	public T20_外部建構式方法  () { //建構式
		super("這是我的程式");
		
		//三個按鈕置頂
		setLayout(new BorderLayout());
		JPanel top = new JPanel(new FlowLayout());
		b1 = new JButton("B1");
		b2 = new JButton("B2");
		b3 = new JButton("B3");
		top.add(b1);top.add(b2);top.add(b3);
		add(top,BorderLayout.NORTH);
		
		//加入文字區域放中
		JTextArea text = new JTextArea();
		 add(text,BorderLayout.CENTER);
		 
		//用建構是方法呼叫
		 MyListener1 listen = new  MyListener1(b1,b2,b3); //把帶有參數的建構式物件實體化都入listen 
		 b1.addActionListener(listen); //代入各自的listen就可以已連到外部有button的建構式
		 b2.addActionListener(listen);
		 b3.addActionListener(listen);
		 
		setSize(680, 460);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		 
	} 
			
			
	
	public static void main(String[] args) {
		new T20_外部建構式方法  ();
	}
}
 
class MyListener1 implements ActionListener{
	private	JButton b1,b2,b3;
	//(1)以建構是方式讓人加叫的方法
	public MyListener1(JButton b1, JButton b2, JButton b3) {
		this.b1 = b1; this.b2 = b2; this.b3 = b3; //叫到時把叫到的存入b1
	}
	//(2)如果叫到各自的案件各自表現
	public 	void actionPerformed(ActionEvent e) {
		if(e.getSource() == b1) {
			System.out.println("這是b1");
		}else if(e.getSource() == b2) {
			System.out.println("這是b2");
		}else if(e.getSource() ==b3) {
			System.out.println("這是B3");
		}else {System.out.println("都沒抓到");}
	}
	 
	
 }

