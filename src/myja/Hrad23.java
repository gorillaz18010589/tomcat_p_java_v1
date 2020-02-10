package myja;

public class Hrad23 {

	public static void main(String[] args) {
		Scooter s1 =new Scooter(); //完成初始化
		System.out.println(s1.getSpeed()); //但這台摩托車叫不長進,爸爸有什麼就有什麼,可自己沒有發揚光大
		System.out.println(s1.isLight()); //一開始沒開燈
		s1.switchLight(); //開燈後
		System.out.println(s1.isLight()); //顯示開燈
		

	}

}
