package app;
//cmd => set指令可以看路徑
//java有跨平台一樣可以寫在其他平台
//路徑也是檔案的觀念,路徑本身也佔有空間,只是型態是資料夾
//C:是絕對路徑一般比較少這樣寫,建議寫相對路徑
//檔案總管裡面所做的操作行為,改名字,創新資料夾,都在File包裡玩
//SRC是寫原始檔,所以不要在裡面創資料夾,要的話再跟目錄new一個新的資料夾
//java.io.File => static(方法) pathSeparator:路徑搜尋符號(;)(回傳String) 
//java.io.File => static(方法) separator://windows印出\ ,mac印出/(回傳String) 
//java.io.File => static(方法) pathSeparatorChar:(回傳char)
//java.io.File => static(方法) separatorChar:(回傳char)
//java.io.File => File(String pathname) (建構式):File("dir\c")
//java.io.File => listRoots():列出有幾個根看執行環境有幾個(回傳 File[]檔案陣列)
//java.io.File.getAbsolutePath():決對路徑 (回傳File)
import java.io.File;

public class Hrad23 {

	public static void main(String[] args) {
		System.out.println(File.pathSeparator); //印出;代表你是windows,mac印出:
		System.out.println(File.separator); //windows印出\ ,mac印出/
		
//		File file = new File("C:\\brad\\dir3"); //在字串裡面用\/代表跳脫字元,後面加的是要跳脫的東西(要兩根\\麻煩)
		File file = new File("C:/brad/Test3"); //正確方式用/用mac方法
		System.out.println(file.exists());   //查詢這個檔案是否存在,物件是物件觀念,但東西有沒有是另一回事
		
		File[]roots = file.listRoots();
		for(File root : roots) { 
			System.out.println(root.getAbsolutePath());//印出C, windos多根系統,印出C隨身碟可以多E	
		}
	}
}
