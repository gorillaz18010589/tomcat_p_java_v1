package iotest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
//(1)目標你檔案多大我就多大先讀好
//(2)再來把讀好的檔案直接寫出來
//因為陣列長度file.leeng只能回傳long,所以最多抓2G的檔案
//如果超過2G檔案會掛掉
//File(String pathname :檔案位置
//FileInputStream(File file) =>資料串流打開哪一個目錄,用file方法檔案資訊更完整
//FileInputStream=>read(byte[] b):讀取方式以陣列大小
//FileOutputStream =>write(byte[] b):寫入陣列大小的資料
public class T_29檔案大小跟臉篷一樣讀取寫方式 {

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
	try {
		//讀取檔案讀的檔案大小跟臉篷一樣
		File surce = new File("dir1/coffee2.jpg"); //所以先寫好file(dir1/coffee.2.jpg)存入surce
		FileInputStream fin = new FileInputStream(surce); //因為要檔案的大小資訊所以用這招(File file)
		byte[] buf = new byte[(int)surce.length()];//用byte朕列方式,直接存入soure.length代表檔案大小跟要寫的一樣,因為length回傳是long轉乘int,這種方式最多2G檔案
		fin.read(buf); //因為檔案跟你讀的一樣大所以不用做迴圈
		fin.close();
		
		//輸寫檔案
		FileOutputStream fout = new FileOutputStream("dir2/coffee2.jpg");
		fout.write(buf);
		fout.flush();
		fout.close();
		
		System.out.println("讀黨寫黨成功,檔案大小一致");
		}catch (Exception e) {
		System.out.println();
		}
		System.out.println(System.currentTimeMillis() -start); //只花16秒
	}

}

