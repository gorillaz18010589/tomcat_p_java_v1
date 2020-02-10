package app;
import myja.Hrad24;
import myja.Hrad25;
public class Hrad03 {

	public static void main(String[] args) {
		//依你Hrad24所建立的各個建構式內的資料型態,怎麼定義就怎麼叫
		Hrad24 obj1 = new Hrad24();
		Hrad24 obj2 = new Hrad24(2);
		Hrad24 obj3 = new Hrad24(3,true);
		System.out.println("====================");
		//再玩下一代Hrad25
//		Hrad24 obj4 = new Hrad25(); 回傳爸爸的24待沒有傳參數的為唯一所以顯示Hrad24()
//		Hrad25 obj5 = new Hrad25(4); 建構式沒有繼承,所以24有參數,但25只有無參數的版本回傳
		//** 因為她有執行super();叫爸爸的觀念,所以會出現Hrad24()
		Hrad25 obj4 = new Hrad25();  //建構是後我建構成顯示25他就出現了
		Hrad25 obj5 = new Hrad25(4); //我有定義25有傳參數的所以可以用了
	}

}
