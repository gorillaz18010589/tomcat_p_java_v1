package app;
//*最快但最多2G
//(1)目標你檔案多大我就多大先讀好
//(2)再來把讀好的檔案直接寫出來
//因為陣列長度file.leeng只能回傳long,所以最多抓2G的檔案
//如果超過2G檔案會掛掉
//java.io.File.length():讀檔案的大小(long)
//File(String pathname :檔案位置
//FileInputStream(File file) =>資料串流打開哪一個目錄,用file方法檔案資訊更完整
//FileInputStream=>read(byte[] b):讀取方式以陣列大小
//FileOutputStream =>write(byte[] b):寫入陣列大小的資料

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.zip.InflaterInputStream;



public class Hrad29_檔案跟臉篷一樣大讀取 {

	public static void main(String[] args) {
	try {	
		//讀取檔案讀的檔案大小跟臉篷一樣
		File soure = new File("dir1/coffee2.jpg"); //創建先寫好file(dir1/coffee.2.jpg)存入surce
		FileInputStream fin = new FileInputStream(soure); //因為要檔案的大小資訊所以用這招(File file)
		byte[] buf = new byte[(int)soure.length()]; //用byte朕列方式,直接存入soure.length代表檔案大小跟要寫的一樣,因為length回傳是long轉乘int,這種方式最多2G檔案
		fin.read(buf); //因為讀的檔案大小一樣,直接讀不用寫判斷式
		fin.close();//串流有開就有關
		System.out.println("讀取dir1/coffee2.jpg成功");
		
		//輸寫檔案
		FileOutputStream fout = new FileOutputStream("dir2/coffee2.jpg"); //要寫入串流的位置
		fout.write(buf);//在這個輸入串流底下(fout),把讀到的檔案(buf)寫入進去
		fout.flush();//資料沖掉
		fout.close();//串流關掉
		System.out.println("寫入dir2/coffee2.jpg成功");
	}catch (Exception e) {
		System.out.println(e.toString());
	}
	}

}
