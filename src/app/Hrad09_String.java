package app;

public class Hrad09_String {

	public static void main(String[] args) {
		//*String物件+上新的"字串"會產生新的物件以下證明
		String s1 = new String("hank"); //物件實體化產生一個新的物件
		String s2 = s1; //把這產生的位置指向跟另一個一樣
		System.out.println(s1==s2); //位置一樣所以true
		s1 += "OK";  //加上了字串OK後
		System.out.println(s1); //hankOK s1改變創造一個新的記憶體空間
		System.out.println(s1==s2); //false 空間不同所以不相等

	}

}
