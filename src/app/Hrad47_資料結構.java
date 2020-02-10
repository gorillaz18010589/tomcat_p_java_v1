package app;
//介紹set為主
//資料結構java.util底下看
//資料結構只能放物件不能放型別
//指定這個資料結構所放置的元素型別,基本型別所放的是物件的值,物件所放的東西是記憶體位置
//1.interface Collection(採集)<E>(泛型):兩大系列如以下(1)是set,(2)是list
//*set =>叫集合這組東西,裡面的東西不會重複,裡面東西是亂丟的,沒有再排第一第二三順序性
//*list =>是可以重複的,有順序性,比較像陣列,定義的更多更詳細
//add(E e):一個一個加進來
//addAll(Collection<?):也可以有一組東西加進來,一次丟很多

import java.util.HashSet;
import java.util.Iterator;
//void	clear():清掉
//boolean	contains(Object o):可以問她裡面有嗎
//boolean	containsAll(Collection<?> c):可以整組問她
//equals(Object o):我會比較妳所以的物件裡面是否一億
//java.util.HashSet.iterator():(回傳Iterator)//有方向一次拿完全不東西,因為你是亂丟的東西,所以我用這個迭代這個魚鉤的捲線器就是這概念,一個把一個線拉起來,室友方向的
//java.util.HashSet.size()://查詢這個資料結構裡有幾個元素(int)
//java.util.Iterator.hasNext()://還有沒有下一個元素(回傳boolean)
//java.util.Iterator.next():下一個元素存到obj(物件)裡(回傳Object)
public class Hrad47_資料結構 {

	public static void main(String[] args) {
		HashSet set = new HashSet(); //創造資料結構的物件實體
		set.add("Brad");//把一個元素物件丟進去,就算是基本型別也會自動封裝成物件
		set.add(123); //自動封裝成 Interger 物件
		set.add(12.3);
		set.add(123); //因為裡面東西不能重複,所以這邊只取一個123
		System.out.println(set.size()); //查詢這個資料結構裡有幾個元素
		System.out.println(set.toString());//查詢資料結構裡的屬性,發現沒有順序性
		System.out.println("=========================");
		
		//迭代尋訪它裡面的元素,一個一個元素拿出來
		Iterator it  = set.iterator(); //拿到這個資料的迭代器
		while(it.hasNext()) {//問一下it下面還有沒有元素,有的話
			Object obj = it.next(); //下一個元素存到obj裡
			System.out.println(obj); 
		}

	}

}
