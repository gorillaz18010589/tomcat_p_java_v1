package iotest;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

//目標:創造出物件,讓整個物件進行序列化的動作
//java.io.ObjectOutputStream(OutputStream out) :物件序列化串流
//java.io.FileOutputStream(File file):檔案串流
//java.io.ObjectOutputStream =>writeObject(Object obj) : 寫入檔案序列化

public class T_33_ObjectOUT串流_物件序列化 {

	public static void main(String[] args) {
		student s1 = new student(100,90,80);
		student s2 = new student(57,78,90);
		student s3 = new student(70,66,80);
		
		System.out.println(s1.c());
		System.out.println(s1.sum());
		System.out.println(s2.c());
		System.out.println(s2.sum());
		System.out.println(s3.c());
		System.out.println(s3.sum());
		try {
			FileOutputStream fout = new FileOutputStream("dir1/brad.object");
			ObjectOutputStream oout = new ObjectOutputStream(fout);
			oout.writeObject(s1); //出現java.io.NotSerializableException:錯誤,所以去找發現藥物見要實作
			oout.writeObject(s2);
			oout.writeObject(s3);
			oout.flush();
			oout.close();
			System.out.println("序列化成功");
		}catch (Exception e) {
			System.out.println(e.toString());
		}
	}
	
}

class student implements Serializable { //序列化的話物件要實作 Serializable,因為ser沒有要實作的方法所以時做這個
	int math,eng,ch;
	int sum;
	double c;
	//建構式
	public student(int math,int eng,int ch) {this.math = math; this.eng = eng; this.ch = ch;}	
	//方法
	public int sum(){ //總和方法
	return	sum = math + eng +ch;
	}
	public double c() { //平均方法
	return  c = sum()/3.0;	
	}
}