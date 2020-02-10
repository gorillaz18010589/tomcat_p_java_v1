package app;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.security.auth.PrivateCredentialPermission;
import javax.swing.JButton;
import javax.swing.JFrame;

//(1)我要寫建構式外觀在我初始化時表現
	//container =>add(Component comp): Component才能進來
	//jfram => setLayout(LayoutManager manager):版面配置  讓 LayoutManager設計師來配置版面
	//LayoutManager 是Interface(規格的) 所以方法要實作考過才是
	//但下面有直接時做的完成的All Known Implementing Classes:
	//挑了flow layout這個主管時做 看一下建構式
	//到Jbuuton看一下發現他的祖先是Component 所以到時可以add近來
	//JButton(String text):建構式改按鈕明子
	// FlowLayout() =>適度調整RWD效果讓各個按鈕可以擺上去
public class Hrad20_視窗程式實作  extends JFrame{
	
	private JButton b1,b2,b3; //封裝屬性不要給人改
		public Hrad20_視窗程式實作 () { //建構式初始化
			super("從JFrame(String title)用這招建構式");
			//(2)請室內設計師出來,把按鈕配置進
//			FlowLayout Layout = new FlowLayout(); //宣告一個flowlayout設計師叫layout,但因為我只叫他做這是沒有要給大家用不重要
			setLayout(new FlowLayout()); //需要一個layout設計師我找Flowlayout放進去
			b1 = new JButton("B1"); //你只是買了一張椅子但還沒說你要加進去
			b2 = new JButton("B2");
			b3 = new JButton("B3");
			add(b1);add(b2);add(b3); //把三個按鈕加進畫面
//			(1)做出視窗
			setSize(640, 480);
			setVisible(true);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
		}
		
	public static void  main(String[] args) {
		new Hrad20_視窗程式實作(); //呼叫一個我寫好的建構式
	}

}
