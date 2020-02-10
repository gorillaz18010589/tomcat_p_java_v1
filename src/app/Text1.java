package app;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

//bordelayout 有implements LayoutManager2, Serializable
//但是extends LayoutManager 但是依樣有繼承可以玩到不影響
//setLayout(Border manger)
//bordelayout =>東南西北中 ,天地叫南跟北(天地是最大滿版寬),東,西(是在天地之間)
//bordelayout=> 的東南西北 適用static方法 所以用borderlayout.WEST以此類推
public class Text1 extends JFrame {
	
	public Text1 () { //建構式初始化
		super("從JFrame(String title)用這招建構式");
	
		
		BorderLayout bLayout = new BorderLayout();
		setLayout(bLayout);
		JButton b1 = new JButton("北");	b1.setBackground(Color.red);
		JButton b2 = new JButton("南");	b2.setBackground(Color.pink);
		JButton b3 = new JButton("西");	b3.setBackground(Color.lightGray);
		JButton b4 = new JButton("東");	b4.setBackground(Color.orange);
		JPanel top = new JPanel(new FlowLayout(0));
		JPanel bottom = new JPanel(new FlowLayout(2));
		top.add(b1);
		bottom.add(b2);
		bottom.add(b3);
		bottom.add(b4);
		
		add(top,bLayout.NORTH);
		add(bottom,bLayout.SOUTH);
		
		setSize(680, 480);
		setVisible(true);
		setDefaultCloseOperation(3);

		add(b3,bLayout.WEST);
		add(b4,bLayout.EAST);
		add(bottom,bLayout.SOUTH);
//		bottom.add(b3,BorderLayout.WEST);
//		bottom.add(b3,BorderLayout.EAST);
	}
	
public static void  main(String[] args) {
	new Text1(); //呼叫一個我寫好的建構式
}

}

	
	