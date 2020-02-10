package app;
import java.io.ObjectInputStream.GetField;
import java.io.OutputStream;
//ServerSocket 跟Socket
//TCP -socket連線後用串流來傳送,TCP傳送檔案資料才是重點
//先玩用戶端只要SOCKET就可以
//寫一個迴圈 從0~65535看哪一個pot願意跟你講話,有願意就可以進去
//http相同網段,就明碼的帳號密碼都查的到
//39用乎端發送端
//一邊SEVER端,一邊CL端
//企圖跟對方連線,不見得對方願意
//cl端直接用SVER的SKET,如果SVER段願意裡我SVER端就會回傳SKET
//此時就是SEKT跟SKET溝通
//拿到sket後用如果是伺服器端你會拿到	getInputStream()
//拿到sket後如果是用戶端,伺服器端願意跟我講話就會拿到getInputStream()
//java.net.Socket.Socket(String host, int port) :建立一個用戶端Socket (連線主機,port號)
//java.net.Socket.getOutputStream()://socke.取得發送串流,存入outs(回傳OutputStream)
//java.lang.String.getBytes()://wirte資訊(強制轉成byte資料)
//java.net.InetAddress.getByName(String host):取得對方ip(InetAddress)
import java.net.InetAddress;
import java.net.Socket;


public class Hrad39_Tcp_用戶端 {

	public static void main(String[] args) {
		try { //7777port號,不理我 ,80有開放,可以寫一個迴圈看0-65535有哪個port願意跟我連線
	//		Socket socket = new Socket(InetAddress.getByName("www.iii.org.tw"),7777); //企圖跟這個soket的ip跟prot號建立Socket
			Socket socket = new Socket(InetAddress.getByName("192.168.43.138"),7777);//連線ip伺服器
			
			//連線成功後,輸入資料
			OutputStream outs = socket.getOutputStream();//socke.取得發送串流,存入outs
			outs.write("你好呀".getBytes()); //wirte資訊(強制轉成byte資料)
			outs.flush(); //輸出串流沖出
			outs.close(); //輸出串流有開有關
//			System.out.println("OK");
			socket.close();//有開有關
		}catch (Exception e) {
			System.out.println(e.toString());
		}
	}

}
