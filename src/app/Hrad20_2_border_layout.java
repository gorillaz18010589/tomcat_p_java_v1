package app;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

//bordelayout 有implements LayoutManager2, Serializable
//但是extends LayoutManager 但是依樣有繼承可以玩到不影響
//setLayout(Border manger)
//bordelayout =>東南西北中 ,天地叫南跟北(天地是最大滿版寬),東,西(是在天地之間)
//bordelayout=> 的東南西北 適用static方法 所以用borderlayout.WEST以此類推
public class Hrad20_2_border_layout extends JFrame {
	private JButton b1,b2,b3; //封裝屬性不要給人改
	public  Hrad20_2_border_layout () { //建構式初始化
		super("從JFrame(String title)用這招建構式");
		
		//(2)請室內設計師出來,把按鈕配置進
		setLayout(new BorderLayout()); //需要一個layout設計師我找Bordelayout放進去
		b1 = new JButton("導覽列"); //你只是買了一張椅子但還沒說你要加進去
		b2 = new JButton("目錄");
		b3 = new JButton("首頁");
		add(b1,BorderLayout.NORTH);add(b2,BorderLayout.WEST);add(b3,BorderLayout.CENTER); //把三個按鈕加進畫面
		
		
//		(1)做出視窗
		setSize(640, 480);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
public static void  main(String[] args) {
	new Hrad20_2_border_layout(); //呼叫一個我寫好的建構式
}

}

	
	