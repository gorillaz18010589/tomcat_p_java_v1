package app;

public class Brad16 {

	public static void main(String[] args) {
		//抽象目的強迫多型
		//好處是我仍然保有我的方法,我m1寫得很好,你可以寫m2就好
		//建構式也可以用抽象
//		Brad161 obj = new Brad161(); Brad161爸爸是抽象,兒子要實作,因為抽象方法沒有辦法直接做出物件實體,等後代子孫把m2方法做出來
		
		//爸爸抽象,兒子跑車實作,所以方法是爸爸的方法,跑來起來是兒子的跑車
		Brad161 obj = new Brad162(); // 
		obj.m1(); obj.m2(); //印出162的m1()方法因為是用法拉利的實作
		System.out.println("================");
			
		//宣告爸爸 拿到跑車兒子	
		Brad162 obj2 = new Brad162();
		obj2.m1(); obj2.m2(); obj2.m3();
		
		Brad163 obj3 = new Brad163(2);
		obj3.m1(); obj3.m2(); obj3.m3();
		Brad161 obj12 = new Brad162();
		obj12.m1(); obj12.m2();
		Brad161 obj13 = new Brad163(3);
		obj13.m1(); obj13.m2();
	}

}
abstract class Brad161{
	Brad161(int a){} //一開始寫這件購是參數int兒子出現錯誤,因為兒子沒有寫建構是,所以回傳老爸的無傳參數建構是,但我沒有所以錯誤
	void m1() {System.out.println("Brad161:m1()");}
	abstract void m2() ;//有這個方法存在,此時不說抽象方法,不清不楚當然沒有物件實體
}

 class Brad162 extends Brad161{ //爸爸有抽象方法,所以前面加abstract可以這是方法1
	Brad162(){super(2);} //因為老爸有建構式參數,我也要補自己寫
	void m2() {System.out.println("Brad162:m2()");}
	void m3() {System.out.println("Brad162:m3()");}
}
class Brad163 extends Brad161 {
	Brad163(int a){super(2);}
	void m2() {System.out.println("Brad163:m2()");}
	void m3() {System.out.println("Brad163:m3()");}
}
abstract class Brad164 {
	void m4() {}
	void m5() {}
}