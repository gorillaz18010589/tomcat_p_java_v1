package app;

import myja.Hrad25;

public class Hrad05 {
	public static void main(String[] args) {
		//當出現""裡面的HANK自動產生一個物件,當看到"hank"一樣自動把位置都給它們所以一樣,他沒有用new所以指向相同,位置一樣,是不是相同物件
		String s1 ="hank"; //因為沒有new,拿到一個字串存入
		String s2 ="hank"; //其實這部分才是反常
		System.out.println(s1==s2); //有相等true
		
		
		// == 意思肚子裡面的東西是否一樣
		// S3物件裝的是記憶體位置,所以跟S4記憶體位置根本不同,所以==後當然不同
		//
		String s3 = new String("hank"); //new會有一個新的記憶體空間,當然不一樣
		String s4 = new String("hank");	
		System.out.println(s3==s4); //沒有相等false
		System.out.println(s3.equals(s4)); //比較物件裡面的內容,內容一樣但位置不一樣
		
		//都顯示false,因為這招並沒有改寫,
		Hrad25 obj1 = new Hrad25();
		Hrad25 obj2 = new Hrad25();//所以不是String類的equals 等於 ==
		System.out.println(obj1 == obj2);
		System.out.println(obj1.equals(obj2));
	}
}
