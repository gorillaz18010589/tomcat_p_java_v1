package app;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

//串流,影音也有串流,直播也是一種串流
//OutputStream 輸出串流,是一種抽象類別,所以我去找兒子來時做且不是抽象的class找到以下
//FileOutputStream: new FileOutputStream("dir1/file2");把檔案連接到這個dir1串流創造一個file2目錄
//FileOutputStream(String name, boolean append):前面是(檔案名),後面改為true可以讓之後寫入的檔案,繼續添加在句尾上,類似log紀錄
//java.io.FileOutputStream.close() ://關閉串流。(void方法)
//java.io.FileOutputStream.flush() ://把輸出串流緩衝區的資料衝出去。(void方法)
//java.io.FileOutputStream.write(byte[] b) ://將陣列中的值輸寫進去但每次都重寫。(void方法)
//java.io.FileOutputStream.write(byte[] b, int off, int len) ://將指定 byte 陣列中從偏移量 off 開始的 len 個位元組寫入此輸出串流。(void方法)
//java.io.FileOutputStream.write(int b) ://將指定的位元組(asic馬)寫入此輸出串流 (寫97便a)。(abstract  void方法後代要實做出來)
//java.io.FileOutputStream=>FileOutputStream(File file):如果想要知道較多檔案資訊用此建構式(建構式)
//java.io.FileOutputStream=>FileOutputStream(String name):輸出串到此目錄下建立(dir1/file2)檔案,如果想要知道一般檔案用此方法,發現有拋出例外(建構祖宗不是runixo所以要try/catch式)
//*概念是有三個區域,
//1.java區域  :你在這裡oput 寫出串流他會先放到2的緩衝區
//2.buffe(緩衝區域):這邊緩衝區會依照CPU慢慢地轉到3檔案存放區
//3.(檔案存放區):檔案存放區存放你輸出的檔案,是最終放置的地方
//flush() :告訴CPU在你關閉之前,先沖一下緩衝區的檔案,跟隨身碟一樣你最後安全移出其中一個動作就是flush的概念,(卸載)
//close():你不關掉有可能會遺失資料,所以最後一定要關閉
//讀比較簡單

public class Hrad25_輸出串流 {

	public static void main(String[] args) {
	try {
		
//		FileOutputStream fout = new FileOutputStream("dir1/file2"); //輸出串流連接到建立dir1/file2檔案存到fout裡,FileNotFoundException例外祖先不是run要做
		FileOutputStream fout = new FileOutputStream("dir1/file2",true); //後面加true,可以讓之後write寫的檔案添加在句尾,一值增加文字
		//把字串寫入檔案裡
		String str = "Hello 資策會\n"; //\n換列
		fout.write(str.getBytes()); //把字串轉成byte才能寫入檔案
		fout.write(str.getBytes());
		
		//用陣列方式寫入
		byte [] count = {97,98,99,100};
		fout.write(count); 
		
		//用int方式寫入一個字
		fout.write(97); //印出a,寫入的數字轉為ASIC碼
		fout.flush();
		fout.close();  //關閉串流
		System.out.println("OK"); //如果try沒例外代表OK
	}catch (Exception e) {
		System.out.println(e.toString()); //直接用最大補漁網抓例外就省略其他例外
	}
		
		
//	}catch (FileNotFoundException e) { //小漁網 這是FileOutputStream的例外
//		e.toString();
//	}catch (Exception e) { //大埔漁網這是 close();的例外
//	}

	}

}
