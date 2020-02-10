package app;

public class Hrad07 {
	public static void main(String[] args) {
		String test ="A123456789";
		String phone ="0922-900465";
		String ip ="192.168.3.4";
		
//		n = 0 ~ 255
//		1:[0-9]. //個位數
//		2:[1-9]+[0-9]. //十位數加個位數
//		3:1: 1[0-9]{2}.
//		3-2-1:2[0-4][0-9].
//		3-2-2 25[0-5].
		
//		(([0-9])|([1-9][0-9])||)\.){3}
	
//		
//		if(test.matches("[^B]123456789")) { //[^B]B排除掉,其他我都要
		//[a-z] 123456789
		//[a-zA-Z] 123456789 大小寫都要
//			if(test.matches("[B]123456789")) { //[B]有包含在裡面
//		if(phone.matches("09[0-9]{2}-[0-9]{6}")) { 手機號碼驗證方式
		if(test.matches("[A_Z][12][0-9]{8}")) { //[A_Z]=>身分證第一瑪 [12]=>性別不是1就是2 [0-9] =>數字0-9之間都可以{8} =>前面這件事情做8次
				System.out.println("有包含在裡面");
		}else {
			System.out.println("沒有包含在裡面");
		}
	}
}
