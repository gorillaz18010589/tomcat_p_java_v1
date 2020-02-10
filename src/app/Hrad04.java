package app;
import myja.*;
public class Hrad04 {

	public static void main(String[] args) {
		String s1 = new String();
		System.out.println(s1);  //印出空
		
		byte [] b1 = {97,98,99,100}; //建立byte陣列
		String s2 = new String(b1); //<== String(byte[] bytes) :此方法是把陣列轉成ASIC瑪
		System.out.println(s2);     //印出abcd
		
		String s3 = new String(b1,1,2); //<== String(byte[] bytes, int offset, int length): 把b1陣列轉成asic瑪陣列,取1位置開始,取2個數字所以bc
		System.out.println(s3);  //印出bc
		
		Hrad24 b2 = new Hrad24();
		System.out.println(b2);  //印出myja.Hrad24@15db9742 (物件),回到24改寫String印出i am hero;
		
	}

}
