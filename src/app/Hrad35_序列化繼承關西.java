package app;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.function.ObjIntConsumer;

//先創造三代351,352,353 還有獨立一代354打算將353進行序列化動作
//你要寫入物件序列化OBJoput時,你要序列化的類別要加implements Serializable才行,因為你肚子序列化類別要序列化
//讀取檔案時:祖先類別沒有進行implements Serializable序列化,所以祖先類別初始化了
//序列化看你在哪一袋,假設你祖先第一代就序列化,那你後面的都序列化了,東西都有出去
//假設你祖先沒序列化,你最後一代才有,那你阿公會沒序列化先跑初始化,只有你這一代有序列化 東西有出去
//信用卡簽名 序列化範例

public class Hrad35_序列化繼承關西 {

	public static void main(String[] args) {
	Hrad353 obj1 = new Hrad353(); //一開始全部會叫近來,OBJ4我另外叫的
		//序列化
		try { 
		ObjectOutputStream oout = //(1)物件序列化寫入一個obj物件序列到dir1底下
				new ObjectOutputStream(
						new FileOutputStream("dir1/test.obj"));
		oout.writeObject(obj1); //序列化出現Hrad351() Hrad352()	Hrad354()Hrad354()序列化OK
		oout.flush();
		oout.close();
		System.out.println("序列化OK");
		}catch (Exception e) {
			System.out.println(e.toString());
		}
		//解序列化
			System.out.println("=================");
			try {
			ObjectInputStream oin =
					new ObjectInputStream(
							new FileInputStream("dir1/test.obj")); //從dir/text.obj目錄讀取
				Object obj2 =oin.readObject();
					oin.close();
					System.out.println("解序列化成功");
			}catch (Exception e) {
				System.out.println(e.toString());
			}
	}
}

class Hrad351  {
	Hrad351(){
		System.out.println("Hrad351()");
	}
}
class Hrad352 extends Hrad351{
	Hrad352(){
		System.out.println("Hrad352()");
	}
}
class Hrad353 extends Hrad352 implements Serializable{ //353實作序列化
	int a;
	Hrad354 obj = null;
	Hrad353(){ //建構式
		System.out.println("Hrad354()");
		a=10;
		obj = new Hrad354();
	}
}
class Hrad354 implements Serializable{ //執行出現java.io.NotSerializableException: 因為你要序列化所以你的類別也要是序列化加入implements Serializable
	Hrad354(){
		System.out.println("Hrad354()");
	}
}