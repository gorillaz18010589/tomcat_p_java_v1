package app;

public class Hrad10_StringBuffer {

	public static void main(String[] args) {
//		StringBuffer sb = new StringBuffer();
//		StringBuffer sb2 = sb.append("Hello,World");
//		System.out.println(sb == sb2);
//		sb.append("123")
//		.append("OK")
//		.replace(0, 3, "Brad");
//		
//		System.out.println(sb);
		
		StringBuffer sb = new StringBuffer(); //產生一個Stringbuffer物件用此資料型態
		sb.append("hello world"); //直接後面加字串
		System.out.println(sb);   //可以直接印出因為已經是STRINGBUFFER 
		StringBuffer sb2 = sb.append("hello world"); //把這個記憶體位置內容存到SB2 
		System.out.println(sb==sb2); //同樣位置所以TRUE
		sb.append("hi") 
		.append(12)  //快速增加append方式
		.append(34)
		.replace(0, 3, "Brad"); //意思是0-3的4個位置,改成Brad字串
		System.out.println(sb);

	}

}
