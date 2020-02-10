package app;

public class Hrad16 {
	//*因為你祖先抽象類別不清楚楚,所以我擺明就是要你後代子孫把方法做出來
	//abstract class一出來強迫後代子孫要實作他,強迫多形,大家都一樣的方法,但招式各有不同
	//抽象目的強迫多型,且保有爸爸的主要方法,還可以再子孫那邊多形m2()方法等
	//目的是我仍然保有我的方法,我m1寫得很好你拿去用呀,但我m2()抽象,你要把它做出來
	//建構式也可以用抽象,不能直接建構但也有建構式的存在
	
	public static void main(String[] args) {
//	Brad161 obj1 = new Brad161(); //因為161是抽象類別,肚子裡不清不楚,無法物件實體
	Trad162 obj2 = new Trad162();
	Trad163 obj3 = new Trad163(3); //因為有163建構式參數有設定float滿足需求
	obj2.m1(); obj2.m2();obj2.m3(); //Trad161:m1() Trad162:m2() 繼承爸爸無傳參數的m1()方法,跑自己的162m2方法跟162m3
	System.out.println("===========");
	obj3.m1();obj3.m2(); obj3.m3(); //Trad161:m1() Trad163:m2() 繼承爸爸無傳參數的m1()方法,跑自己的163m2方法跟163m3
	System.out.println("===========");
	
	//宣告與拿到不同示範
	Trad161 obj12 = new Trad162(); //宣告爸爸的車拿兒子的法拉利2代
	Trad161 obj13 = new Trad163(2); //宣告爸爸的車拿孫子的法拉利3代
	obj12.m1(); obj12.m2(); //只看的到爸爸的m1,m2()方法,但踩下去是法拉利二代的效果
	obj13.m1(); obj13.m2();//只看的到爸爸的m1,m2()方法,但踩下去是法拉利三代的效果
	
	}
 
}
	//抽象類別
abstract  class Trad161{//肚子有抽象方法,class這邊也要
	//建構式也可以抽象
	Trad161(int a){}  //一開始建構式爺爺放入參數其他人在哭,因為沒有其他無傳參數的建構式給兒子
	void m1() {System.out.println("祖父的大絕招");} //我仍然保有這個關鍵性方法,我m1()方法寫得好剩下兒子要把m2實做出來才可以用
	abstract void m2(); //肚子裡是abstract抽象方法,class也要是抽象方法,m2()方法兒子可以多形
}
	//162繼承161的抽象方法,因為爸爸肚子是抽象,你繼承所以也是抽象,有兩招解決辦法
	//(1)abstract class Brad162 extends Brad161{} :竟然爸爸是抽象類別,你肚子也是抽象類別,那就在你自己類別告訴大家你也是抽象
	//(2)把繼承的抽象方法"實做出來"爸爸建構式以下 (重點)
	//爸爸建構是有參數,沒有無傳參數的建構式那我配合爸爸
 class Trad162 extends Trad161{
	Trad162(){super(2);} //建構式裡面的叫爸滿足 (int a)
	void m2(){System.out.println("Trad162:m2()");} //把爸爸的抽象m1()方法實做出來
	void m3(){System.out.println("Trad162:m3()");}
}
 class Trad163 extends Trad161{
	 Trad163 (float b) {super(2);} //裡面的叫爸滿足需求 ,參數我自己玩OK
	 void m2() {System.out.println("Trad163:m2()");}
	 void m3() {System.out.println("Trad163:m3()");}
 }
 abstract  class Trad164{ //雖然我肚子裡沒有抽象方法,我可以宣稱我是抽象方法
	 //abstract 這種類別通常不想要物件實體
	 //因為要搭配多個介面
	 void m4() {}
	 void m5() {}
 }