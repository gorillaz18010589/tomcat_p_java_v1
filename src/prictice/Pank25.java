package prictice;
//建構式可以有多個:(1)無傳參數 (2)有傳參數 (3)只要參數個數型別不一樣都可以形成建構式
//建構式參數(個數)(型別)要不一樣:就像你建構式一模一樣,我怎知道你要叫誰
//建構式沒有繼承的概念:繼承的東西,只有數性跟方法而已,他會去找你爸爸建構式無參數的那招
//建構式會先叫爸再來才執行你的東西
//不管有傳參數無傳參數建構式:第一句都會Super(叫爸s
//overloaded概念:(1)Class建構式名字一樣,但參數個數不同,所形成的現象
public class Pank25 extends Pank24 {
	public Pank25(){
		//因為偷偷叫爸Super(); 所以先Pank24()
		//Super();
		System.out.println("Pank25()");
	}
	
	public Pank25(int a) {
		super(1,false); //這邊我直接先叫爸爸的Pank(int,boolean)參數建構式
		System.out.println("Pank25(int)");

	}
	
	
}
