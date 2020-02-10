package app;
//Http通訊協定抓網頁
//平常看網頁就是輸入URL送出後就是等,對方回什麼東西給我
//登入巴哈穆特後會拿到頁面原始碼,我的瀏覽器在依照W3的規格在變美的
//所以我們要拿到頁面原始碼,這也是一種爬蟲的行為
//等下我們是一次性的
//java.net.URL.URL(String spec) :給你一個網址拿到URL的物件實體(建構式)
//java.net.URL.openConnection() :產生一個連線的物件實體(回傳URLConnection )拿到URLC後底下有兩個字類別(我們要得式HTTP因為是抽象所以骨子裡就式HTTP強轉後就可用)
//javax.net.ssl.HttpsURLConnection: 連接http網路(建構式)
//java.net.URLConnection.connect() :連線(void方法)
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;

public class Hrad43_URL_網路api {

	public static void main(String[] args) {
		try {
			URL url = new URL("http://www.bradchao.com"); //取得URL物件實體連線(rel網址)
			HttpURLConnection conn =  (HttpURLConnection)url.openConnection(); //取得url.連線強制轉型成http連線
			conn.connect();//取得連線
			
			BufferedReader reader = //因為要抓網頁原始碼,所以是字串要換行用bufferreade
			new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line = null; int i =1;
			while((line = reader.readLine()) != null) {
			System.out.println(i++ + ":" +line);
			}
			reader.close();
			
			conn.getInputStream(); //輸入資料
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
