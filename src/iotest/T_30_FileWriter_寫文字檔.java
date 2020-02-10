package iotest;

import java.io.FileWriter;

//目標寫文字檔案
//文字檔有什麼特色,會換行換列一般檔案不會
//以字元為單位,有一招write(string)所以不用轉byte
//讀取資料的源頭叫Reader API =>因為讀取的式字元 =>抽象類別
//再來看到針對寫CHAR的字元的Write API =>抽象類別
//Write => write(String str)
//FileReader:爸爸還是InputStreamReader 館子串接觀念
//FileWriter:
//java.io.FileWriter.FileWriter(String fileName):建構式 建造文字資料夾(dir1/Brad.txt")
//java.io.Writer.write(String arg0):在檔案底下寫入文字(void方法)
public class T_30_FileWriter_寫文字檔 {

	public static void main(String[] args) {
		try {
		FileWriter writer = new FileWriter("dir1/Brad.txt");
		writer.write("大家好,我是Brad\n,Hello world");
		writer.flush();
		writer.close();
		}catch (Exception e) {
			System.out.println(e.toString());
		}
	}

}
