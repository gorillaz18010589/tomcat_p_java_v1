package app;
//邊讀邊寫最慢,一個一個byte這樣讀
//FileInputStream(File file)=>read() 回傳值()
//目標把dir1的照片,複製到dir2用一個byte一個byte慢慢讀取必然很慢
//FileInputStream(File file) =>資料串流打開哪一個目錄
//這個程式比較沒效率,因為一讀一寫,讀得比較快寫得比較慢,我已讀一值在等寫
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Hrad27 {

	public static void main(String[] args) {
	//先input資料 -> 一邊read我同時out put
	try {
			FileInputStream fin = //(1)資料先讀入
					new FileInputStream("dir1/coffee2.jpg" );
			FileOutputStream fout =//(3)輸出資料
					new FileOutputStream("dir2/coffee2.jpg");
			int b;
			while ((b = fin.read()) !=-1){ //把讀取得fin資料存入B
				fout.write(b); //寫出你讀的byte,讀一格寫一個
			}
			fout.flush();
			fout.close();//也要關
			fin.close();//有開有關
			System.out.println("完成");
		}catch (Exception e) {
			System.out.println(e.toString()); //有錯誤的化印出錯誤名稱
		}
	}

}
