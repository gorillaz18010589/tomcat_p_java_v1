package app;
//目標寫文字檔案(輸出)
//文字檔有什麼特色,會換行換列一般檔案不會
//以字元為單位,有一招write(string)所以不用轉byte
//讀取資料的源頭叫Reader API =>因為讀取的式字元 =>抽象類別
//再來看到針對寫CHAR的字元的Write API =>抽象類別
//Write => write(String str)
//FileReader:爸爸還是InputStreamReader 館子串接觀念
//FileWriter:
//java.io.FileWriter.FileWriter(String fileName):建構式 建造文字資料夾(dir1/Brad.txt")
//java.io.Writer.write(String arg0):在檔案底下寫入文字(void方法)
import java.io.FileWriter;

public class Hrad30_寫入txt文字檔 {

	public static void main(String[] args) {
		try {
			//(1)創一個文字檔並且寫入檔案
		FileWriter writer = new FileWriter("dir1/Brad.txt"); //在dir1目錄底下創造一個Brad.txt
		writer.write("大家好我式HANK"); //用爺爺的方法write,寫文字
		writer.flush();
		writer.close();
		System.out.println("建造檔案同時寫入文字成功");
		}catch (Exception e) {
			System.out.println(e.toString());
		}
	}

}
