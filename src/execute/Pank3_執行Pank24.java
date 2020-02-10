package execute;
import prictice.*;
//執行Pank24
//目的1:完多個建構式,有無傳參數的間購式,跟不同參數的建構式
//建構式可以有多個:(1)無傳參數 (2)有傳參數 (3)只要參數個數型別不一樣都可以形成建構式
//建構式參數(個數)(型別)要不一樣:就像你建構式一模一樣,我怎知道你要叫誰
//建構式沒有繼承的概念:繼承的東西,只有數性跟方法而已,他會去找你爸爸建構式無參數的那招
//建構式會先叫爸再來才執行你的東西
//不管有傳參數無傳參數建構式:第一句都會Super(叫爸)

//overloaded概念:(1)Class建構式名字一樣,但參數個數不同,所形成的現象
public class Pank3_執行Pank24 {

	public static void main(String[] args) {

		//1.目的:完多個建構式,有無傳參數的間購式,跟不同參數的建構式
		Pank24 obj1 = new Pank24(); //Pank24()
		Pank24 obj2 = new Pank24(2); //Pank24(int)
		Pank24 obj3 = new Pank24(10,true); //Pank(int,bollean)
		
		//示範建構式沒有繼承概念:目前Pank25是單純extendsPank24,沒有改任何建構式
		//2.建構式沒有繼承概念,因為已經用了爸爸無傳參數的Pank24()建構式當唯一的建構式,所以Obj5的 Pank24(2)建構式是沒用的
//		Pank25 obj4 = new Pank25();//Pank24()
//		Pank25 obj5 = new Pank25(2);建構式沒有繼承概念,因為已經用了爸爸無傳參數的Pank24()建構式當唯一的建構式,所以Obj5的 Pank24(2)建構式是沒用的
		
		//3.示範建構式會先叫爸,才做你執行的事情,因為先偷偷叫爸Pank24(),再來才是你的建構式Pank25();
		Pank25 obj6 = new Pank25();//Pank24(),Pankˊ25();
//		Pank25 obj7 = new Pank25(2);//Pank24(),Pank25();
		
		//4.因為//這邊因為我在Pank25(int){super(1,false); 這邊我直接先叫爸爸的Pank(int,boolean)參數建構式}
		Pank25 obj7 = new Pank25(2);//Pank24(int,boolean),Pank25();
	}

}
