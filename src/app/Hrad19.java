package app;



public class Hrad19 {
		//只要是腳色都可以發技能,看大家各自就不用一個一個寫
		//多形的漂亮,就是我打算att()攻擊 ,只要是怪物都進來<,但看你怪獸的不同所發射就不同

	public static void main(String[] args) {
		Magic m = new Magic();
		Knight k = new Knight();
		Assasin a = new Assasin();
		
		m1(a);
		m1(k);
		m1(m);
	}
		
		static void m1(skills s) { //只要m1(物件實體化)
			s.att();  //大家一起都攻擊,但看自己實作的招式
//			s.cry();
		}
}

	

interface skills { //規則
	void cry();
	void att();
}

class Magic implements skills{
	 public void cry(){System.out.println("使出治癒術");}
	 public	void att(){System.out.println("使出隕石術!!!");}
}
class Knight implements skills{
	public void cry() {System.out.println("坐下回血中....");}
	public void att() {System.out.println("使出連刺攻擊!!!");}
}
class Assasin implements skills{
	public void cry() {System.out.println("睡覺回血中...");}
	public void att() {System.out.println("使出十字斬!!!!");}
}

