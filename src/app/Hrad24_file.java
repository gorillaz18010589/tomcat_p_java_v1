package app;
import java.io.File;
//先在dir1底下創一個子目錄
//java.io.File => File(String pathname) (建構式):File("dir\c")
//java.io.File.mkdir() : 創建資料夾(回傳boolean)
//java.io.File.mkdirs(): 創建多個資料夾(爸爸目錄有再一次創出祖宗八代資料夾)(回傳boolean)
//java.io.File.renameTo(File dest):(回傳boolean)
//java.io.File.createNewFile(): //創建一個file夾 (因為是throws IOException 所以要try/Catch) (回傳boolean)
//java.io.File.length(): (回傳long)
//java.io.File.renameTo(File dest):改檔案明子效果把同一跟目錄的檔案寫到另一個資料夾李(回傳boolean)
//java.io.File.canRead(): 可讀(回傳boolean)
//java.io.File.canWrite(): 可寫(回傳boolean)
//java.io.File.lastModified():代表檔案或目錄最後一次的修改時間(回傳long)
//可讀,可寫,可執行非常重要,這個被允許的可範圍在哪
//1.Access:(存取時間)  2.chacnge:(包含檔案名稱屬性內容被換)3. Modified:(只有修改內容)
public class Hrad24_file {

	public static void main(String[] args) {
		//在.這個目錄下的dir1/創一個dir11
//		File file = new File("."); // .=>代表朕代表你現在這層   ..=>代表回上一層
		File dir11 = new File("./dir1/dir11"); //一開始還沒創dir11
		System.out.println(dir11.getAbsolutePath()); //印出這層的絕對路徑
		
		//在.這個目錄下的dir1/創一個dir11
		if(!dir11.exists()) { //如果.dir4/dir1" =>如果這個目錄底下的dir4/有dir1不再的化(!)
			dir11.mkdir(); //創建資料夾
			System.out.println("創了");
		}else { //如果在的話
			System.out.println("此目錄以印出來存在了");
		}
		
		//創多個目錄
		File dir25 = new File("./dir4/dir3/dir4/dir5");  //dir3,4,5,本來不存在創建後一次多個
		if(dir25.mkdirs()) { //mkdirs =>一次再創建多個目錄 
			System.out.println("成功");
		}else {
			System.out.println("失敗");
		}
		
		//創要一個新的File夾檔案
		File file1 = new File("dir7/file1"); //本來dir7底下沒有file1
		try {
		file1.createNewFile(); //創建一個file夾 (因為是throws IOException 所以要try/Catch)
		}catch (Exception e) {
			System.out.println(e.toString());
		}
		
		//把資料夾內的照片移到別的資料夾
		//如果只是同一個C:只是換爸爸而已, 所以很快煥明子
		//這只是把檔案煥明子,並部是複製貼上的概念
		//是剪下貼上的概念
		File source = new File("dir1/coffee2.jpg"); //一開始咖啡照片來源
		File target = new File("dir2/coffee2.jpg"); //要移到咖啡照片的目的地
		source.renameTo(target); //把目錄dir1底下的照片移到 dir2底下
		
		
		
			
	}
}
