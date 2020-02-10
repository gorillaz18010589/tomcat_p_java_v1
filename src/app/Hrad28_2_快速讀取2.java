package app;
//*檔案大小用大臉篷自己決定 第二塊
//用陣列方式臉篷的大小,準備大臉篷來讀
//一次寫入陣列,從0一開始,一次讀你的長度
//通常讀的速度會比寫的還要快
//也是一讀一寫方式,但準備大臉篷,大面積的讀大面積的寫
//FileOutputStream=>write(byte[] b, int off, int len) ::寫入方式(讀取的檔案物件,讀取從什麼位置開始,讀多少長度)
// FileInputStream=>read(byte[] b):讀取方式以陣列大小
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Hrad28_2_快速讀取2 {

	public static void main(String[] args) {
	try {	
			FileInputStream fin= 
					new FileInputStream("dir1/coffee2.jpg");
			FileOutputStream fut=
					new FileOutputStream("dir2/coffee2.jpg");
			
			int len; byte[]buf = new byte [4096]; //byte陣列用4K大小
			while((len = fin.read(buf)) != -1) {//準備一個大臉篷準備4M,慢慢讀這個陣列4K大小,不等於-1繼續讀跟下面的血,讀玩遍-1跳出去
				fut.write(buf,0,len); //寫入檔案(讀取的檔案物件,讀取從什麼位置開始,讀多少長度)
			}
			
			fut.flush();
			fut.close();
			fin.close();
			System.out.println("照片複製成功");
		}catch (Exception e) {
			System.out.println(e.toString());
			// TODO: handle exception
		}
	}

}
