package iotest;

import java.io.FileInputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.util.function.ObjIntConsumer;

//目標解序列化
//ObjectInputStream(InputStream in) :讀取obj物件資料串流
//ObjectInputStream =>readObject()  :讀取物件
//Object=>getClass() :取得物件的類別 (傳回Class<?>)
//java.lang.Class<T> =>getName() :取得檔案名(回傳String)
//java.lang.Class<T> =>getMethods() :回傳你是用的方法你的方法必須是public (回傳值Method[])
//java.lang.reflect.Method=> getName():抓到方法陣列的name名子(回傳值String)
//方法都一樣,你跟我差別在屬性
//序列化只是把屬性序列化
public class T34_解序列化 {

	public static void main(String[] args) {
		try {
		//(1)讀入object物件串流
		ObjectInput oin =
			new ObjectInputStream(
				new FileInputStream("dir1/brad.object"));//file串流檔案塞入Obj串流的館子中存放在oin
		//(2)解序列化,物件轉回學生類別,印出方法
			Object obj	= oin.readObject(); //解序列化後拿到的是物件
			student s1 = (student)obj; //物件要轉型回成學生存到s1才能用
			System.out.println(s1.sum()); //s1.的總和方法
			System.out.println(s1.c());   //s1的平均方法
			oin.close();
			System.out.println("解序列化成功");
		}catch (Exception e) {
			System.out.println(e.toString());
		}
	}

}
