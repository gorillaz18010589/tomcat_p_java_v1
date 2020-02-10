package iotest;

import java.io.FileInputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.lang.reflect.Method;
import java.util.function.ObjIntConsumer;



//目標解序列化,取得序列化物件的類別
//你拿到一個物件不知道他是什麼,用反設法知道
//io.ObjectInputStream(InputStream in) :讀取obj物件資料串流
//io.ObjectInputStream =>readObject()  :讀取物件
//Object=>getClass() :取得物件的類別 (傳回Class<?>)
//java.lang.Class<T> =>getName() :取得檔案名(回傳String)
//java.lang.Class<T> =>getMethods() :(取得該類別的方法)回傳你使用的方法你的方法必須是public (回傳值Method[])
//java.lang.reflect.Method=> getName():抓到方法陣列的name名子(回傳值String)
//方法都一樣,你跟我差別在屬性
//序列化只是把屬性序列化
public class T34_2_解序列化取得class {

	public static void main(String[] args) {
		try {
		//(1)讀入object物件串流
		ObjectInput oin =
			new ObjectInputStream(
				new FileInputStream("dir1/brad.object"));
		//(2)解序列化,取該物件的類別
		Object obj	= oin.readObject();  //回傳值是物件所以obj
		//序列化後取得你的相關資訊
//		String name = obj.getClass().getName(); //取得你這物件類別裡的姓名存入
//		System.out.println(name);//顯示類別
		student s1 = (student) obj; //obj轉型成Student
		Method[] m1 = s1.getClass().getMethods(); //抓到你物件的方法名
		for(Method m:m1) { //拿到方法陣列
			System.out.println(m.getName());  
		}
		
			oin.close();
			System.out.println("");
		}catch (Exception e) {
			System.out.println(e.toString());
		}
	}

}
