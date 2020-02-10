package app;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Hrad20_1版面配置2 extends JFrame {
	Hrad20_1版面配置2(){ //建構是設定方法
		JPanel top =new JPanel(new FlowLayout()); //JPanel(LayoutManager layout) 容器的概念
		JButton b2 = new JButton("目錄");
		JButton b3 = new JButton("內容");
		JButton b4 = new JButton("按鈕一");
		JButton b5 = new JButton("按鈕二");
		JButton b6 = new JButton("按鈕三");
		 
		top.add(b4); top.add(b5); top.add(b6); //新增按鈕在Jpanel容器裡面
		
		add(top,BorderLayout.NORTH); //把容器裡的三個按鈕放在北邊
		add(b2,BorderLayout.WEST);
		add(b3,BorderLayout.CENTER);
		
		setSize(740, 480);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	
	public static void main(String[] args) {
		new Hrad20_1版面配置2();

	}

}
