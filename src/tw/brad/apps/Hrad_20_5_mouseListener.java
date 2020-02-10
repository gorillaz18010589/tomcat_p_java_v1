package tw.brad.apps;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.dnd.MouseDragGestureRecognizer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
//目標新增mouseListenr =>當滑鼠在textArea 移動時抓的到
//事情發生在textArea找他的api
//找AddListene跟滑鼠有關的慢慢看,自己沒有看爸爸祖先
// Component=>addMouseListener 新增滑鼠頃聽者滑鼠點擊)
// Component=>addMouseMotionListener :新增滑鼠移動頃聽者(滑鼠移動)
//MouseListener =>mouseClicked(MouseEvent e) :一次性的點擊放開
//MouseListener =>mousePressed(MouseEvent e) :按下去就觸發
//MouseListener =>mouseReleased(MouseEvent e) :放開時觸發
//滑鼠移動事件
// MouseMotionListener =>mouseDragged(MouseEvent e):
// MouseMotionListener =>mouseMoved(MouseEvent e):
//*發現滑鼠頃聽者,跟滑鼠移動頃聽者:總共有7個證照要考,用this這招要寫7個實作太麻煩
//所以改用MouseListener =>以實作方法MouseAdapter (條電器插座)
//電壓不同但都是電,這些都是滑鼠相關,經過條電器換成你要的
//發現電壓器有時座這三個implements MouseListener, MouseWheelListener, MouseMotionListener但類別是抽象等我做選擇我要的來做
//他裡面方法都有了,那就繼承
public class Hrad_20_5_mouseListener extends JFrame implements ActionListener{
	private JButton b1, b2, b3;
	private JTextArea textArea;
	
	public Hrad_20_5_mouseListener() {
		super("Window Test");
		
		setLayout(new BorderLayout());

		JPanel top = new JPanel(new FlowLayout());
		b1 = new JButton("B1111");
		b2 = new JButton("B2222");
		b3 = new JButton("B3333");
		top.add(b1);top.add(b2);top.add(b3);
		
		add(top, BorderLayout.NORTH);
		
		textArea = new JTextArea();
		add(textArea, BorderLayout.CENTER);
		
		//按鈕事件觸發區域
		MyListener listener = new MyListener(b1, b2, b3);
//		b1.addActionListener(this); b1.addActionListener(listener);
//		b2.addActionListener(this);
//		b3.addActionListener(this);
		
		//(最後) =>內部內別方法:適合只有一個事件,如果兩個事件以上找條電器比較好
		b1.addActionListener(new ActionListener() {//直接當你按下b1按鈕做下面這些事
				@Override
			public void actionPerformed(ActionEvent e) {
			System.out.println("最快方法addActionListener(new ActionListener())");
				
			}
		});
		
		b2.addActionListener(new ActionListener() { //當b2按鈕按下做以下事情
					@Override
			public void actionPerformed(ActionEvent e) {
				m1(); //呼叫我的m1方法
				for(int i=0; i<=10; i++) { //按下按鈕呼叫跑10圈呼叫10刺
					m1();
				}
			}
		});
		
		//委託事件頃聽者
		MyMouseListener MouseListener = new MyMouseListener();
		textArea.addMouseListener(MouseListener);
		textArea.addMouseMotionListener(MouseListener);
		
		//設定視窗尺吋
		setSize(640, 480);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	//內部實作區按鈕觸發事件
	public void actionPerformed(ActionEvent e) {
			if (e.getSource() == b1) {
			System.out.println("I am B1");
		}else if (e.getSource() == b2) {
			System.out.println("I am B2");
		}else if (e.getSource() == b3) {
			System.out.println("I am B3");
		}
		
		System.out.println("OK2:" + e.getActionCommand());
	}
	void m1() { //這邊示範可以在此打多行,按鈕按下去呼叫就好簡單明瞭
		System.out.println("竟然你誠心的發文");
		System.out.println("我就大發慈悲德告訴你");
		System.out.println("我們是穿梭在銀行的火箭隊!!");
	}
	
	//呼叫我的建構式
	public static void main(String[] args) {
		new  Hrad_20_5_mouseListener();
	}

}


//外部實作按鈕觸發事件
class MyListener implements ActionListener {
	private JButton b1, b2, b3;
	public MyListener(JButton b1, JButton b2, JButton b3) {
		this.b1 = b1; this.b2 = b2; this.b3 = b3;
	}
	public void actionPerformed(ActionEvent e) {
		System.out.println("OK:" + e.getActionCommand());
		if (e.getSource() == b1) {
			System.out.println("ur B1");
		}else if (e.getSource() == b2) {
			System.out.println("ur B2");
		}else if (e.getSource() == b3) {
			System.out.println("ur B3");
		}
	}
}

//滑鼠事件頃聽者,抽象類別漂亮的地方,三個事件都時做好了,但class抽象 肚子悾悾 你自己選你要做的去改寫
class MyMouseListener extends MouseAdapter{ //因為他雖然有時做但她肚子其實是空的等我Override
	@Override  
		public void mousePressed(MouseEvent e) {
//		super.mousePressed(e); 肚子本來就空
		System.out.println("Pressed點下去就觸發");
		}
	
	@Override
		public void mouseDragged(MouseEvent e) {
//			super.mouseDragged(e);
		System.out.println("Dragged當滑鼠拖行時");
		System.out.println(e.getPoint()); //印出滑鼠移動時的座標
		}
}


