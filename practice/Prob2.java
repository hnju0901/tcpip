package practice;

import java.util.Arrays;
import java.util.Scanner;

public class Prob2 {

	/*
	 * project��: ws03 Ws03.java 1~9������ ���ڸ� 3�� �Է� �޴´�. ���� �ִ� ���� �ּ� ���� ���� �� ���� ��� �Ͻÿ�
	 * 
	 * �ִ밪:4 �ּҰ�:2 �� :2
	 */

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.println("1~9���� ���� �� 3������ �Է��ϼ���");

		int[] arr = new int[3];
		arr[0] = sc.nextInt();
		arr[1] = sc.nextInt();
		arr[2] = sc.nextInt();
		for (int i = 0; i <= arr.length - 1; i++) {
			if (arr[i] > 9 || arr[i] < 1) {
				throw new Exception("�߸��Է��ϼ̽��ϴ�");
			}
		}
		Arrays.sort(arr);
		System.out.println("�ִ밪: " + arr[2] + "\n�ּڰ�: " + arr[0] + "\n��: " + (arr[2] - arr[0]));
	}

}
