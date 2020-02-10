package prictice;
//目的:建構式的多種參數方式
//執行在:Pank03
//建構式可以有多個:(1)無傳參數 (2)有傳參數 (3)只要參數個數型別不一樣都可以形成建構式
//建構式參數(個數)(型別)要不一樣:就像你建構式一模一樣,我怎知道你要叫誰
//overloaded概念:(1)Class建構式名字一樣,但參數個數不同,所形成的現象
//建構式沒有繼承的概念:繼承的東西,只有數性跟方法而已,他會去找你爸爸建構式無參數的那招
//建構式會先叫爸再來才執行你的東西
//不管有傳參數無傳參數建構式:第一句都會Super(叫爸爸)
//overloaded概念:(1)Class建構式名字一樣,但參數個數不同,所形成的現象

//final(最終)概念:絕子決孫概念,就不讓你繼承,最後一代的概念
//final使用情況:基於安全考量,例如String概念,你雖然是我後代但我怕你亂改,破壞我字串的好名聲
//Deprecated:代表以後可能不給使
//前面(沒有static)的話:一定要有物件才可以叫,就像你要有腳踏車物件才能對他加速度,所以這種叫物件方法
//Methods inherited(繼承) from class java.lang.Object://代表繼承自Object這邊是沒有Overrride的


public final class Pank24 {//public final class Pank24:因為加入Final所以決子決孫,Pank25繼承不了爆紅字

	//overloaded概念:(1)Class建構式名字一樣,但參數個數不同,所形成的現象
	//以下就是OverLoaded示範
	public Pank24() {
		System.out.println("Pank24()");
	}
	public Pank24(int a) {
		System.out.println("Pank24(int)");
	}

	public Pank24(int a, boolean b) {
		System.out.println("Pank24(int,boolean)");
	}
	
	public Pank24(int a , int b) {
		System.out.println("Pank24(int,int)");
	}
	
//	//錯誤示範:型別一樣:當然認不清楚要宣告誰被拒絕
//	publicPank24(int b){
//		
//	}
	
}
