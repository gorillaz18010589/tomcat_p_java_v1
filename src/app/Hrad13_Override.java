
package app;
public class Hrad13_Override {
	public static void main(String[] args) {
		//用方法的方式不是建構式,Overrride使用
		//以下兩7.8行是 Overrride的實際應用
//	Hrad132 obj1 = new Hrad132(); 
//	obj1.m1(); 
		
		//多型的使用
		//宣告為什麼你就只看的到那些方法,但實作要看你骨子裡的東西
//		Hrad131 obj1 = new Hrad131(); 	//我要一台爸爸的車子,你給我爸爸的車子	=>OK
//		Hrad132 obj2 = new Hrad132();	//我要一台兒子的法拉利,你給兒子的法拉利 =>OK
//		Hrad131 obj3 = new Hrad132();	//我要一台爸爸的車子,你給我兒子的法拉利 =>OK
//		Hrad132 obj4 = new Hrad131();	//我要一台兒子的法拉,你卻給我爸爸的車子 =>不行
		
//		obj1.=>宣告車子  x 拿到車子       	 =>   看到爸爸車子的m1(),m2()     
//		obj2.=>宣告法拉利x 拿到法拉利 	 =>   看到兒子法拉利的m1(),m2(),m3()
//		obj3.=>宣告車子  x 拿到法拉利	 =>   看到爸爸車子的m1(),m2()方法 ,但是踩下去是法拉利的速度
//		obj3.m1(); //所以看到爸爸車子的方法,但踩下去是兒子法拉利Hrad132:m1()
		//因為你當時要的是一台車,但他給你法拉利,你看到的是車,所以只有車的方法,你玩不到法拉利的m3();
		
		//多行怪獸使用 =>壞人由父類別定義,個字的技能跟型為由兒子改寫
		Hrad131 obj1 = new Hrad131(); 	
		Hrad132 obj2 = new Hrad132();	
		Hrad133 obj3 = new Hrad133();
		
		//強制轉換
//		Hrad131 obj3 = new Hrad133(); 叫車子只有m1,m2方法
//		Hrad133 obj4 = (Hrad133)obj3; 創造obj4把 本來叫hrad133方法的叫車子,直接改車叫車子就能看到 133的m1-m4(方法)
		//一起呼叫怪獸方式
		test(obj1); //Hrad131:m1(電擊)
		test(obj2); //Hrad132:m1(水柱)
		test(obj3); //Hrad133:m1(火球)
	}
	
	static void test(Hrad131 obj) { //全部都用繼承131所以有繼承131的怪獸都叫的到,131怪獸都會攻擊,但攻擊的方式看你自己的招式
		obj.m1(); //所有test(obj1);test(obj2);test(obj3); 三種怪獸都會用m1(攻擊),但看你自己的招式
	}
}
//		Overrride方法介紹以下
//(1)你寫的方法兒子類別,與爸爸類別名子跟參數都一樣,代表你想Overrride
//(2)為什要改寫,因為我要發揚光大,既然是發揚光大,既然要改寫你怎麼會改私人不合理
//(3)既然要發揚光大,爸爸沒存取修飾字,你private的化就沒有發揚光大了,不合理
//(4)所以爸爸是 void m1(),兒子最少也要一樣 void 沒有存取修飾字一樣,或是大於用public跟protected
//(5)你現在講的是發揚光大,但目前做出來,是否定爸爸所以通常來說會加上super.m1();
//(6)做了super.m1();,在做System.out.println("Hrad132()");這樣的邏輯才比較符合發揚光大
//(7)overriide,爸爸void 兒子也要一樣void出去,重點改的是內容,進來的基本型本跟出去要一樣包含輸入的參數,跟return的型別
//(8)因為是原方法,包含了近來出去,所以你一樣的進來,一樣的出去,只是內容邏輯不同,所以基本型別上面要一模一樣

class Hrad131{
	void m1() {System.out.println("Hrad131:m1(電擊)");} //爸爸目前式沒有存取修飾字
	void m2() {System.out.println("Hrad131:m2()");}
}

class Hrad132 extends Hrad131{
	
//	private void m1() {  //爸爸是沒有存取修飾字,你兒子用private沒有發揚光大不行
//	public void m1() {  有發揚光大可以 public>沒有存取修飾字
//	protected void m1() { //有發揚光大可以 protected>沒有存取修飾字
		void m1() { //跟爸爸一樣也可以
//			super.m1(); //邏輯上來說先叫爸爸的事情,再做下面兒子的事情才叫發揚光大
//			super.m2(); //你要叫爸爸的m2()方法也可以
			System.out.println("Hrad132:m1(水柱)");
//			super.m1(); 再方法來說 super.m1()這個叫爸爸的方法要放在哪邊都可以
	}
		//多刑後才加入M3方法,測試
		void m3() {System.out.println("Hrad132:m3()");}
		
}

class  Hrad133 extends Hrad131 {
	void m1() {System.out.println("Hrad133:m1(火球)");}
	
}