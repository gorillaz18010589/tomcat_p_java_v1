package app;

import java.io.FileReader;
//目標:讀取文字檔
//FileReader :爸爸還是InputStreamReader
//java.io.FileReader.FileReader(String fileName) : 要讀取的文字檔(("dir1/Brad.txt");)(建構是)
//InputStreamReader =>  read() :讀取回傳Int ,字元一個
//java.io.InputStreamReader.read() :字串可以換行還可以一次讀取 (傳回Int)
public class Hrad31_讀取文字檔案2 {

	public static void main(String[] args) {
		try {
			FileReader reader = new FileReader("dir1/Brad.txt");
			int ret; //因為read()回傳值是int這邊設int
			while((ret =reader.read()) != -1) { //
				System.out.println((char)ret); //印出字元轉型成char
			}
			System.out.println("成功讀取Brad文字檔");
			reader.close();
		}catch (Exception e) {
			System.out.println(e.toString());
	}
}
	}