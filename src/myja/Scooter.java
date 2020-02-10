package myja;

public class Scooter extends bike {//摩托車繼承腳踏車,發揚光大,速度變快,有裝燈
	//繼承觀念如果爸爸有的會繼承
	//摩托車另外存也加public讓其他packge可以玩到
	//可以完速度因為爸爸的speed宣告為protected所以子孫完的道speed
	//一開始方法沒有public所以其他人玩不到再加上public
	//**爸爸設定參數了建構式,你沒有建構式只能拿爸爸無傳參數的建構式,爸爸不想定義,所以你自己做你自己的就沒事
	//**任何建構式的第一道敘述句,就是專門將祖宗八代叫近來
	//**每一代都叫爸爸,我爸爸再叫爸爸
	//**你一開始沒有定義,就去找爸爸建構式無傳參數的,發現都沒有只好抱你錯
	//**所以在super(4)加上參數自己定義建構是初始化
	public Scooter() {//**自己定義建構式,
		// super(); //偷偷叫爸爸做這件事,叫爸爸無傳參數的建構式完成初始化
		super(4); //因為腳踏車裡面沒有無傳參數地所以被罵,那就給他加參數就OK
	}
	
	private boolean light; //一開始boolean是false; 這是屬性
	
	public	boolean isLight() { //燈有亮沒亮,回傳false沒亮燈
		return light;
	}
	
	public	void switchLight() { //如果false沒有亮燈,按下去便有亮燈
		light =! light; //本來沒燈切下去便有燈,開關
	}
	//腳踏車是加速度,摩托車也是加速度,方法名一樣但內容不同,不用想太多
	//剛改時發現紅字出現,因為爸爸的屬性bike的speed在他的年代就把屬性設定private鎖起來,所以用子孫們玩不到
	//繼承給你的是沒有private的,所以剛剛父親腳踏車的速度可以用,但屬性不能完
	//speed屬性前面用 protected存取,兒子就可以玩了
	public void upSpeed() {
		speed = speed<1 ? 1: speed*2.4;
	}
}
