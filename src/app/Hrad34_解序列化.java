package app;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.ObjectInputStream.GetField;
import java.lang.reflect.Method;

//目標解序列化
//io.ObjectInputStream(InputStream in) :讀取obj物件資料串流
//io.ObjectInputStream.readObject()  :讀取物件
//Object.getClass() :取得物件的類別 (傳回Class<?>)
//java.lang.Class<T>.getName() :取得檔案名(回傳String)
//java.lang.Class<T>.getMethods() :回傳你是用的方法你的方法必須是public (回傳值Method[])
//java.lang.reflect.Method=> getName():抓到方法陣列的name名子(回傳值String)
//方法都一樣,你跟我差別在屬性
//序列化只是把屬性序列化
public class Hrad34_解序列化 {

	public static void main(String[] args) {
		try {
			ObjectInputStream oin = //讀取物件的的連接檔案水管
					new ObjectInputStream(new FileInputStream("dir1/brad.object"));
			Object obj	= oin.readObject();  //回傳值是物件所以obj,讀取序列化檔案
			//序列化後取得你的相關資訊
//			String name = obj.getClass().getName(); //取得你這物件類別裡的姓名存入
//			System.out.println(name);//顯示類別
			student s1 = (student) obj; //obj轉型成Student
			Method[] m1 = s1.getClass().getMethods(); //抓到你物件的方法名
			for(Method m:m1) { //拿到方法陣列
				System.out.println(m.getName());  
			}
			oin.close();
//			System.out.println(s1.sum()); //印出總分
//			System.out.println(s1.avg()); //印出平均
//			System.out.println("OK");
		}catch (Exception e) {
			System.out.println(e.toString());
		}
	}

}
