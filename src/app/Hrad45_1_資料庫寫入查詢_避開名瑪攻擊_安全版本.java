package app;
//目標用DriverManager.getConnection(String url, Properties info)方法取得資料庫連線
//第二防止名瑪攻擊:用安全性的方法查詢

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
import java.sql.PreparedStatement;
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

//pare增刪修,防止名瑪攻擊
//java.sql.Connection.prepareStatement(String sql)://預先準備的一個敘述句(sql指令,valuse,?)(拿到PreparedStatement)
//java.sql.PreparedStatement.setString(int parameterIndex, String x)://增刪修資料庫用字串方式(第一個?資料庫","添加Allen資料")(void方法)
//java.sql.PreparedStatement.executeUpdate():(回傳int) ://直接更新增刪修的資料庫(回傳Int)



public class Hrad45_1_資料庫寫入查詢_避開名瑪攻擊_安全版本 {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");		//啟用驅動程式
			//(1)把帳號,密碼,時區用參數方式添加上去
			Properties prop = new Properties(); //取得一個資料結構的物件
			prop.put("user","root"); //在這資料屬性上添加個你要設定的東西,與參數的值(user,root)
			prop.put("password","root"); 
			prop.put("serverTimezone","Asia/Taipei");  //設定時區
			Connection coon = DriverManager.getConnection( //取得連線
					"jdbc:mysql://localhost:3307/cust", prop);//連線資料庫("驅動程式的瑪+庫","參數")
			//(2)準備一個prae的敘述句,防止名瑪攻擊//增刪修動作
			
			PreparedStatement pstmt = coon.prepareStatement(//預先準備的一個敘述句(sql指令,valuse,?) (回傳PreparedStatement)
					"INSERT INTO brad (cname,tel,birthday) VALUES (?,?,?)"); //不管哪個型別都用問號
			//也可用迴圈方式讓他寫入10筆的資料進去
			pstmt.setString(1,"Allen"); //增刪修資料庫用字串方式(第一個?資料庫","添加Allen資料")
			pstmt.setString(2,"555");
			pstmt.setString(3,"1990-09-09");
			pstmt.executeUpdate(); //這個資料庫更新
			
			
			System.out.println("寫入資料成功");
		}catch (Exception e) {
			System.out.println(e.toString());
		}
	}

}
