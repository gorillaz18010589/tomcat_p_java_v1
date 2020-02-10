package app;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
//目標抓到網頁PDF功能
//透過轉網MY url Pdf
//特色是把網頁轉成pdf
//目標是我要利用他的服務,所以看對方的頁面原始碼 action="/index.php name="url"
//發現他的from 網頁參數是url,連接的是index.php
//所以在他網頁https://pdfmyurl.com/"index.php"?"url"=https://www.gamer.com.tw/
//發現url後面輸入他的網指就有效果

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

public class Hrad43_3_URL_連接人加寫好的功能網頁 {

	public static void main(String[] args) {
		try {
			String web ="www.bradchao.com";
			URL url = new URL("https://pdfmyurl.com/index.php?url="+ web);//竊取對方網站功能
			HttpURLConnection conn =  (HttpURLConnection)url.openConnection(); //取得url.連線強制轉型成http連線
			conn.connect();//取得連線
			
			//把網頁圖片串流抓下來
			BufferedInputStream bin =
					new BufferedInputStream(conn.getInputStream()); //conn(這個頁面的http網指)用buffer館子接
			//把抓下來的檔案輸出到我dir1底下
			BufferedOutputStream bout=
					new BufferedOutputStream(new FileOutputStream("dir1/brad.pdf")); //buffe館子比較快,把檔案輸出到dir底下
			//同時賭寫檔案
			int len; byte[] buf = new byte[4096];
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
