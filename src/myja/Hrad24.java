package myja;

public  class Hrad24 {
	//建構是可以有多個,但參數要不同不能一樣資料型態
	//final String 寫下去就決子決孫,怕你亂改破壞我的好名聲,對外宣稱你是我的後代,所以我不再有後代不想給你用,
	public Hrad24() {
		//super()都有偷偷做這事情
		System.out.println("Hrad24()");
	}
	
	public Hrad24(int a) {
		//super()
		System.out.println("Hrad24(int a)");
	}
	
	public Hrad24(int a,boolean b) {
		//super()
		System.out.println("Hrad24(int a,bollean b)");
	}
	
	//改寫爸爸裡面的方法配合Hrad04
	public String toString() {
		return "i am hero";
	}
}
