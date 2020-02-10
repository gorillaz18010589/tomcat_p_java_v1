package app;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

import org.json.JSONArray;
import org.json.JSONObject;


//(1)農委api:https://data.coa.gov.tw/
//json []=>代表陣列
//json{}=>代表物件 key:value,
//(2)gift-農委會抓data下來建立好gift資料庫
//(3)下載json-jar=>json org jar下載 =>https://jar-download.com/artifacts/org.json
//(4)Donwosnd json jar 之後再myja做buld path組態設定加進來
//規劃資料庫命名盡量不要撞到關鍵字
//資料庫如果字多用text型別就不用講要多少字
//1連線等候,2.串流進來,3.資料讀取撈出來

//org.json.JSONArray.JSONArray(String source):
//org.json.JSONArray.length():(回傳int)
//org.json.JSONArray.getJSONObject(int index)://撈取JSON後Data物件的資料 (從第i個開始) (回傳JSONObject)
//org.json.JSONObject.getString(String key)://row取得的資料庫裡的id欄位row.getString("ID");(回傳String)
public class Hrad46_抓取api寫入資料庫 {

	public static void main(String[] args) {
		//(1)從url撈取資料連線後
		try {
			URL url = new URL("http://data.coa.gov.tw/Service/OpenData/ODwsv/ODwsvAgriculturalProduce.aspx");
			HttpURLConnection conn =(HttpURLConnection) url.openConnection(); //url的打開連線,轉型成http網頁存入conn
			conn.connect(); //連線
		//(2)因為抓回來Data資料是文字我用Bufferreader的readline招數,因為農委會的資料有換列,並且取得串流
			BufferedReader reader = //buffreader館子裝inputread館子再裝上抓到這個http的coon的串流
					new BufferedReader(
							new InputStreamReader(conn.getInputStream()));
			String line; StringBuffer sb = new StringBuffer(); //StringBuffe物件實體化,為了用append
			while ((line = reader.readLine()) != null) {
				sb.append(line); //直接把抓來的資料一行一行寫在後面
			}
//			System.out.println(sb.toString()); //因為拿到的是StringBuffer物件用toString轉成字串
			reader.close();
			
		//(4))呼叫自己寫的json解析方法
			parseJSON(sb.toString());

		}catch (Exception e) {
			System.out.println(e.toString());
		}
	}
	static void parseJSON(String json) { //(3)另外寫一個解jason解析的方法,程式不要太亂	
		try { //不是runtimeexction但是還是看看如果出錯會怎樣,自己加try/cautgh
			//連線資料庫
			Properties prop = new Properties();
			prop.put("user","root");
			prop.put("password","root");
			prop.put("serverTimezone","Asia/Taipei");
			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3307/cust",prop);
			
			PreparedStatement pstmt = conn.prepareStatement( 
					"INSERT INTO gift (gid,pname,feature,url) VALUES (?,?,?,?)"); //寫進gift表裡
			
			//資料庫查詢
			ResultSet rs = pstmt.executeQuery("SELECT * FROM gift"); //查詢資料庫拿到指標的觀念(輸入查詢sql句法)(回傳ResultSete結果)
			while(rs.next()) {
				String gid = rs.getString("gid"); //取得資料("從你命名的資料名")
				String pname = rs.getString("pname");
				String feature = rs.getString("feature");
				String url = rs.getString("url");
				System.out.println(gid + ":" + pname +"/" + feature);
			}
			
			////一開始data資料室陣列[]所以看待他用陣列,用JSONArray這招創造物件實體拿到資料
			//現在這個row就是拿到=>{"ID": "100", "Name": "銅鑼杭菊美人茶",} 資料
			JSONArray root = new JSONArray(json);
			for (int i=0; i<root.length(); i++) {//開始尋訪陣列資料
				JSONObject row = root.getJSONObject(i); //撈取JSON後Data物件的資料 (從第i個開始) (回傳JSONObject)
				String gid = row.getString("ID"); //row取得的id存到資料庫的gid李
				String pname = row.getString("Name"); //取得這個row的資料從("指定的key類似Name")(回傳String)//pname是我設定的資料庫名稱剛好存入進去
				String feature =row.getString("Feature");
				String url =row.getString("Column1");
//				System.out.println(pname); //印出所有name底下的value=>印出伴手禮名稱
//				System.out.println(root.length()); //查看這個Data資料裡面有幾筆
				
			//資料更新,如果開啟會在新增一次進去
//				pstmt.setString(1,gid);
//				pstmt.setString(2,pname);
//				pstmt.setString(3,feature);
//				pstmt.setString(4,url);
//				pstmt.executeUpdate();
			}
			
			System.out.println("撈資料後寫入資料庫成功");
			
		}catch (Exception e) {
			System.out.println(e.toString());
		}
		
		
	}
}
