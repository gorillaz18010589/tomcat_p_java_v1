package prictice;
//目的:玩Lexux是繼承Car爸爸的
//1.extends第一條概念:(可以玩父類別的方法)extends完全繼承了Car(爸爸)的方法,所以我Lexux目前沒寫任何方法,卻可以玩爸爸留下的方法
//*但因為extends目的是發揚光大,你什麼都沒寫,靠你爸爸叫做不長進
//2.extends發揚光大:在Lexux類別也新增了一個切換燈方法,跟取得燈是否開的狀態

public class Pank23_執行Lexux {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		//1.extends概念第一條:extends完全繼承了Car(爸爸)的方法,所以我Lexux目前沒寫任何方法,卻可以玩爸爸留下的方法,但因為extends目的是發揚光大,你什麼都沒寫,靠你爸爸叫做不長進
		Lexux l1 = new Lexux();
//		l1.upSpeed();
//		System.out.println(l1.getSpeed());
		
		//2.玩Lexux發揚光大的切換燈方法
		System.out.println(l1.isLight()); //false(因為初始值沒給預設是false)
		l1.switchLight();//切換燈關
		System.out.println(l1.isLight()); //true
	}

}
