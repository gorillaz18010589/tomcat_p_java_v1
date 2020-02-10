package app;
//搭配42讀本地端圖片,用戶端發送照片
//網路跟硬碟速度差很多,所以直接先把資料讀完,在發送
//我們現在做的是一次性的三方交握,不是多次性的
//所以等下船上網路,只知道咖啡的內容,不知道檔名
//等下所傳的是檔案內容並不包刮檔名
//把本地端的檔案輸出給對方
//java.io.File.File(String pathname):創建檔案(建構式)
//java.io.BufferedInputStream.BufferedInputStream(InputStream in):較快得的輸入串流管子(建構式)
//java.io.FileInputStream.FileInputStream(File file):檔案串流館子(dir/coffe2.jpg)(建構式)
//java.io.File.length():檔案大小(回傳long )
//java.io.BufferedOutputStream.BufferedOutputStream(OutputStream out):較快的輸出串流館子(建構式)
//java.io.FilterInputStream.read(byte[] arg0):讀取檔案(回傳int)
//java.io.FilterOutputStream.write(byte[] b) :寫出檔案
//======================================================================
//java.net.Socket.Socket(InetAddress address, int port):建立使用者伺服器(要去的ip,根要去的port號)(建構式)
//java.net.Socket.getOutputStream():取得對方的輸出串流(回傳OutputStream )
//java.net.InetAddress.getByName(String host) :取得對方ip(回傳InetAddress )
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.InetAddress;
import java.net.Socket;


public class Hrad41_TCP讀本地檔_用戶端傳送 {

	public static void main(String[] args) {
		//(1)資料讀取讀取我本地端的圖片
		try {
			File source = new File("dir1/coffee2.jpg");
			BufferedInputStream bin =
				new BufferedInputStream(
					new FileInputStream(source));
			byte[] buf = new byte[(int)source.length()]; //讀取用read要byte陣列,回傳int所以牆轉,讀檔案有多大就多大
			bin.read(buf); //因為檔案跟讀取一樣不用while方式
			bin.close();
			
			//(2)沒例外的情況下要連到對方的網路,輸出照片
			Socket socket = new Socket(InetAddress.getByName("192.168.43.138"),9487); //連接對方伺服器
			BufferedOutputStream bout = //用BufferedOutputStream更好的館子,把你socket取得的get串流存入
					new BufferedOutputStream(socket.getOutputStream());
			bout.write(buf); //輸出串流寫出(buf照片檔)
			bout.flush();
			bout.close();
			System.out.println("傳送OK");
		}catch (Exception e) {
		System.out.println(e.toString());
		}	
	}

}
