package app;
import java.net.DatagramPacket;
//配合39用戶端
//DatagramSocket():我會建構一個Socket綁訂在any available port號給你,這邊不講所有都聽(建構式)
//DatagramSocket(int port):綁定在他所指定的port號類似油箱(建構式)
//DatagramSocket(int port, InetAddress laddr):綁訂在特定的port號,跟ip位置,我加有錢很多ip,我只想綁在特定port上面(建構式)
//DatagramSocket(SocketAddress bindaddr):這是也是另外一種ip位置但較少用(建構式)

//DatagramPacket(byte[] buf, int length): //接收資料(buf,buf.length)
//java.net.DatagramPacket.getLength():取得封包大小(回傳Int)
//java.net.DatagramPacket.getData():取得封包資訊(回傳byte[])
//InetAddress java.net.DatagramPacket.getAddress() :取得對方封包ip
// CMD 打netstatc(網路狀態) /na (全部資料)   ,伺服器開啟後就會出現port號

import java.net.DatagramSocket;
import java.net.InetAddress;

public class Hrad38_DUP_接收端 {

	public static void main(String[] args) {
			byte [] buf = new byte [1024];//你決定一次要收多少大小,我決定1024
		while(true) { //無窮迴圈
			try {//創建插座與封包
				DatagramSocket Socket = new DatagramSocket(8888); //指定post號接收,類似郵箱 在8888等
				DatagramPacket Packet = new DatagramPacket(buf, buf.length);//(封包的資料設定1024,封包有多長就收多長)
				
				//接收中
				System.out.println("剛開始打開信箱接收中..");
				Socket.receive(Packet); //郵箱接收(封包),就真的在等妳封包,一直亮紅燈等封包
				System.out.println("接收後...");
				Socket.close();
				System.out.println("接收封包成功");
				
				//得到對方ip,大小,跟資訊
				InetAddress yours = Packet.getAddress(); //從接收的封包得到對方的位置
				int len =Packet.getLength(); //接收到的大小
				byte[] data =Packet.getData(); //接收到的資訊
				String msg = new String(data, 0, data.length); //字串(封包資訊,從0開始,有多大讀多大)
				System.out.println("IP:" + yours + msg); //印出ip+資訊+整包訊息整包來不會有亂碼
				
				if(msg.contentEquals("end")) { //如果你的文字訊息有end就break跳出無窮迴圈
					break;
				}
			}catch (Exception e) {
				System.out.println(e.toString());
			}
		}
	}

}
