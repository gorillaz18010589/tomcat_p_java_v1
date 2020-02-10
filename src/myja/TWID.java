package myja;

public class TWID {
	//**加上static讓大家都看的到
	private static String  letters ="ABCDEFGHJKLMNPQRSTUVXYWZIO"; //照數字排列10-33,用取得位置例如0+10 =10 =A的方式
	
		//一開始目標是身份證字號產生器
	private  String id; //傭有一個身分證ID屬性
		//建構式
		//**難道你要寫4次嗎,維護性非常差,我們不這樣幹,因為邏輯應該是一樣的
		public TWID() {		//建構是無傳參數
//			this(); 呼叫本class其他建構式,讓他直接叫下面
			//責任推給下面的建構式
			//產生true跟false = boolean型值,就會跑到第二到建構式去
			this((int)(Math.random()*2)==0); //我目標是要得到true跟false但我用亂數產生0,1 =>0代表true,1就是false
		}
		public TWID(boolean isman) {//男女生確認,男生做一組給我		
			this(isman ,(int)(Math.random()*26)); //推給最後一個
		}	
		public TWID(int area) { //地區		
			this((int)(Math.random()*2)==0,area); //推給最後一個
		}	
		
		//現在是人家講男生女生以固定,地區也固定,接下來你該怎麼寫
		//身份證字號製造機
		public TWID(boolean isman , int area) {//性別加地區					
		//(1)人家會給你0~25的數字所以抽出來 area,目標抓到地區英文字 例:(H)	
//		String temp = Character.toString(letters.charAt(1)); 可抓到指定的字本來是char型態轉成string	
//		String temp = letters.substring(area,area+ 1); //抓到你輸入的數字跟區間配合tostring,ex如果輸入3舊是3,4區間抓3抓到英文字
		StringBuffer sb = new StringBuffer(letters.substring(area,area+ 1)); //創造一個新物件存入變成StringBuffer,目標是抓第一個英文字
		//(2)人家會給你性別true false 目標抓到(1)或(2)
//		temp += isman? "1":"2"; // 字串相加第一瑪英文+第二瑪 =>f1  如果是true(男生)跑1,不是跑2(女生)
//		System.out.println(f1);
		sb.append( isman? "1":"2"); //增加後面來的整數不是1舊是2
		//(3)後面7個數字隨便0~9的亂數
//		for(int i=0; i<7; i++) {temp +=(int)(Math.random()*10);} 
//		System.out.println(temp);
		for(int i=0; i<7; i++) {sb.append((int)(Math.random()*10));} //用append增加後面7個0-9的亂數
		//(4)最後一個數字是驗證碼0-9選一,那就用迴圈跑10圈看看哪個數字正確
//			for(int i=0; i<9; i++) {
//				if(checkId(temp+i)) { //如果檢查機制跑1~9如果最後一數字和到我就跳出結束
//					id = temp+i;  //最後得到的身分證+上(i)最後一碼 =>我們的屬性ID
//					System.out.println(id);
//					break;
//				}
//			}
		
		for(int i=0; i<9; i++) { //最後用迴圈檢查0-9的數字
			String temp = sb.toString(); //把StringBuffer和int亂數的資料型別,轉成String
			if(checkId(temp+i)) { //如果檢查機制跑1~9如果最後一數字和到我就跳出結束
				id = temp+i;  //最後得到的身分證+上(i)最後一碼 =>我們的屬性ID
//				System.out.println(id);
				break;
			}
		}
		}
		private TWID(String id) {  //建構式private屬性,只供內部使用
			//屬性叫ID,這邊參數也是ID,如果你講id會指最近德代表(String id)
//			//如果要講外面屬性ID => privtae String id;  那你要用this.id
			this.id = id;	// 你輸入的id參數存到變成這個class的屬性id
			//但因為回傳的是字串,如果亂打也可以,因為建構是沒有回傳值,做出來錯了就錯了
			//出現null不合哩,所以放棄這招
	}
		
		//提供一朝static方法,讓你的生身分證字號輸入,這種是有return的
		//如果你回傳的TWID是null不對的我讓你物件不要做出來
		//設計一個方法只有我能用
		public static TWID createTWID(String id) {//傳回twid TWID變成回傳值型別
			TWID temp = null; //如果是錯誤的
			if(checkId(id)) { //如果檢查你輸入的身分證號正確後跑下面
				temp = new TWID(id); //正確後讓上面那個方法只有我能用 物件實體化叫出上面的方法
			}
			return temp;
		}
		
		
		//(1)static的方法設計與物件無關,做一些方便使用快速的方法
		public static void m1() { //Static不需要物件實體,代表你不能亂玩,static方法寫到身分證裡面因為分類,math.randon直接就叫了,讓我們很快就用
			System.out.println("heloo world");
//			System.out.println("heloo world" + id); //加上id會錯誤,id是屬性的物件你沒有實體玩不到
		}
		//static方法
		//(2)//1.長度要10瑪 2.第一個字要英文 3.第二個數字不是1就是2男生女生 4.地3瑪到最後要是數字  //這些連近來都不用
//		public static boolean checkId(String id) { //針對你傳回來的id做檢查,回答的是boolean值
//			boolean ret =false;
//			if(id.length()==10) {//如果長度有10進來這裡
//		
//			}else {//這四條件都沒有的話直接false掉
//		
//			}
//			return false;
//		}
		 //新方法用正規表示法,讓你檢查id是否正確的簡單方便
		public static boolean checkId(String id) { //針對你傳回來的id做檢查,回答的是boolean值
			boolean ret =false;
			if(id.matches("[A-Z][12][0-9]{8}")) {//正規表示法有符合規則再進來,還沒判斷合不合理
//				String letters ="ABCDEFGHJKLMNPQRSTUVXYWZIO"; //照數字排列10-33,用取得位置例如0+10 =10 =A的方式
				char c0 = id.charAt(0); //這邊抓到的值是字援用char 配合indexof(int char)
				int n12 = letters.indexOf(c0)+10; //char 0-65都可以是int自動轉型  
//				System.out.println(n12); 檢測是否有抓到N12合格
				int n1 = n12/10;  //取得十位數
				int n2 = n12%10;  //取得個位數
				int n3 =  Integer.parseInt(id.substring(1,2)); // sub抓取1,2的範圍就是B,因為抓到是字串要轉成int
				int n4 =  Integer.parseInt(id.substring(2,3));
				int n5 =  Integer.parseInt(id.substring(3,4));
				int n6 =  Integer.parseInt(id.substring(4,5));
				int n7 =  Integer.parseInt(id.substring(5,6));
				int n8 =  Integer.parseInt(id.substring(6,7));
				int n9 =  Integer.parseInt(id.substring(7,8));
				int n10 =  Integer.parseInt(id.substring(8,9));
				int n11=  Integer.parseInt(id.substring(9,10));  //取n11是因為公事需要
				
				int sum = n1*1 + n2*9 +n3*8 +n4*7 +n5*6 +n6*5 +n7*4 //套入公式
						+n8*3+ n9*2 +n10*1 + n11*1;
//				System.out.println(sum); 看那組公有身分證是否90確認
				ret = sum % 10 ==0; //ret設布林直,所以如果合理的話回傳true到ret
			
			}
			return ret;
		}
		
		
		//普通物件方法
		public String getId() { //提供這方法讓你查身分證,
			//朕就是this 寶寶就是this 這邊this就是本類別的id
//			id = newid; 意思就是你傳回來的參數要存放道外面的id那用this
			this.id = id; //把傳回來的參數存道屬性的id
			return id;
		}
}
