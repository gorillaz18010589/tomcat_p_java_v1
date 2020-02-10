package app;

public class Hrad12_方法 {

	public static void main(String[] args) {
		//OverLoad 同名異事 =>只要方法名稱一樣,但參數型別不同舊事OverLoad
		//建構是也有Overload
		
//		System.out.println(new Hrad121().m1((byte)1)); 這招指是利用你的方法直接叫,借用一下,裡面的值不重要
		
		Hrad121 obj1 =new Hrad121();
//		obj1.m1();  //Hrad121:m1()
//		obj1.m1(2); //Hrad121:m1(int)
//		obj1.m1((byte)2,3); //Hrad121:m1(byte)
//		obj1.m1(3,(byte)3); //Hrad121:m1(byte,int)
//		obj1.,1((byte)1,(byte)2) 編譯失敗,因為你沒有這東西,你都搞不清楚電腦怎麼清楚
//		obj1.sayya("hank"); //hankya! 參數對一個人打招呼
		
//		(String[] name) 看你陣列裡面有什麼舊叫什麼
		String[] s1 = {"peter","hank","kidd","kobe"}; //參數對多個人打招!
//		obj1.saya(s1);
		
		//(String... name)這招想寫幾個舊寫幾個,不定個數參數傳遞,想寫幾個就幾個
		//string(a) string(a,b)  string(...) 
		//準確一個就叫a兩個就叫b 不是地都叫string... c
		//string ...彈性很大
		//不訂個數只能擺一個,而且只能放後面,不然怎麼知道你要寫幾個(int a,String...)類似這樣先做固定在做不固定
		obj1.saya("kobe","carter");
		obj1.saya("jason");
		
	}

}
//byte m1(byte a) {
//System.out.println("Hrad121:m1(byte)");
//return (byte)1;
//}
class Hrad121{
	void m1() {System.out.println("Hrad121:m1()");}
	void m1(byte a) {System.out.println("Hrad121:m1(byte)");}
	void m1(int a) {System.out.println("Hrad121:m1(int)");}
	void m1(byte a, int b) {System.out.println("Hrad121:m1(byte,int)");}
	void m1(int a, byte b) {System.out.println("Hrad121:m1(byte,int)");}
	void sayya (String name) {System.out.println(name +"ya!");}  //用參數打招呼
//	void saya(String[] name) {
//		for(String a:name) {System.out.println(a+"hi");}
//	}
	void saya(String... name) { //String... =>String[] ,所以跟上面同名骨子裡一樣錯誤,這是一圍陣列
		for(String a:name) {System.out.println(a+"hi");}
	}
}