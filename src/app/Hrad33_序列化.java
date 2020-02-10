package app;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
//目標:創造出物件,讓整個物件進行序列化的動作
//java.io.ObjectOutputStream(OutputStream out)
//java.io.FileOutputStream(File file)
//java.io.ObjectOutputStream =>writeObject(Object obj) : 寫入檔案序列化
//8大型別都可時做序列化Serializable
public class Hrad33_序列化 {
	public static void main(String[] args) {
		//(3)創造物件實體搭配參數
		student s1 = new student(90, 80, 100);
		student s2 = new student(50, 70, 100);
		student s3 = new student(93, 60, 100);
		System.out.println(s1.avg());
		System.out.println(s1.sum());
		System.out.println(s1);
		//(1)第一步把物件檔案衝出寫好
		try {
		FileOutputStream fout = new FileOutputStream("dir1/brad.object"); //在dir1底下寫一個物件先連接file串流
		ObjectOutputStream oout = new ObjectOutputStream(fout);  //把file串流放進去拿到物件串流
		
		oout.writeObject(s1);//把檔案寫入(物件) 出現NotSerializableException:所以要在類別時做
		oout.writeObject(s2);
		oout.writeObject(s3);
		oout.flush();
		oout.close();
		System.out.println("OK");
		}catch (Exception e) {
			System.out.println(e.toString());
		}
	}
}
//(2)寫好類別要輸出的物件
class student implements Serializable{  //(5)必須宣告實作可序列化
	int ch;
	transient int math; //加入transient 不會被序列化,但一樣會在物件裡面初始化
	int eng;
	//建構式
	student(int ch,int math, int eng){this.ch = ch; this.math=math; this.eng =eng;}
	public int sum() {return ch+math+eng;} 	//總成績方法
	public double avg() {return sum()/3.0;} //平均數方法
}
