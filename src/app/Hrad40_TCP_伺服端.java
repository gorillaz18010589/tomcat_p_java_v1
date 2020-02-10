package app;
import java.io.InputStream;
import java.net.InetAddress;
//伺服器用串流方式
//java.net.ServerSocket.ServerSocket(int port) :伺服器端建立ServerSocket(port號)
//java.net.ServerSocket.accept():伺服器端開始聽接收(回傳Socket)
//java.net.Socket.getInetAddress()://取得對方ip(回傳InetAddress )
//java.net.Socket.getInputStream()://取得用戶端的訊息串流(回傳InputStream)
//java.io.InputStream.read(byte[] b) //用串流方式read讀黨,當read讀黨部等於-1繼續讀(回傳int)
//java.lang.String.String(byte[] bytes, int offset, int length)://String(buf資訊,從0開始,buf.lentgth檔案多打讀多大)
//伺服器建立好後cmd打netstat /na,看是否出現7777port號,執行後出現7777
import java.net.ServerSocket;
import java.net.Socket;

public class Hrad40_TCP_伺服端 {

	public static void main(String[] args) {
		try {
			ServerSocket server = new ServerSocket(7777);//伺服器端建立ServerSocket(7777號)
			Socket socket =	server.accept(); //伺服器端開始接收用戶端訊息
			
			InputStream in = socket.getInputStream(); //取得用戶端的訊息串流,存入in
			InetAddress urip = socket.getInetAddress(); //取得對方ip
			
			int len; byte[] buf = new byte[1024]; //read(讀byte陣列) 回傳int:len
			while((len = in.read(buf))!= -1) {  //用串流方式read讀黨,當read讀黨部等於-1繼續讀
				System.out.println(urip + ":" + new String(buf, 0, buf.length)); //String(buf資訊,從0開始,buf.lentgth檔案多打讀多大)
			}
			
			
			server.close();
			System.out.println("伺服器接收OK");
		}catch (Exception e) {
			System.out.println(e.toString());
		}
	}

}
