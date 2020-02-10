package tw.brad.apps;
//目標新增mouseListenr =>當滑鼠在textArea 移動時抓的到
//事情發生在textArea找他的api
//找AddListene跟滑鼠有關的慢慢看,自己沒有看爸爸祖先
//Component=>addMouseListener 新增滑鼠頃聽者滑鼠點擊)
//Component=>addMouseMotionListener :新增滑鼠移動頃聽者(滑鼠移動)
//MouseListener =>mouseClicked(MouseEvent e) :一次性的點擊放開
//MouseListener =>mousePressed(MouseEvent e) :按下去就觸發
//MouseListener =>mouseReleased(MouseEvent e) :放開時觸發
//滑鼠移動事件
//MouseMotionListener =>mouseDragged(MouseEvent e):
//MouseMotionListener =>mouseMoved(MouseEvent e):
//*發現滑鼠頃聽者,跟滑鼠移動頃聽者:總共有7個證照要考,用this這招要寫7個實作太麻煩
//所以改用MouseListener =>以實作方法MouseAdapter (條電器插座)
//電壓不同但都是電,這些都是滑鼠相關,經過條電器換成你要的
//發現電壓器有時座這三個implements MouseListener, MouseWheelListener, MouseMotionListener但類別是抽象等我做選擇我要的來做
//他裡面方法都有了,那就繼承
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

public class T20_Mouse事件  extends JFrame  { //直接內部實作這張ActionListener
	JButton b1,b2,b3;
	JTextArea text;
	public T20_Mouse事件  () { //建構式
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
		 
		
		//文字區域委託頃聽者觸發mouse事件
		 Mymouse m = new Mymouse();
		 text.addMouseListener(m);
		 text.addMouseMotionListener(m);
		 
		setSize(680, 460);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		 
	} 
	
	public static void main(String[] args) {
		new T20_Mouse事件  ();
	}
}

	class Mymouse extends MouseAdapter{
		@Override
		public void mousePressed(MouseEvent e) {
			System.out.println("按下Pressed成功");
			
		}
		
		@Override
		public void mouseDragged(MouseEvent e) {
			System.out.println("托物片成功Dragged");
//			System.out.println(e.getPoint()); //抓座標回傳X,Y
			System.out.println(e.paramString());
			
		}
	}
 
