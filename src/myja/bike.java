package myja;

public class bike extends Object{ //public代表全世界都可以對她存取,對外營業,原始檔跟檔名一模一樣,(沒有定義建構式,其實就是繼承object)
	//** has a member(成員) :obj.member 可以是屬性可以是方法後面用.家屬性方法名
	//double speed; 屬性Field ,通常定義命名首字大寫,屬性全小寫
	//設計類別都是從屬性開始,材搭配方法
	//設計類別要想提供什麼功能,不要想太多,不用去想用的人會需要甩尾嗎,設計越單純越好
	//速度屬性不給人看,外界要看用方法碼錶給你看
	//一個原始檔中,只能有一個class是public其檔案名稱要跟他一樣
//	private double speed; //"封裝"其中一種觀念,私有的讓外界看不到速度,只有在class bike{}內才擁有好
//	double speed; //沒有存取修飾字,相同packge可以去存取
	//public 對外營業方法讓大家都玩得到
	protected	double speed; //保護級,相同packge可以存取,繼承的兒子也可以拿去玩
	
	//**建構式(constructor)
	//**與class名稱一模一樣,也有存取修飾字,叫做建構式,長相不一樣就不是建構式
	//**目的:一開始建構初始化,你希望這個物件長什麼樣子,會做什麼方法,特徵在哪會在這裡定義
	//**與方法差異:方法會有傳回值,建構式永遠沒有傳回值
	//**當你bike加上(int a)參數後,其他兒子都在哭,因為一開始object是沒有回傳值,你定義要有,所以你為主,把其他呼叫加參數
	public bike(int a) {
		System.out.println("bike()");
	}
	
	//**方法(method)
//	public void bike() { 雖然class名稱一樣,但因為有void傳回值所以是方法,不是建構式
//		
//	}
	public void upSpeed() { //void不會做return傳回值
		 speed = speed<1 ? 1: speed*1.2;  //速度一開始是0 = 當速度<1時? 我讓他其值為1,否則的話你再踩的話就讓元素度*1.2
	 }
	 
	 public void downSpeed() {
		 speed = speed<1 ? 0: speed*0.7; //當速度小於1就變0,如果沒小於1就慢慢減速*0.7
	 }
	 //屬性不能給你改給你看,但我寫一個方法給你查速度,裝時速表
	public double getSpeed() { //這邊有加double因為傳回值 是double
		
		 return speed;
	 }
	 //繼承只是一個觀念,其實是延伸擴大,重點叫發揚光大
	 }
//class Scooter extends bike {//摩托車繼承腳踏車,發揚光大,速度變快,有裝燈
//	//繼承觀念如果爸爸有的會繼承
//	private boolean light; //一開始boolean是false; 這是屬性
//	
//	boolean isLight() { //燈有亮沒亮,回傳false沒亮燈
//		return light;
//	}
//	
//	void switchLight() { //如果false沒有亮燈,按下去便有亮燈
//		light =! light; //本來沒燈切下去便有燈,開關
//	}
//	//腳踏車是加速度,摩托車也是加速度,方法名一樣但內容不同,不用想太多
//	//剛改時發現紅字出現,因為爸爸的屬性bike的speed在他的年代就把屬性設定private鎖起來,所以用子孫們玩不到
//	//繼承給你的是沒有private的,所以剛剛父親腳踏車的速度可以用,但屬性不能完
//	//speed屬性前面用 protected存取,兒子就可以玩了
//	void upSpeed() {
//		speed = speed<1 ? 1: speed*2.4;
//	}
//}
	