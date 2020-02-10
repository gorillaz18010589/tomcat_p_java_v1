package app;
//這隻目標:示範java.sql.DriverManager.getConnection(String url)連線方式
//1.載入驅動程式
//2.看api認明 java.sql用原生通用型,要連誰都可以java.sql  (Interface Connection)
//3.JAVA跟SQ通了之後要下指令,下指令的說法我們教你對這台Server做sql動作
//4.SQL增,珊,修,查 =>增刪修會異動資料叫更新資料庫,查就只是查詢而已
//增刪修:執行會更新叫Update
//查詢:叫Query
//mysql connector parameters JDBC =>語言直接連接資料庫,搜訊這個可以找到參數表
//ODBC是微軟做的很棒的東西
//搜尋電腦ODBC叫資料來源,C,java,還有各種伺服器這樣太亂了
//所以進行ODBC資料來源的管理,你MYSQL,MSQL讓我ODBC認識就好,寫程式的人也認識我就好
//你Sql任我出現一個DSN,再來各種語言看到DSN就認識了,但效能會慢一點

//java.sql=>Connection(Interface):是抽象必需靠透過DriverManager
////透過DriverManager.的三招getConnection,三招都很重要,來進行連接的動作
//java.sql.DriverManager.getConnection(String url):透過驅動經理人的get方法取得連線資料庫(回傳Connection)
//java.sql.DriverManager.getConnection(String url, Properties info)://連接資料庫配合Properties.put方法把資料掛上參數(資料庫驅動程式和庫,參數prop)(回傳 Connection)
//java.sql.DriverManager.getConnection(String url, String user, String password):連接資料庫(驅動程式,帳號,密碼)(回傳 Connection)
//java.lang.Class.forName(String className) :啟動外部的mysql驅動程式 (回傳Class<?> )
//java.sql.Connection.createStatement():創造一個敘述句可以讓我下達Sql的指令  (回傳Statement)
//java.sql.Statement.execute(String sql):執行一道sql的指令 (回傳boolean)
//java.sql.Statement.executeUpdate(String sql) ://執行一道增刪修的sql指令,動到資料庫所以用Update(回傳int)

//設時區方式搜尋mysql jdbc serverTimezone
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


public class Hrad44_1_連接資料庫_方法1_觀念大全 {
	
	public static void main(String[] args) {
		//1.載入驅動程式
		try { //com.mysql.cj.jdbc.Driver =>mysql驅動程式名稱
			//自從JAVA8後,你本身只要有把驅動成式載入進去就好,這行可以不用下,因為它會自動載入驅動程式
			Class.forName("com.mysql.cj.jdbc.Driver");//透過類別的類別.forname方法將驅動程式名稱字串擺進去,啟動驅動程式
			
		//(2)連接我的資料庫,帳密,時區
			Connection conn = DriverManager.getConnection(//透過驅動經理人,取得連線實作,再存入Connection
					"jdbc:mysql://localhost:3307/cust"+ //jdbc:(連接)mysql:(再來接主機):3307/連你要的庫
					"?user=root&password=root&serverTimezone=Asia/Taipei"	); //?就是帶參數的意思,輸入帳號密碼/時區
			
		//(3)拿到連線的物件實體,後創造敘述句,用一道命令式的方式新增sql指令,把資料寫入資料庫	
			Statement stmt =conn.createStatement(); //拿到這個連線的敘述句,可以下達指令存入Statement(聲明)
//			stmt.execute(sql)://執行一道sql的指令
			stmt.executeUpdate(//執行一道增刪修的sql指令,動到資料庫所以用Update
				"INSERT INTO brad (cname,tel,birthday) VALUES ('hank','123','1990-04-05')"	);  //在brad資料夾底下的三個欄位,分別新增了名字,電話,生日
			
			System.out.println("驅動程式啟動成功");
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		

	}

}
