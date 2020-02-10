package app;
//import myja.bike;  直接指定packge名.加上bike的class
import myja.*;   // 直接引用myja
public class Hrad01 {
	public static void main(String[] args) {
	//1.換了packge的一步後,就無法找到Soocter
	//2.第二步加上imporant.(packge名稱)*,但改了還是不行
	//3.看看腳踏車還在不在整格pakcge
	//4.因為class Soocter前面沒有加存取修飾字,所以只有他那個packge看的到,這邊看不到
	//5.因為Soocter寫在腳踏車裡面,所以獨立出來加上public讓全世界看到
	//6.摩托車跟腳踏車都可使用,但是14行s1.getSpeed();沒辦法使用
	//7.因為soocter的這些方法沒有public,所以只有他那個packge才可以存到
		bike b1 = new bike(2); //**因為後來有建構式傳參數,所以你也要加參數
		Scooter s1 = new Scooter();
		b1.getSpeed();
	}

}
