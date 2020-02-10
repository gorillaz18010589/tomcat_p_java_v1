package app;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.ObjectInputStream.GetField;
import java.lang.reflect.Method;

//目標解序列化
//ObjectInputStream(InputStream in) :讀取obj物件資料串流
//ObjectInputStream =>readObject()  :讀取物件
//Object=>getClass() :取得物件的類別 (傳回Class<?>)
//java.lang.Class<T> =>getName() :取得檔案名(回傳String)
//java.lang.Class<T> =>getMethods() :回傳你是用的方法你的方法必須是public (回傳值Method[])
//java.lang.reflect.Method=> getName():抓到方法陣列的name名子(回傳值String)
//方法都一樣,你跟我差別在屬性
//序列化只是把屬性序列化
public class Hrad34_2_解序列化一次read多個物件 {

	public static void main(String[] args) {
		try {
			ObjectInputStream oin = //讀取物件的的連接檔案水管
					new ObjectInputStream(new FileInputStream("dir1/brad.object"));
			student ss = null;
		try {
		while ((ss =(student)oin.readObject())!=null) { 
			System.out.println(ss.sum()+":"+ss.avg());
		}
		}catch(EOFException ef) { //抓到EOFE的例外不顯示
			
		}	
		}catch (Exception e) {
			System.out.println(e.toString());
		}
	}

}
