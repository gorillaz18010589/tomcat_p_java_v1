package iotest;

import java.io.FileInputStream;
import java.io.FileOutputStream;
//1.目標把dir1,底下的最大張咖啡照片,複製到dir2底下
//2.input = oput同時去做
//3.使用招式一次讀一個byte
//(long)java.lang.System.currentTimeMillis():千分之一秒
public class Trad27_file串流一讀一寫_照片複製 {

	public static void main(String[] args) {
		long start =System.currentTimeMillis();
		try {
		FileInputStream fin = 
			new FileInputStream("dir1/coffee2.jpg");
		FileOutputStream fout =
			new FileOutputStream("dir2/coffee2.jpg");
		int b;
		while ((b = fin.read()) != -1) {
				fout.write(b);
		}
		fout.flush();
		fout.close();
		fin.close();
		System.out.println("同時寫同時讀成功");
		}catch (Exception e) {
			System.out.println(e.toString());
		}
		System.out.println(System.currentTimeMillis() - start); //結束時間- 初始時間 =花費時間
	}
		
}
