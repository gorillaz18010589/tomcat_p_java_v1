package myja;

public class Hrad25 extends Hrad24{ //(1)繼承24先不寫回到3號看
	//一開始我完全沒寫,建構式沒有寫所以拿了我爸爸public Hrad24() {}無傳參數的當作唯一建構式
	//*屬性方法有再繼承,"但建構式沒有",所以(int a)這爸爸的建構式,再Hrad03執行不認識
	//*第二步開始建構自己的建構式
	//1.overloaded=> 建構式名字一樣,但參數型別不同如下,同名異事,方法也可以
	
	public Hrad25() {
		//super()  System.out.println("Hrad24()"); 任何建構式第一道敘述句都會叫爸爸無傳參數的建構式回來之後才去做你的
		System.out.println("Hrad25()");
	}
	
	public Hrad25(int a) {
		//super()
		super(3,false); //正常來說會叫Hrad24(),但我直接呼叫爸爸的Hrad24(int a ,boolean b)所以第一個顯示的改這個
		System.out.println("Hrad25(int a)");
	}
}
