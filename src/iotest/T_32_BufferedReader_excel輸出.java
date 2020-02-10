package iotest;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class T_32_BufferedReader_excel輸出 {
	//文字檔會希望是字串,也需要換列
	//目的讀取excel資料,用BufferedReader => readline()功能
	//(1)execl副檔名改CSV
	//(2)把資料剪貼到你要做的資料夾
	//觀念:串了三根管子,最終使用最後管子的功能,中間館子只是轉換
	//舉例:想喝一杯好茶:(1)水壺裝接水在燒(2)要拿裝有茶葉的茶壺來裝熱水(3)最後拿公杯來裝(4)最後到在小杯子裡
	////Reader =>read(CharBuffer target):用管子慢慢串聯
	//(1)第一根管子Java.io.FileInputStream :FileInputStream(File file) :建構式直接接到檔案(file)拿到後轉成爸爸InputStream
	//(2)第二根管子Java.io.InputStreamReader(InputStream in) :將InputStream管子轉成爸爸Reader,到這邊已經式Readr再來一根
	//(3)第三根管子 java.io.BufferedReader(Reader in) :將拿到的reader塞進去 就可以他裡面的readLine() 一次一列,串接概念
	//java.io.BufferedReader=>readLine():一次讀一列(回傳String) ,會拿到一行部不含換列符號,如果讀到null就結束
	//java.lang.String.split(String regex): 字串切割回傳(String[]陣列)
	public static void main(String[] args) {
		try {
		//清楚寫法流程	
//		FileInputStream fin = new FileInputStream(""); //第一根拿到dir1/books.csv位置轉成InputStream
//		InputStreamReader ir = new InputStreamReader(fin);//第二根拿到Reader
//		BufferedReader br = new BufferedReader(ir);/ /第三根Reader放進去拿到BufferReader就可以用Readline(換行)
		
		BufferedReader br =
			new BufferedReader(
				new InputStreamReader(
					new FileInputStream("dir1/book.csv")));
			
			String line = null;
			while((line = br.readLine()) != null) { //當null不為0時,抓到的excel(br),每次讀取一行,存入line字串裡
//				System.out.println("==>" +br); 看一下資料有讀近來
				String[] row = line.split(",");  //把excel的逗號去掉,存放到Row陣列
				System.out.println("Name:" + row[0]); 
				System.out.println("Birthday:" + row[1]);
				System.out.println("ID:" + row[2]);
				System.out.println("Age:" + row[3]);
			}
		
		    br.close();
		}catch (Exception e) {
			System.out.println(e.toString());
		}
	}

}
