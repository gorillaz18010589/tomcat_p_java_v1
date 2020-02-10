package iotest;

import java.io.FileInputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.lang.reflect.Method;
import java.util.function.ObjIntConsumer;



//目標解序列化,取得序列化物件的類別
//一次解多個序列化方法
//io.ObjectInputStream(InputStream in) :讀取obj物件資料串流
//io.ObjectInputStream =>readObject()  :讀取物件
//方法都一樣,你跟我差別在屬性
//序列化只是把屬性序列化
public class T34_3_reader多個序列化檔案 {

	public static void main(String[] args) {
		try {
		//(1)讀入object物件串流
		ObjectInput oin =
			new ObjectInputStream(
				new FileInputStream("dir1/brad.object"));
		//(2)一次讀三個序列化檔案,會顯示出例外
//		student ss =null;
//		while ((ss = (student)oin.readObject()) != null) {
//			System.out.println(ss.c()+";" + ss.sum());
//		}
		
		//(2)一次讀三個序列化,處理例外問題
			student ss = null; //一開始學生類別物件初始化
			while(true) {//一直跑直到最後跑完會拋出例外
				try {
					ss = (student)oin.readObject(); //把拿到的物件讀取後,強制轉型成學生類別存入ss
					System.out.println(ss.sum + ";" + ss.c()); //印出成績總分,跟平均
				}catch (Exception e) { //讀完後會跑到這個例外
					break; //讀完後跳出迴圈結束
				}
			}
			oin.close();
			System.out.println("一次解多個序列化成功");
		}catch (Exception e) {
			System.out.println(e.toString());
		}
	}

}
