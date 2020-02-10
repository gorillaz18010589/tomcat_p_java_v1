package prictice;
//目的:玩Car
//1.我需要一台汽車,你要物件實體化汽車,汽車的物件實體化靠的是new出一空間
//物件實體化概念:new == 騰出一個空間 , Car() == 把這個物件實體化放進去
//初始化:第一次給值就是完成初始化設定,就傭有它了
//2.現在開始玩家速度減速度方法,這邊負責玩,你就不要管那邊的事,那邊是汽車公司要煩惱的
//3.Private(封裝)概念:是因為,你汽車不能直接用c1.spped = 10;的方式直接讓使用者看到速度在修改,不合哩,所以為了讓使用者不准亂改要Private封裝起來
//*getSpeed(裝時速表概念):因為你Private屬性,消費者就看不到速度了,所以你要如何知道你汽車時速,你需要裝時速表,所以才要getSpeed;
public class Pank22_執行Car {

	public static void main(String[] args) {
		//1.宣告之後才做初始化把汽車叫近來,較笨的方法
//		Car c1; //宣告一台汽車變數名稱叫c1
//		c1 = new Car(); //初始化汽車
		
		//2.加速度四次,看一下速度,減速度兩次,查看一下速度,體會概念
		Car c1 = new Car(2);//宣告同時把汽車叫出來玩,物件實體初始化,加入2是因為建構式有給參數了,那就要尊重
//		c1.upSpeed();c1.upSpeed();c1.upSpeed();c1.upSpeed(); //踩了油門四次後
//		System.out.println(c1.spped); //查看一下速度
//		c1.downSpeed(); c1.downSpeed(); 
//		System.out.println(c1.spped); 
		
		
		//3.直接改變速度屬性變成10,不合理的方式,哪一抬腳踏車看的到速度,用肉眼判斷,你可以直接這樣改?所以要Private屬性讓外人改變不了
//		c1.spped = 10; //因為Privae屬性了,所以玩不到了但還沒private之前是可以直接串改的
//		System.out.println(c1.spped); 
		
		//4.用簡單的方法邏輯寫一個,讓速度簡單到10的方法,最後用getSpeed用時速表看時速
		for(int i =0; i<15; i++) {
			c1.upSpeed();
			System.out.println(c1.getSpeed());
		}
		

		
	
		
	}

}
