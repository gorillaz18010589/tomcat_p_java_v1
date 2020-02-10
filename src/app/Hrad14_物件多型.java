package app;

public class Hrad14_物件多型 {

	public static void main(String[] args) {
		//(1).至少要一樣,或是發揚光大
		//(2).第一m2()方法依樣代表你想Override
		//(3).你打算Override;存取修飾字privte,public  要大於等於爸爸,
		//(4).基本型別,參數都一樣void,int等要跟爸爸一樣
		//(5)但String這種物件跟obj要最少要跟爸爸一樣,或發揚光大才可以
	}
}
	
class Hrad141{
	String m1() {return "";}
	private Object m2() {return new Object();} //爸爸用private你兒子當然看不到
//	private void m3() {} 這邊private你根本看不到
//	hand m2() {return null;} 第一代
}
class Hrad142 extends Hrad141{
	String m1(){return "A";} //型別一樣可以接受
//	String	m2(){{return "B";}} //爸爸的m2方法回傳值是Object,但我兒子String有發揚光大,所以OK ,因為String老爸是Object有發揚光大
//	StringBuffer m2() {return new StringBuffer();} //要同個爸爸,是object可以,如果是String爸爸步行因為他絕子決孫,你發揚不了
//	handv3 m2() {return null;} //第三代回傳值有發揚光大OK 
//	void m3() {} 所以這邊跟父親的m3()無關當然OK
}
class hand{
	
}
class handv2 extends hand{
	
}
class handv3 extends handv2{
	
}