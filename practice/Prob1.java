package practice;

import java.util.Scanner;

public class Prob1 {

/*project: ws02
�ֹι�ȣ�� �Է� �޾� �������� ����������
�Ǵ� �Ͻÿ�
1) �ֹι�ȣ 13�ڸ��� �Է� �޴´�.
2) 7��° �ڸ����� ���ڸ� �ľ� �Ѵ�.
3) ���� ���� ���� ������ ��� �Ͻÿ�*/
	
	
	public void RRN(String rrn) {
		
	}
	public static void main(String[] args) {
		System.out.println("�ֹε�� ��ȣ 13�ڸ��� �Է��ϼ���>>");
		System.out.println("����: 123456-1234567");
		Scanner sc = new Scanner(System.in);
		String rrn = sc.nextLine();
		char ch = rrn.charAt(7);
		System.out.println(ch);
		if (ch=='1'||ch=='3') {
			System.out.println("�����Դϴ�.");
		}else if(ch=='2'||ch=='4') {
			System.out.println("�����Դϴ�.");
		}else {
			System.out.println("�߸��� �����Դϴ�.");
		}
		
	}
}
