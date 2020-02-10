package execute;
import prictice.*;
//Import:將不同Package的Class類別讓你可以玩
//1.(一個原始檔中只能有一個class是public):所以Lexux寫在Car裡面玩不到
//2.Public:讓全世界都可以玩的到

public class Pank1_Lexux_不同Pakceage存取修飾字 {
	public static void main (String[] args) {		
		
		//1.(一個原始檔中只能有一個class是public):所以Lexux寫在Car裡面玩不到
		Car c1 = new Car(2); //Import後可以玩
//		Lexux l1 = new Lexux();  //Import後還是不能玩,因為我把Lexux寫在Car的類別理,但因為public class只有一個,就是Car,所以Car可以玩Lexux不行
		
		//2.因為upSpeed等方法,沒有public,所以不能玩,加入Public全世界都能玩
		//Lenxux加速度兩次的結果
		Lexux l1 = new Lexux();
		System.out.println(l1.getSpeed());
		l1.upSpeed(); l1.upSpeed();
		System.out.println(l1.getSpeed()); //3.6
		
		//汽車加速度兩次的結果
		System.out.println(c1.getSpeed());
		c1.upSpeed();c1.upSpeed();
		System.out.println(c1.getSpeed()); //1.2
	
		
		
	}
	
}
