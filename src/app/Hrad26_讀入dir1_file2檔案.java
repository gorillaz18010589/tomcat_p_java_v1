package app;
//FileInputStream(File file) =>FileInputStream fin = new FileInputStream("dir1/file2"); 
//通過打開一個到實際檔案的連接來創建一個 FileInputStream，該檔案通過檔案系統中的 File 物件 file 指定。
//FileInputStream(FileDescriptor fdObj) 
//通過使用檔案描述符 fdObj 創建一個 FileInputStream，該檔案描述符表示到檔案系統中某個實際檔案的現有連接。
//FileInputStream(String name) => FileInputStream fin = new FileInputStream("dir1/file2"):讀取dir1底下的file2檔案
//通過打開一個到實際檔案的連接來創建一個 FileInputStream，該檔案通過檔案系統中的路徑名 name 指定。
//read():(回傳int)
//一次讀一個byte,如果讀到-1代表已經到尾巴讀完了
//read(byte[] b) :(回傳int)
//從此輸入串流中檔案中將最多 b.length一個byte的資料讀入一個 byte 陣列中。
//read(byte[] b, int off, int len) :(回傳int)
//從此輸入串流中檔案中將最多 len 個位元組的資料讀入一個 byte 陣列中。
//String(byte[] bytes, int offset, int length)
//字串(陣列),(從己開始),(多長)
//用utf-8占三個byte,所以一開始你new byte[2];只占兩個讀起來是亂碼

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Hrad26_讀入dir1_file2檔案 {

	public static void main(String[] args) {
		try {
//			FileInputStream fin = new FileInputStream("dir1/file3");//file3一不存在所以讀取,找不到所以會出現//java.io.FileNotFoundException: dir1\file3 (系統找不到指定的檔案。)
			FileInputStream fin = new FileInputStream("dir1/file2"); 
			
			
			//(3)一次讀完用這招read(byte[] b, int off, int len),這招建議讀一般檔案,不適合讀文字
//			byte[]buf =new byte[2]; //宣告一個陣列一次讀兩個 ,但UTF-8占3個byte所以你讀兩個會亂碼
			byte[]buf =new byte[3]; //宣告一個陣列一次讀三個
			int len;

				while((len = fin.read(buf)) != -1) {
					System.out.print(new String(buf,0,len));
				}
			
			//(2)一次讀完裡面的檔案,因為Read如果讀到-1代表結束,一個一個讀完
//			int c;
//			while((c = fin.read()) != -1) { //所以當fin讀取的檔案不等於-1就會繼續讀,直到讀完顯示-1後就會跳出迴圈
////				System.out.println(c); //因為傳是int用下面的方法
//				System.out.print((char)c); //一開始傳回是Int我強制轉型成char就可以印出字元			
//			}
			
			//(1)read一次讀一個byte,read第二次指標往下讀第二個byte
//			int c1 = fin.read(); //宣告一次讀一個byte,宣告第二次指標到第二個byte
//			System.out.println(c1); //第一個字是A(asic碼97)
//			int c2 = fin.read();
//			System.out.println(c2); //第二個字是B(asic碼98)
			
			fin.close();
			System.out.println("讀取成功");
		}catch (FileNotFoundException e) { //FileInputStream("dir1/file3")小漁網 
			System.out.println(e.toString());
		}catch (IOException e) { //close()大漁網
			System.out.println(e.toString());
		
	}
}
}
