package app;

public class Hrad08_String {

	public static void main(String[] args) {
		//字串類別只要做出物件實體,字串內容將不會被變更
		String s1;
//		System.out.println(s1); s1=>沒有初始化出現紅字
		String s2 = null;
//		System.out.println(s2); s2=>出現null
//		System.out.println(s2.charAt(0)); 因為你肚子裡根本是空你charat()跑出一個例外 java.lang.NullPointerException空指向
		
//		(1)concat("world") 在後面加上內容
		String s3 ="hello";
		s3.concat("world");  //(錯誤方式)因為你所加的東西是新物件,你沒有存入在新物件哩,所以讀起來還是沒有
		String s4 = s3.concat("world"); //(正確方式)回傳值是String所以產生一個新的印出舊舊有加world 
		System.out.println(s3);
		System.out.println(s4);
		System.out.println("======================");
		
//		(2)byte[] =>把字串轉成byte陣列,(回傳值byte[]陣列)
		String s5 ="happy";
		byte[] b5 = s5.getBytes();
		for(int c:b5) {
			System.out.println(c); //印出byte陣列是數字;
//			System.out.println((char)c); //把byte陣列轉回char
			System.out.println("=================");
			}
//		(3)	replace(char oldChar, char newChar) =>把字串裡的字修改成你要的
		s3.replace('o', '8'); //錯誤方式
		String s6 = s3.replace('o', '8'); //正確方式
		System.out.println(s3);
		System.out.println(s6);
		
	}

}
