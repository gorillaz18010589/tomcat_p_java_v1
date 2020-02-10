package tw.brad.apps;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class T20_內部class事件寫法  extends JFrame implements ActionListener { //直接內部實作這張ActionListener
	JButton b1,b2,b3;
	JTextArea text;
	public T20_內部class事件寫法  () { //建構式
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
		 
		//點下按鈕後呼叫方法
		b1.addActionListener(this); //自己的按鈕就是朕我自己,點下去就呼叫自己的方法
		b2.addActionListener(this);
		b3.addActionListener(this);
		
		 
		setSize(680, 460);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		 
	} //委託頃聽者 用內部類別方法actionPerformed(ActionEvent e) 唯一一張正片把她考出來
	 public void actionPerformed(ActionEvent e) { //這是實作的唯一要考的證照方法,他就是聽的人
				if (e.getSource() == b1) { //如果這個物件(e) getSource(出事了),出什麼事? 這個物件 == 跟b1物件相等的話
				System.out.println("I am B1");
			}else if (e.getSource() == b2) {
				System.out.println("I am B2");
			}else if (e.getSource() == b3) {
				System.out.println("I am B3");
			}
			
			System.out.println("OK:" + e.getActionCommand()); //抓到這個參數e.getActionCommand()得到這個點下去的字串
			}
	
	public static void main(String[] args) {
		new T20_內部class事件寫法  ();
	}


}
 
