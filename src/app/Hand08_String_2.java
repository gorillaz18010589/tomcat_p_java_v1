package app;

public class Hand08_String_2 {

	public static void main(String[] args) {
//	(1) .split(String regex) =>切割 ,回傳值是(String[])
	String line = "1,hank hot,台中市,1990-04-05";
	String [] fields =line.split(",");
		for(String field:fields) {
			System.out.println(field);
		}
		//目標是要網址跟參數=的值所以切割?
		//但是?被判斷為正規表示法出現例外
		//解決辦法是在?前面加\\代表不是正規表示法
		System.out.println("===========");
		String url =
		"http://www.google.com/index/php?name=brad&gender=male";
		String[]myurl = url.split("\\?"); //目前只切問號還要繼續
		String uu = myurl[0];  //切好的0段的先放在這
		System.out.println(uu); //印出0段http://www.google.com/index/php
		String[]params = myurl[1].split("&"); //再切後面1段& 放到params
		System.out.println(params);
		for(String s:params) {//再切斷,把=號切掉
			String[]data = s.split("="); //再切"="
			System.out.println(data[0] + "=>"+data[1]);//最後印出最後切玩的第三段0跟第三段1
		}
		
	
	}

}
