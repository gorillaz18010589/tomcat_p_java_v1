package tw.brad.apps;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class T20_直接overrider事件方法  extends JFrame implements  ActionListener { //直接內部實作這張ActionListener
	JButton b1,b2,b3;
	JTextArea text;
	public T20_直接overrider事件方法  () { //建構式
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
		 
		 
		 //按下按鈕直接動作頃聽者,(裡面放入動作頃聽者)因為是抽象類別,寫我要的override
		 //內部內別方法:適合只有一個事件,如果兩個事件以上找條電器比較好
		 b1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("按鈕直接反映");
				m1(); //直接呼叫我的m1()方法
			}
		});
		 
		setSize(680, 460);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	} 
	
	public void m1() { 
		for (int i=0; i<=10; i++) {
			System.out.println("雅惠我愛你");
		}
	}
	
	public static void main(String[] args) {
		new T20_直接overrider事件方法  ();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
 


