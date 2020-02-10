package app;

public class Hrad18 {
	//目的我只想要做m1()方法根本不想做m2()所以讓182類別抽象,但骨子裡的m1,只要讓兒子去做就m1()就好m2就不強迫
	//(1)介面是181
	//(2)abstract class Hrad182 幫我擋掉,雖然類別是抽象,但方法卻不是
	//(3)所以讓孫子183去改m1方法,那另外m2方法根本就不用做了~
	public static void main(String[] args) {
	Hrad183 obj1 = new Hrad183();
	test1(obj1); //雖然當初test(Hrad181)要求裡面要181,但因為我183繼承了所以我當然可以呼叫,我爸爸有考過我繼承過來
	
	Hrad184 obj2 = new Hrad184();
	test1(obj2); //雖然當初test(Hrad181)要求裡面要181,但因為我183繼承了所以我當然可以呼叫,我爸爸有考過我繼承過來
	}
	static void test1(Hrad181 obj) { //我要使用這個介面,我才能叫這方法
		obj.m1(); obj.m2();
	}
}
interface Hrad181{ //這個介面有m1,m2方法
	void m1(); void m2();
}
abstract class Hrad182 implements Hrad181{  //實作182,"類別抽象"但裡面"方法沒有抽象",讓兒子去實作就可選擇性做
	public void m1() {} //但實作的方法我讓兒子去做
	public void m2() {}
}
class Hrad183 extends Hrad182{ //兒子繼承了老爸的abstract class,因為爸爸骨子的方法沒有都抽象,所以選擇我要做的方法就好
	public void m1() {System.out.println("183改寫m1方法(A)");}
}
class Hrad184 extends Hrad182{ //兒子繼承了老爸的abstract class,因為爸爸骨子的方法沒有都抽象,所以選擇我要做的方法就好
	public void m1() {System.out.println("184改寫m1方法(B)");}
}
//寫到20程式後才講到介面可以繼承多個,他不是類別的概念,類別只能繼承一個爸爸
interface Hrad185 extends Hrad181{
	void m3();
}
interface Hrad186 extends Hrad185,Hrad181{ //186介面發揚光大185,184,所以有m1,m2,m3,m4方法 
	void m4();
}