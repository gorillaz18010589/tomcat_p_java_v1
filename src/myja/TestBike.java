package myja;

public class TestBike {

	public static void main(String[] args) {
////				bike b1; b1= new bike()
				bike b1 = new bike(3); //宣告要一台腳踏車= new產生一個新的記憶體,呼叫new bike()叫一台腳踏車來
//				//因為完成 =bike b1 = new bike(); 初始化東西清清楚楚不會不明不白
//				System.out.println(b1.speed); //	用double型態,自動給預設值所以0.0
//				b1.upSpeed();b1.upSpeed();b1.upSpeed();b1.upSpeed(); //踩了四次加速度後加速度是1.728
//				System.out.println(b1.speed);//
//				b1.downSpeed();b1.downSpeed();
//				System.out.println(b1.speed);//
//				//再來試著努力踩腳踏車,讓速度超過10
//				for (int i=0; i<=13; i++) { //用迴圈方式踩13次超過speed超過10
//					b1.upSpeed();
//				}
//				System.ntln(b1.speed);  //印出10.69印出10.69
				
				//老師方法直接改速度,但不合理你的腳踏車有可能一次到10嗎,哪一台腳踏車你看的到速度,你可以用肉眼判斷嗎,你並不知道速度多少,所以不合理,速度是外界不能隨便存取的
//				b1.speed = 10.1; 改了private speed後,這邊的speed看不到出紅單,看不到屬性,但方法可以,所以安裝時速表
//				System.out.println(b1.speed);
//					
//				System.out.println(b1.getSpeed());
				//裝時速表getSpeed後
				for(int i=0; i<=13; i++) {
					b1.upSpeed();
				}
				System.out.println(b1.getSpeed());
			}

		}