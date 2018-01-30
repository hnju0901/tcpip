package practice;

import java.util.Scanner;

public class Prob1 {

/*project: ws02
주민번호를 입력 받아 여자인지 남자인지를
판단 하시오
1) 주민번호 13자리를 입력 받는다.
2) 7번째 자리수의 숫자를 파악 한다.
3) 남자 인지 여자 인지를 출력 하시오*/
	
	
	public void RRN(String rrn) {
		
	}
	public static void main(String[] args) {
		System.out.println("주민등록 번호 13자리를 입력하세요>>");
		System.out.println("예시: 123456-1234567");
		Scanner sc = new Scanner(System.in);
		String rrn = sc.nextLine();
		char ch = rrn.charAt(7);
		System.out.println(ch);
		if (ch=='1'||ch=='3') {
			System.out.println("남성입니다.");
		}else if(ch=='2'||ch=='4') {
			System.out.println("여성입니다.");
		}else {
			System.out.println("잘못된 정보입니다.");
		}
		
	}
}
