package app;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
//目標:UDP發送
//可用性線上遊戲,即時位置
//只要看到Datagram系列就是屬於UDP
//DatagramSocket:建立一個插座,先找到插座才有電流傳送過來
//目的由一台電腦傳到另一台電腦,傳送資料,有兩台Socket
//那面牆壁有充電,但你還是要找到一個插座,所以本機這邊要有一個Socket,對方也是
//封包:上面一訂有目的地的位置,還有重要資訊讓路由器去走
//路由器:看到你的資料來源,和你想去的地方,來決定你要去哪,只知道下一站封包器去哪
//對方有一個封包:類似信箱等你的封包來有就收到
//一個ip位置只會在一台電腦上面,但是一個電腦可以申請多個Ip
//發送端用哪個建構是都可以
//接收端就要特定的port號,像郵局窗口一樣
//(1)所以最後挑第一個DatagramSocket():
//port有60000多個port
//DatagramSocket():我會建構一個Socket綁訂在any available port號給你,這邊不講所有都聽(建構式)
//DatagramSocket(int port):綁定在他所指定的port號類似油箱(建構式)
//DatagramSocket(int port, InetAddress laddr):綁訂在特定的port號,跟ip位置,我加有錢很多ip,我只想綁在特定port上面(建構式)
//DatagramSocket(SocketAddress bindaddr):這是也是另外一種ip位置但較少用(建構式)

//玩實驗避開1024的範圍,小於1024是預設,網頁80,發送郵件25;,收信110;,Dns53;,ptt23;,ftp:21,22;
//最後避開使用8888

//封包建構式分成兩類
//發送需要有ip這樣就分類,你發送要寫信,寫信一定要有地址,你騙人加我在哪都可以,只是拿步道回信而已
//接受只要空包就可以,不用ip
//DatagramPacket(byte[] buf, int length):
//DatagramPacket(byte[] buf, int length, InetAddress address, int port):創一個封包(資料)(長度)(ip)(port號)
//DatagramPacket(byte[] buf, int offset, int length):
//DatagramPacket(byte[] buf, int offset, int length, InetAddress address, int port):
//DatagramPacket(byte[] buf, int offset, int length, SocketAddress address):
//DatagramPacket(byte[] buf, int length, SocketAddress address):
//java.net.DatagramSocket.send(DatagramPacket p) :socket.送出(封包) (void方法)

public class Hrad37_UDP_發送 {

	public static void main(String[] args) {
		String data ="Hello,world"; //物件資料把訊息存進去
		byte [] buf = data.getBytes(); //資料轉成byte陣列存進去buf裡
		try {
		DatagramSocket Socket = new DatagramSocket();//創建Socket
		DatagramPacket Packet = new DatagramPacket( //創建封包
				buf, buf.length, InetAddress.getByName("192.168.43.138"), 8888); //資料,資料有多長就多長全送,對方的ip,破號
				
		Socket.send(Packet);//資料由Socket發送,送電郵插座送,插座傳送(封包)
		Socket.close();//有開有關
		System.out.println("資料發送成功");
		}catch (Exception e) {
			System.out.println(e.toString());
		}
	}

}
