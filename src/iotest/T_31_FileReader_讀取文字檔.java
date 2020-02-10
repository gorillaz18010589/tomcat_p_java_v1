package iotest;

import java.io.FileReader;

public class T_31_FileReader_讀取文字檔 {

	public static void main(String[] args) {
		try {
			FileReader reader = new FileReader("dir1/Brad.txt");
			int c;
			while ((c =reader.read()) != -1) {
				System.out.println((char)c); //直接印出讀取檔案,int強制轉為char印出來
			}
			reader.close();
			System.out.println("讀取文字檔成功");
		}catch (Exception e) {
			System.out.println(e.toString());
		}

	}

}
