package app;
//目標用DriverManager.getConnection(String url, Properties info)方法取得資料庫連線
//這招最好用
//mysql connector parameters JDBC =>語言直接連接資料庫,搜訊這個可以找到參數表
//ODBC是微軟做的很棒的東西
//搜尋電腦ODBC叫資料來源,C,java,還有各種伺服器這樣太亂了
//所以進行ODBC資料來源的管理,你MYSQL,MSQL讓我ODBC認識就好,寫程式的人也認識我就好
//你Sql任我出現一個DSN,再來各種語言看到DSN就認識了,但效能會慢一點

//java.util.Properties.Properties()://取得一個資料結構的物件(建構式)
//java.util.Hashtable.put(Object key, Object value)://在這資料屬性上添加個你要設定的東西,與參數的值(user,root)(回傳物件Object)

//java.sql.DriverManager.getConnection(String url, Properties info)://連接資料庫配合Properties.put方法把資料掛上參數(資料庫驅動程式和庫,參數prop)(回傳 Connection)(回傳 Connection)
//java.sql.Connection.createStatement():創造一個敘述句可以讓我下達Sql的指令  (回傳Statement)
//java.sql.Statement.executeUpdate(String sql) ://執行一道增刪修的sql指令,動到資料庫所以用Update(回傳int)
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;
//查詢resulet(api)
//absolute(int row):指標絕對位置(回傳boolean)
//java.sql.ResultSet.afterLast():指標移到最後面(方法)
//java.sql.ResultSet.beforeFirst():移到第一筆的前面(方法)
//java.sql.ResultSet.last():移到最後一筆(回傳boolean)
//java.sql.ResultSet.next() :移到下一筆資料,如果可以繼續就下一筆,沒成功就是到資料庫尾巴了(index名稱)(回傳boolean)
//java.sql.ResultSet.getString(int columnIndex)://取得資料庫String型別第index筆資料(index資料)/getString("cname")

//資料庫型別是有意義的,如果的資料庫是要運算那就用Int,如果不用類似身分證字號那就用char就好
//不要再程式裡面去處理資料庫的運算,你直接在資料庫裡面運算,下對Sql語法就好
//我們的java就是把資料庫的東西叫出來,做出來而呈現而已



public class Hrad44_3_重要連接方式_新增查詢 {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");		//啟用驅動程式
			//(1)把帳號,密碼,時區用參數方式添加上去
			Properties prop = new Properties(); //取得一個資料結構的物件
			prop.put("user","root"); //在這資料屬性上添加個你要設定的東西,與參數的值(user,root)
			prop.put("password","root"); 
			prop.put("serverTimezone","Asia/Taipei");  //設定時區
			
			//(2)連線用這招DriverManager.getConnection(String url, Properties info):
			Connection coon = DriverManager.getConnection(
					"jdbc:mysql://localhost:3307/cust", prop);//連線資料庫("驅動程式的瑪+庫","參數")
			
			//(3)資料庫新增資料
			Statement stmt = coon.createStatement(); //創造一個敘述句可以讓我下達Sql的指令  (回傳Statement)
//			stmt.executeUpdate( //執行一道增刪修的sql指令,動到資料庫所以用Update(回傳int)
//					"INSERT INTO brad (cname,tel,birthday) VALUES ('Eric','9487946','1996-04-5')");
			//(4)查詢資料庫資料
			ResultSet rs = stmt.executeQuery("SELECT * FROM brad"); //查詢資料庫拿到指標的觀念(輸入查詢sql句法)(回傳ResultSete結果)
			while(rs.next()) { //當你查詢的這個資料,如果還有下一筆,指標繼續往下走讀資料,沒有代表沒了跳出迴圈
				//如果你資料庫拿出來的資料沒打算運算那就用String拿出來呈現就好
//				String id =	rs.getString(1); //取得資料庫String型別第一筆(index資料庫列)
//				String cname = rs.getString(2);//印出第二筆資料
				String id = rs.getString("id"); //取得資料("從你命名的資料名")
				String cname = rs.getString("cname");
				String tel = rs.getString("tel");
				String birthday = rs.getString("birthday");
				System.out.println(id + ":" + cname +"/" + tel +"/" +birthday);
			}
			
		}catch (Exception e) {
			System.out.println(e.toString());
		}
	}

}
