package app;

import java.security.cert.CertificateException;
import java.security.cert.CertificateExpiredException;

import javax.security.auth.login.CredentialExpiredException;

//介紹例外Exception
//例外是可以處理的,錯誤是不能的
//地9行發生例外 
//這些例外都是發生在執行上的例外,叫值型例外(RuntimeException)其餘的叫Checked Exception(叫做要是先檢查的例外)
//RuntimeException不處理不罵你,後過自行負責

//int a = 10, b = 0;
//int c;
//int[] d = {1,2,3,4};
//
//try {
//	c = a / b;
//	System.out.println(c);
//	System.out.println(d[4]);
//	
//
//}catch(ArrayIndexOutOfBoundsException ae) {
//	System.out.println("Oops2!");
//}catch(ArithmeticException ae) {
//	System.out.println("Oops1!");		}
//System.out.println("Game Over");
public class Brad22 {

	public static void main(String[] args) {
		int a = 10 , b=3; //b=3;
		int c;
		int[]d = {1,2,3,4};
		try { //你發生有可能的例外,拋出來
		c = a /b;
		System.out.println(c);
		System.out.println(d[4]); //改成4因為超過陣列出線ArrayIndexOutOfBoundsException:
		}catch(ArithmeticException ae) { //如果發生例外catch抓到,處理ART數學ae先做這件事,再繼續跑
			System.out.println("出現例外!!!,先catch這邊,在繼續往下走");
		}catch (ArrayIndexOutOfBoundsException ae) { //陣列超過範圍
			System.out.println("超過陣列範圍");
		}
		System.out.println("例外跑在這邊印出game over");
		System.out.println("======================");
		
		//小鳥類別三種外力分別抓,小中大
		try {
			Bird b1 = new Bird();
			b1.setLeg(a);  
			}// catch(Exception e) { //用這個大例外捕手來抓,全部都抓得到
				
			//}
			catch (CertificateExpiredException e) { //小的警察 兒子
				System.out.println("抓到例外"); //先抓這個
			}catch (CertificateException e) { //中的警察 爸爸
				System.out.println("抓到第二例外"); //二抓
			}catch (Exception e) { //警察局長 爺爺
				System.out.println("有例外都跑這"); //最後全抓
			}
	}
}

class Bird {
	private int leg;
	//你下面講整個例外都可以拋出 可以嚴重的講,但不能少不能小,怕你拋得太大
	void setLeg(int n) throws CertificateException, CertificateExpiredException{//(抓這兩個的例外)
		if (n>=0 && n<=2) { 	//throws Exception{ //(throws宣告意思) Exception 我真的有說這招要是先檢查,你一定要加try
			leg = n;
		}else if (n <= 0){
			throw new CertificateException();
		}else if (n > 2) {
			throw new CertificateExpiredException();
		}
	}
}