package app;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
//目標Http通訊協定抓圖片檔存入
//Yahho抓圖片網頁要URL,所以又見複製圖片位址
//java.net.URL.URL(String spec) :給你一個網址拿到URL的物件實體(建構式)
//java.net.URL.openConnection() :產生一個連線的物件實體(回傳URLConnection )拿到URLC後底下有兩個字類別(我們要得式HTTP因為是抽象所以骨子裡就式HTTP強轉後就可用)
//javax.net.ssl.HttpsURLConnection: 連接http網路(建構式)
//java.net.URLConnection.connect() :連線(void方法)
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;

public class Hrad43_2_URL_抓網路圖片 {

	public static void main(String[] args) {
		try {
			URL url = new URL("https://s.yimg.com/ny/api/res/1.2/SY8sgSZXrkMPXuDgJ5SCvA--~A/YXBwaWQ9aGlnaGxhbmRlcjtzbT0xO3c9ODAw/https://media-mbst-pub-ue1.s3.amazonaws.com/creatr-images/2019-07/5aaff2a0-a2ed-11e9-9ee9-e0a2cec14a5a"); //取得URL物件實體連線(rel網址)
			HttpURLConnection conn =  (HttpURLConnection)url.openConnection(); //取得url.連線強制轉型成http連線
			conn.connect();//取得連線
			
			BufferedInputStream bin = //把網頁圖片串流抓下來
					new BufferedInputStream(conn.getInputStream()); //conn(這個頁面的http網指)用buffer館子接
			
			BufferedOutputStream bout=//把抓下來的檔案輸出到我dir1底下
					new BufferedOutputStream(new FileOutputStream("dir1/hank.jpg")); //buffe館子比較快,把檔案輸出到dir底下
			
			int len; byte[] buf = new byte[4096]; //同時賭寫檔案
			while((len = bin.read(buf)) != -1) {
				bout.write(buf, 0, len);
			}
			bout.flush();
			bout.close();
			bin.close();
			System.out.println("成功連到騎摩網頁把圖片抓下來存放在dir1底下");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}
