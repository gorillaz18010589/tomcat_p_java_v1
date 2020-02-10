package app;
//伺服器接收圖片端對方是41客戶端
//你要先拿到網路上的資料,再去作出寫出的動作
//網路上拿到資料會比較慢,但曼在網路,所以同步做
//java.net.ServerSocket.ServerSocket(int port) ://創建伺服器(port:9487)
//java.net.ServerSocket.accept():伺服器開始連線聆聽(回傳Socket )
//java.net.Socket.getInputStream():取得用戶端的串流(回傳InputStream )
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;



public class Hrad42_TCP_伺服器端收圖片 {

	public static void main(String[] args) {
		try {
			//(1)連線網路
			ServerSocket server = new ServerSocket(9487); //創建伺服器(port:9487)
			Socket socket = server.accept(); //sever取得連線後,拿到socket存入進去socket
			System.out.println("伺服器接收中");
			
			//(2)對方的檔案串流存入
			BufferedInputStream bin =
					new BufferedInputStream(socket.getInputStream());//用buff館子比較快裝入,socket.get對方的檔案串流吋入到bin\
			
			//(3)把我接受到的串流寫出到dir2
			BufferedOutputStream bout =
					new BufferedOutputStream(new FileOutputStream("dir2/brad.jpg"));//把抓下來的檔案,寫到dir2底下
			
			//(4)讀取檔案
			int len; byte[] buf = new byte[1024*4096];  //準備一個這樣臉篷大小的空間
			while((len = bin.read(buf)) !=-1) { //當bin讀取buf的檔案大小速度不等於-1時
				bout.write(buf,0,len); //bout(輸出的檔案位置),writer寫出(寫出buf,0開始,檔案多長就多長);
			}
			bout.flush();
			bout.close();
			
			bin.close();
			server.close();
			System.out.println("照片寫入Dir2成功,伺服器關閉");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
