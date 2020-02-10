package app;

import javax.swing.JFrame;

public class Hrad15 extends JFrame { //繼承jframe視窗祖孫,這樣祖先的功能都有
	public Hrad15(){ //這時候用建構式,
		super("我的視窗"); //建構式方法 JFrame(String title)  用super()叫爸爸帶你要的參數方法
		setSize(640, 480); //做了一個視窗但沒顯示
		setVisible(true);  //把它顯示出來(不林值)
		//可是視窗做出來後關掉其實紅點還在跑必須做一件是如下
		setDefaultCloseOperation(EXIT_ON_CLOSE); //
	}
	
	public static void main(String[] args) {
		new Hrad15();
	}

}
