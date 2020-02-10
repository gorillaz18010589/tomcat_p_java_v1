package app;

import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;
//泛型的寫法,假設我先放HashSet<Integer>,那我裡面就只能放整數,不會出錯
//泛型:其實是指你想先丟進去的型別你可以先指定
////*set =>叫集合這組東西,裡面的東西不會重複,裡面東西是亂丟的,沒有再排第一第二三順序性,可以寫樂透
public class Hrad48_資料結構泛型 {

	public static void main(String[] args) {
//		HashSet<Integer> set = new HashSet<>();
//		set.add(123);
//		set.add("hi");//這邊會報錯因為我已經裝了Integer,卻塞字串不行
		
		//泛型整數出樂透6個號碼
//		HashSet<Integer> set = new HashSet<>();
		TreeSet<Integer> set = new TreeSet<Integer>();
		while(set.size() <6) { //當這個資料結構的元素小於6時
			int rand = (int)(Math.random()*49+1);
			set.add(rand);
		}
		System.out.println(set.toString());
		//用for each拿到裡面的元素
		for(Integer i :set) {
			System.out.println(i);
		}
	}

}
