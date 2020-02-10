package app;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
//JFrame(String title)建構式
		//setSize(width, height); (祖先window)
		//setVisible(b): (祖先window)
		//setDefaultCloseOperation(operation):(Jfarme)
		//setLayout(LayoutManager manager)(BorderLayout):布局 (Jfarme)
		//JButton(): JButton b1 =new JButton(); 建構是宣告一個按鈕
public class Hrad20 extends JFrame{
	public Hrad20 () { //以下是建構是要作的內容
		
		super("哈摟這是我的視窗");//Jfarme方法 建構是宣告視窗明子
//		FlowLayout Layout = new FlowLayout();
//		setLayout(new BorderLayout()); //叫出設置容器,裡面的實作是容器機領
		JPanel top =new JPanel(new FlowLayout()); //裡面要叫一個經理實作我叫 FlowLayout來做RWD效果top
		 JButton b1 =new JButton("B1"); //按鈕物件實體化明子叫B1
		 JButton b2 =new JButton("B2");
		 JButton b3 =new JButton("B3");
		 top.add(b1); top.add(b2); top.add(b3); //top容器增加 按鈕b1,b2,b
		 add(top,BorderLayout.NORTH); //新增一個top,把它容器位置設在上方
//		 add(b1,BorderLayout.NORTH);add(b2,BorderLayout.WEST);add(b3,BorderLayout.CENTER);//設置排版位置
//			add (top,BorderLayout.NORTH); //容器放在最上面
		//(1設定視窗)
		setSize(640, 480);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);//可是視窗做出來後關掉其實紅點還在跑必須做這件事
	}
	
	
	public static void main(String[] args) {
		new Hrad20(); //把Brad20()座號的建構式叫出來
	}

}

