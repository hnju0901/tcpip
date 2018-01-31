package server;

import java.util.List;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class ServerSender {

/*	public void printValue() {
		int number = 100;
		change(number);
		System.out.println(number);
	}

	public void change(int number) {
		number += number;
		System.out.println(number);
	}*/

public static void main(String[] args) {
	/*SercerSender sc = new SercerSender();
	sc.printValue();
	
System.out.println("/////");

	List<String> list =  new ArrayList<String>();
	list.add("1");
	list.add("2");
	list.add("3");
	list.add(2,"4");
	list.set(0,"5");
	list.remove(1);
	list.remove("6");
	int num = list.size();
	for(int cnt =0; cnt<num;cnt++) {
		String str = list.get(cnt);
		System.out.println(str);
	}
	System.out.println("///");
	String str = "lg cns vcc Phase i";//18ĭ
	System.out.println(str.substring(8, 11));
	System.out.println(str.indexOf("P"));
	System.out.println(str.charAt(12));
	System.out.println("///");
	System.out.println(Math.ceil(3.14));
	System.out.println(Math.floor(1.445));
	System.out.println(Math.round(5.63));
	System.out.println("///");
	
	*/
	String str = "A,B,C";//18ĭ
	StringTokenizer st = new StringTokenizer(str, ",");
	while(st.hasMoreTokens()){
		System.out.println(st.nextToken());
	}
}
}
