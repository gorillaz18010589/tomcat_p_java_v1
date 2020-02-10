package prictice;
//訊息有兩個狀態,可以切換一下印ok一下印xx
//1.第一種三源運算方式,如果是0就變成1,否則就變成0,這是用邏輯的角度去做
//2.第二種方式用^ 異性相吸,同性相斥的原理
public class Pank21_否則敘述句 {
	public static void main(String [] args) {
		int a = 0; //0代表ok位置
		String[] mesg = {"OK","XX"}; //陣列[0,1]位置
		//1.第一種三源運算方式,如果是0就變成1,否則就變成0,這是用邏輯的角度去做
//		System.out.println(mesg[a]);
//		a = a==0?1:0;  //如果 a等於0的話 ?那就變成1,:(否則)就是1
//		System.out.println(mesg[a]);
//		a = a==0?1:0; 
//		System.out.println(mesg[a]);
//		a = a==0?1:0; 
//		System.out.println(mesg[a]);
//		a = a==0?1:0; 
//		System.out.println(mesg[a]);
//		a = a==0?1:0; 
//		System.out.println(mesg[a]);
		
		//2.第二種方式用^ 異性相吸,同性相斥的原理
		System.out.println(mesg[a]);
		a = a^1; //一開始為0 ==> 0^1 =>因為異性相吸,所以0變成1
		System.out.println(mesg[a]);
		a = a^1; //a ==1 ==> 1^1 =>同性相斥,變回來所以變成0
		System.out.println(mesg[a]);
		a = a^1;
		System.out.println(mesg[a]);
		a = a^1;
		System.out.println(mesg[a]);
		a = a^1;
		System.out.println(mesg[a]);
		a = a^1;
		System.out.println(mesg[a]);
		
		
		
	}
		
}
