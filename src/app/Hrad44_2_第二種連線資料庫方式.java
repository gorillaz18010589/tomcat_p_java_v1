package app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
//主要用getConnection(String url, String user, String password):連接資料庫(驅動程式的庫,帳號,密碼)(回傳 Connection)
//這招彈性較差

//java.sql=>Connection(Interface):是抽象必需靠透過DriverManager
////透過DriverManager.的三招getConnection,三招都很重要,來進行連接的動作
//java.sql.DriverManager.getConnection(String url):透過驅動經理人的get方法取得連線資料庫(一次打完帳號,密碼,時區)(回傳Connection)
//java.sql.DriverManager.getConnection(String url, Properties info):(回傳 Connection)
//java.sql.DriverManager.getConnection(String url, String user, String password):連接資料庫(驅動程式,帳號,密碼)(回傳 Connection)
//java.lang.Class.forName(String className) :啟動外部的mysql驅動程式 (回傳Class<?> )
//java.sql.Connection.createStatement():創造一個敘述句可以讓我下達Sql的指令  (回傳Statement)
//java.sql.Statement.executeUpdate(String sql) ://執行一道增刪修的sql指令,動到資料庫所以用Update(回傳int)

//設時區方式搜尋mysql jdbc serverTimezone
public class Hrad44_2_第二種連線資料庫方式 {
	
	public static void main(String[] args) {
		//1.載入驅動程式,其實可載可不載
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");	
			//(2)連接我的資料庫,帳密,時區
			//用這招方式DriverManager.getConnection(url, user, password) 資料庫驅動程式連接的庫,帳號,密碼
			Connection coon = DriverManager.getConnection(
			"jdbc:mysql://localhost:3307/cust?serverTimezone=Asia/Taipei","root","root");
				
		//(3)拿到連線的物件實體,後創造敘述句,用一道命令式的方式新增sql指令,把資料寫入資料庫	
			Statement stmt =coon.createStatement();
			stmt.executeUpdate(
					"INSERT INTO brad(cname,tel,birthday) VALUES ('呂熊貓','321','1992-03-27')");
			System.out.println("寫入資料庫成功");
			
		}catch (Exception e) {
			System.out.println(e.toString());
		}
	}

}
