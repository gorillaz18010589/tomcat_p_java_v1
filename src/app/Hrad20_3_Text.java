package app;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
///目標:按鈕置頂,下方文字區域
//JPanel(LayoutManager layout) =>建構式裝容器
//JTextArea() =>建構式文字區域 

public class Hrad20_3_Text extends JFrame {
	private JButton b1,b2,b3;
	private JTextArea text;
	public  Hrad20_3_Text () {
		super("我的視窗");
		
		//(2)三個按鈕容器至頂
		setLayout(new BorderLayout()); //呼叫版面經理來
		JPanel top = new JPanel(new FlowLayout()); //呼叫flow流水經理
		JButton b1 = new JButton("B1");//三個按鈕物件實體化
		JButton b2 = new JButton("B2");
		JButton b3 = new JButton("b3");
		top.add(b1); top.add(b2); top.add(b3); //在這個容起底下新增按鈕1,2,3
		add(top,BorderLayout.NORTH);//新增這個容器,版面配置在北方
		
		//(3)設置文字區域
		JTextArea text = new JTextArea();
		add(text,BorderLayout.CENTER);
		
		//(1)視窗建構
		setSize(680, 390);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new Hrad20_3_Text();

	}

}
