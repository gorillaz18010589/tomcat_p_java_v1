package app;
import java.awt.BufferCapabilities.FlipContents;
import java.io.BufferedReader;
import java.io.FileInputStream;
//文字檔會希望是字串,也需要換列
//目的讀取excel資料,用BufferedReader => readline()功能
//(1)execl副檔名改CSV
//(2)把資料剪貼到你要做的資料夾
//觀念:串了三根管子,最終使用最後管子的功能,中間館子只是轉換
//舉例:想喝一杯好茶:(1)水壺裝接水在燒(2)要拿裝有茶葉的茶壺來裝熱水(3)最後拿公杯來裝(4)最後到在小杯子裡
////Reader =>read(CharBuffer target):用管子慢慢串聯
//(1)第一根管子FileInputStream :FileInputStream(File file) :建構式直接接到檔案(file)拿到後轉成爸爸InputStream
//(2)第二根管子InputStreamReader(InputStream in, Charset cs) :將InputStream管子轉成爸爸Reader,到這邊已經式Readr再來一根
//(3)第三根管子 BufferedReader(Reader in) :將拿到的reader塞進去 就可以他裡面的readLine() 一次一列,串接概念
//BufferedReader =>readLine():一次讀一列(回傳String) ,會拿到一行部不含換列符號,如果讀到null就結束
//lang=>String.=>String[]	split(String regex) 字串切割回傳String陣列
import java.io.FileReader;
import java.io.InputStreamReader;

public class Hrad32_execl讀取資料2 {

	public static void main(String[] args) {
		try {
		//(1)清楚介紹館子串接的方式
//		FileInputStream fim = new FileInputStream("dir1/Book.csv"); //先用地一根管子接檔案(file),拿到InputStream
//		InputStreamReader ir = new InputStreamReader(fim); //再拿InputStream放進去拿到爸爸Reader
//		BufferedReader br = new BufferedReader(ir); //最後把Readr放進去拿到 BufferedReader就可使用裡面的readline();
		
		//(2)簡略的正常寫法
		BufferedReader br =
				new BufferedReader(
						new InputStreamReader(
								new FileInputStream("dir1/Book.csv")));
					//(1)以下方法確認這個方式抓到的execl式一行一行印出來
						String line = null; //因為readLine()回傳字串
//					while ((line = br.readLine()) !=null) { //當null不為0時,抓到的excel(br),每次讀取一行,存入line字串裡
//						System.out.println("==>" + line); //印出==> bbb,B123456789,1998/2/3,55
		
					//(2)用字串切割
					while ((line = br.readLine()) !=null) { //當null不為0時,抓到的excel(br),每次讀取一行,存入line字串裡
					String[]row = line.split(",");
						System.out.println("Name"+row[0]);
						System.out.println("Birthday"+row[1]);
						System.out.println("ID"+row[2]);
						System.out.println("AGE"+row[3]);
					}
					br.close();
		}catch (Exception e) {
			System.out.println(e.toString());
		}	
	}
}