package app;

import myja.TWID;

public class Hrad06 {

	public static void main(String[] args) {
		//舊版規劃
//		String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
//		if(letters.contains("A")) { //contains("A") 檢查字串是否有包含A,有的化傳回布林直
//			System.out.println("有包含A");
//		}else {
//			System.out.println("沒有包含");
//		}
//	 TWID.m1(); //用static叫方法,但卻不需要物件實體化,方便使用如下
//		System.out.println("0123456789".substring(0,3));
//		System.out.println("b123456789".charAt(0)); //抽取到第0瑪位置B
		
//		 TWID T1 = new TWID(true,2); //檢查是否有抓到第一個字chat型態轉string A,檢查第二個字是否男生女生
		 
		 TWID id1 = new TWID();  //隨機產生身分證字號
		 TWID id2 = new TWID(false); //產生女生身分證字號
		 TWID id3 = new TWID(7);	//填數字產生地區身分證字號
		 TWID id4 = new TWID(true,17); //產生指定男生跟地區的身分證亂碼
		 TWID id5 = TWID.createTWID("H123593585");//這招是由TWID內部產生物件實體來呼叫
		 
		 System.out.println(id1.getId());
		 System.out.println(id2.getId());
		 System.out.println(id3.getId());
		 System.out.println(id4.getId());
		
		 if(id5 != null) { 
			 System.out.println(id5.getId());
		 }else {
			 System.out.println("身分證錯誤");
		 }
		
		//新版
//		if(TWID.checkId("H123594585")) { //這組身分證隊的化OK不對的化XX
//			System.out.println("身份證字號正確");
//		}else {
//			System.out.println("身份證字號錯誤");
//		}
	}

}
