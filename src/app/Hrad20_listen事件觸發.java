package app;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

//目標:點下按鈕觸發事件效果
//要點的是按鈕先去看JButton
//想想按鈕可以被案祖先可以
//看到AbstractButton爸爸 => 	頃聽者()(ActionListener l):新增動作寢聽者
//addActionListener觀念:一般伺服器怎麼提供服務給你=>你跟他講,那要有人聽,才會服務你
//銀行你要先說地址(ip),到哪一個窗口(pot號網頁預設的話是80),窗口就是伺服器的概念座在那邊聽你說出要求,窗口後面要有addActionListener(頃聽者)
//所以按鈕按下去也要有一個addActionListener(頃聽者),才能
//addActionListener(ActionListener l)=>你新增一個頃聽者(ActionListener就是那個聽的人)
//點下聽的人ActionListener =>看一下他的方法找到actionPerformed(ActionEvent e) :行動執行(行動事件)
//都找好幫手後,在主程式外面寫一個頃聽者動作事件
//因為是Interface ActionListener 所以要用實作方法來處理
public class Hrad20_listen事件觸發 extends JFrame implements ActionListener {//我自己去考ActionListener證照,自己內部實作
	private JButton b1, b2, b3;
	private JTextArea text;
	
	public Hrad20_listen事件觸發(){
		super("我的視窗");
		
		//(2)三個按鈕容器至頂
		setLayout(new BorderLayout()); //呼叫版面經理來
		JPanel top = new JPanel(new FlowLayout()); //呼叫flow流水經理
		 b1 = new JButton("B1");//三個按鈕物件實體化
		 b2 = new JButton("B2");
		 b3 = new JButton("b3");
		top.add(b1); top.add(b2); top.add(b3); //在這個容起底下新增按鈕1,2,3
		add(top,BorderLayout.NORTH);//新增這個容器,版面配置在北方
		
		//(3)設置文字區域
		JTextArea text = new JTextArea();
		add(text,BorderLayout.CENTER);
		
		//(4)委託頃聽者
//		ActionListener Listener = new MyListener();//我宣告這個頃聽者,頃聽者是我派的人存入進去Listener 
//		b1.addActionListener( Listener); //新增動作頃聽者(Listener(派我的頃聽者放進去))
//		b2.addActionListener(Listener);
//		b3.addActionListener(Listener);
		
		//(6)因為已經搭配(5)這招自己考證照所以使用以下方法來委託頃聽者
		//add代表可以一個在新增一個在新增一個不會蓋掉,一個一個進來的感覺
		//set代表一個再換一個再換一個
		b1.addActionListener(this); //自己的按鈕就是朕我自己,點下去就呼叫自己的方法
//		b1.addActionListener(Listener); //這個是add的效果,它可以增加多個事件頃聽者,一個按鈕兩個人都有叫掉
		b2.addActionListener(this);
		b3.addActionListener(this);
		
		//(1)視窗建構
		setSize(680, 390);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	//(5)改用自己的class直接去考ActionListener,因為這招只有一招我不用另外寫,layout太多朝就不適合
	public void actionPerformed(ActionEvent e) { //這是實作的唯一要考的證照方法,他就是聽的人
	//(7)用souse方式判斷按下去是不是自己,有別於getActionCommand()
	
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
		new Hrad20_listen事件觸發(); 
	}

}
//(4)新增一個頃聽者動作內容設計,最初始的方法再創一個類別去考,之後用了(5)方法自己去考這邊就沒用了
//class MyListener implements  ActionListener{ //要看API因為 ActionListener是抽象,所以這邊要實作,把這個聽的人設計好存到mylistener
//	public void actionPerformed(ActionEvent e) { //這是實作的唯一要考的證照方法,他就是聽的人
////		actionPerformed(ActionEvent e)這個聽的人我並沒有呼叫他的方法,而是按下去後他委託 (ActionEvent e)產生事件所以玩得是這個ActionEvent e參數
//		System.out.println("OK:" + e.getActionCommand()); //抓到這個參數e.getActionCommand()得到這個點下去的字串
//	}
//}