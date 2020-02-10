package app;

import java.net.InetAddress;

//*透過網際網路最重要的就是"交換資料"
//*你要交換的資料是誰網際網路我們會透過"IP"知道對方是誰
//*java.net.InetAddress :負責管ip位置的包,有實做序列化,沒有建構式,所以式靠static方法拿到物件實體化
//*因為執行環境的條件不同,所以給你建構式式沒意義的,所以只用static方法得到物件實體
//*依照你的環境得到你的物件實體,資料庫也是類似這種方式
//java.net.InetAddress.getByName(String host):取得主機名稱(www.iii.org.tw) (static方法取得物件實體InetAddress)
//java.net.InetAddress.getLocalHost():取得本地主機ip (static方法取得物件實體InetAddress)
//java.net.InetAddress.getAllByName(String host) :取得所有的主機名稱 (回傳InetAddress[] 陣列)
//www.iii.org.tw (主機名稱)
//InetAddress ip = InetAddress.getByName("www.iii.org.tw"); //輸入後會查詢你用戶端的電腦你自己這台腦,如果沒有找到就會找你的dns
//中華電信DNS:168.95.2.1  // GOGGLE: 8888.4444 
//DNS:就類似104查號台,你先撥過去問她號碼,拿到後再打電話
public class Hrad36_ip {

	public static void main(String[] args) {
		try {
//		InetAddress ip = InetAddress.getByName(""); //沒寫的話取得本地主機Ip,DESKTOP-MNV2ODA/192.168.43.138
//		InetAddress ip = InetAddress.getByName("www.iii.org.tw"); //輸入後會查詢你用戶端的電腦你自己這台,輸入資策會的本基名稱網域
//		InetAddress ip = InetAddress.getByName("www.google.com"); //172.217.24.4
//		InetAddress ip = InetAddress.getByName("www.microsoft.com"); //23.210.238.119
//		InetAddress ip = InetAddress.getByName("192.0.3.4");輸入這樣也能連主機,且隨便亂打但格式正確,一樣沒有出現例外,不代表你會連到那台主機
		InetAddress ip = InetAddress.getByName("300.10.3.4"); //因為格式不對所以拋出UnknownHostException:的例外
		
		
		System.out.println(ip.getHostAddress()); //取得這個主機的ip
		
		//取得所有主機的ip方法
//		InetAddress[] ips = InetAddress.getAllByName("www.hinet.net");
//		for(InetAddress ip:ips) {
//			System.out.println(ip.getHostAddress()); //取得這個主機的ip
//		}
		
		
		}catch (Exception e) {
			System.out.println(e.toString());
		
		}
	}

}
