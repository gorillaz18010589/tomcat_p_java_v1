package iotest;

import java.io.FileInputStream;
import java.io.FileOutputStream;
//用陣列方式臉篷的大小,準備大臉篷來讀 1024*4097 =>大約4ma
//一次寫入陣列,從0一開始,一次讀你的長度
//通常讀的速度會比寫的還要快
//也是一讀一寫方式,但準備大臉篷,大面積的讀大面積的寫
//FileOutputStream=>write(byte[] b, int off, int len) ::寫入方式(讀取的檔案物件,讀取從什麼位置開始,讀多少長度)
//FileInputStream=>read(byte[] b):讀取方式以陣列大小
public class Brad28_照片複製用_byte陣列_大臉篷 {

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		try {
		FileInputStream fin = 
			new FileInputStream("dir1/coffee2.jpg");
		FileOutputStream fout =
			new FileOutputStream("dir2/coffee2.jpg");
		
		byte[]buf = new byte[4096];
		int len;
		while ((len = fin.read(buf)) != -1) {
			fout.write(buf, 0, len);
		}
		fout.flush();
		fout.close();
		fin.close();
		System.out.println("照片讀取複製成功,以byte朕列方式4M大小讀取寫入");
		}catch (Exception e) {
			e.toString();
		}
		System.out.println(System.currentTimeMillis() - start);
	}
}

