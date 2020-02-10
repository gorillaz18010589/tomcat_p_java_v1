package app;

public class Hrad17 {
			//目的:多形的概念同樣是172的車,我可以只要171的JAVA認證,也可只要173的Lenix認證
			// interface(介面)比抽象更抽象類似規格
			// (1)假設你要考過ocj1認證 跟ocj2認證那你就是java工程師
			// (2)所以你有這兩張證照那你就是
			// (3)但你實作的方法我完全不講,你自己去做有過就好方法看你實作
			// (4)我要求你有4張證照,你想辦法把4張證照實做出來,方法隨便你寫
			//因為規格訂出來就是要給人做的,所以要全世界的人來做,interface骨子裡的方法都是public只是沒寫出來
			//interface骨子裡還是類別,在我們生活事物裡面,有些名稱名詞代表的意義,有點像規格
			//規格如果穩和到那你就是什麼,考認證考兩張證照有符合,就算,考認證方法很多完成規格就可以
			//方法都是抽象方法不會有定義,不用寫抽象因為全部都是
			//拜託你全世界都來做,所以都是public方法
			
	public static void main(String[] args) {
		Hrad171 obj1 = new Hrad172(); //宣告171實作172 =>只看到m1()跟m2()的方法,實做看172車子
		obj1.m1(); obj1.m2();	
		System.out.println("=============");
		Hrad173 obj2 = new Hrad172(); //宣告173實作172 =>只看到m1()跟m2()的方法,實做看172車子
		obj2.m3(); obj2.m4();
	}
}
interface Hrad171{//interface(介面):規則肚子裡面東西都是抽象
	//因為規格訂出來就是要給人做的,所以要全世界的人來做,骨子裡都是public只是沒寫出來
	void m1(); //骨子裡都是abstract(抽象)
	void m2(); 
}

class Hrad172 implements  Hrad171,Hrad173{ //172實作171,173的抽象類別(實作的人想考171,173證照)
	
	//一個類別可以考很多個證照,例如考了171證照跟173證照
	//但一個類別只能有一個父親繼承
	public void m1() {System.out.println("Java認證執照A級");} //因為interface171肚子是抽象全世界都要公開要人做,存取修飾字是public,所以這邊也要發揚光大才行
	public void m2() {System.out.println("Java認證執照B級");}
	public void m3() {System.out.println("Lenix認證執照A級");}
	public void m4() {System.out.println("Lenix認證執照B級");}
}

interface Hrad173{
	void m3();
	void m4();
}