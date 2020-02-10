package app;

public class Hrad11_物件導向 {
	public static void main(String[] args) {
		//正常叫都會叫的到爸爸近來 ,除非你this(3)=>this(); 互叫叫來叫去爸爸沒時間近來,顯示錯誤
//		Hrad11 obj1 = new Hrad11(); //先呼叫Hrad11()發現裡面有this(3)代表呼叫本類別其他建構是有參數的,所以先印Hrad11(int a),再回來印自己
//		Hrad11 obj1 = new Hrad11(); //第二到新增this(3,4),所以呼叫11()時往下this(3)=>this(3,4)所以先做(int a, int b,在座int a,最後回來第一句
		System.out.println("=========================");
		
		//一開始繼承後沒有建構式會找父類別沒有回傳參數的建構式為為一件購式
		//Hrad112(){}建構式出現後,會先把祖宗八代叫玩,才換你
		//不管你玩幾代祖宗都會進來,你只需要管道上一代舊好,剩下的式你爸爸會做
//		System.out.println(Hrad112.a); //因為式static int a; 這個類別人共同傭有,所以這屬性大家都看的到,印的出來
//		Hrad112 obj2 = new Hrad112(); //因為剛開始沒建構式只有class,直接拿爸爸沒傳參數的Hrad11()來玩,所以一樣3,2,1句
//		System.out.println(obj2.a);
		
		
		//建構是一個物件只會做一次,所以這個類別被創出3個物件實體
//		System.out.println(Hrad112.a);//一開始還沒進去件夠式所以0
//		Hrad112 obj2 = new Hrad112(); //進來便1
//		Hrad112 obj3 = new Hrad112(); //進來便2
//		Hrad112 obj4 = new Hrad112(); //進來便3
//		System.out.println(Hrad112.a);  //進去三次建構式 a=3
		
		//{}
		//int b =0; 還沒建構式就出現屬性0
		//物件在你new的時候屬性跟物件早就做好了,所以還沒建構式也出現0屬性
		//建構式其實只是進行物件的初始化的動作,物件早就再了
//		Hrad112 obj1 = new Hrad112(); //爸爸門進來後{}比112()快 ,在建構式之前先被做
//		Hrad112 obj2 = new Hrad112(); 
		
//		Hrad112 obj1 = new Hrad112(); //物件一樣早就做好,所以第一個111{}出現,再來叫爸爸,再來112的{},最後式自己的112()
		
		//加上static {}
		//叫了obj1跟obj2 但static Hrad112{*}只出現一次而且是第一個
		//你只要輸入brad112,你說你要玩這個類別,他無論如何都會幫我載入記憶體
		//所以static就是你需要這個,我全部類別直接載入記憶體
		//類似math.random 一訂有static,讓他把math類別全部載入進去
		//你叫你112物件但爸爸的static方法也會載入因為爸爸的鮮才換你
		//static的事早就完成,再來才輪到你們,重點事載入這個類別
		//static千萬不要濫用,因為全域性很夠,但記憶體吃比較兇
		Hrad112 obj1 = new Hrad112();
//		Hrad112 obj2 = new Hrad112();
//		System.out.println(Hrad112.a); //連物件都沒有做出來,static Hrad112{*}卻還是有且第一個

	}
}

class Hrad11{
	Hrad11(){
		this(3);
		System.out.println("Hrad11()");
	}
	Hrad11(int a){
		this(3,4); //(2)第二部加的
		System.out.println("Hrad11(int a)");
	}
	Hrad11(int a, int b){
		System.out.println("Hrad11(int a, int b)");
	}
	{	
		System.out.println("Hrad111{*}"); //這塊會先做,因為物件早就存在了
	}
	static{	 //爸爸梅沒有呼叫,但式爸爸也出現static因為 爸爸先做你才做
		System.out.println("static Hrad111{*}");
	}
}
class Hrad112 extends Hrad11 { //繼承11
	//一開始繼承後沒有建構式會找父類別沒有回傳參數的建構式為為一件購式
	static int a; //a沒給值式0,static的化式class的人都會看的到,所有成員共同傭有的屬性
	int b;
	Hrad112(){
		a++; //任何建構式至少會做一次,只有再坐的那一次會++
		
		System.out.println("Hrad112()");
	}
	
	{	//一塊程式區塊寫在這,這次{}沒名字,但寫在class類別中,裡面一樣可以寫程式
		//爸爸進來後還沒做到112建構式,這塊會先被做才做112()
		System.out.println("Hrad112{*}"+b);
	}
	
	static{	 
		System.out.println("static Hrad112{*}");
	}
}