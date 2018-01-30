package practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Prob3 {
	
	public static void main(String[] args) throws Exception {
		// 1. 6���� ���� �Է� (���� : 1~45): day06ws
		Scanner sc = new Scanner(System.in);
		System.out.println("6���� ��ȣ�� �������ּ���.(����: 1~45)");
		int[] arr = new int[6];
		arr[0] = sc.nextInt();
		arr[1] = sc.nextInt();
		arr[2] = sc.nextInt();
		arr[3] = sc.nextInt();
		arr[4] = sc.nextInt();
		arr[5] = sc.nextInt();
		for (int i = 0; i <= arr.length - 1; i++) {
			if (arr[i] > 45 || arr[i] < 1) {
				throw new Exception("�߸��Է��ϼ̽��ϴ�.");
			}
		}
		System.out.print("��    ��ȣ: ");
		for (int i = 0; i <= arr.length - 1; i++) {
			System.out.print(arr[i] + "\t");
		}
		System.out.println();

		// 2. �� ���� ��÷��ȣ 6�� ���� (���� : 1~45)
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 1; i <= 45; i++) {
			list.add(i);
		}
		Collections.shuffle(list);
		int[] lotto = new int[6];
		lotto[0] = list.get(0);
		lotto[1] = list.get(1);
		lotto[2] = list.get(2);
		lotto[3] = list.get(3);
		lotto[4] = list.get(4);
		lotto[5] = list.get(5);

		System.out.print("��÷ ��ȣ: ");
		for (int i = 0; i <= lotto.length - 1; i++) {
			System.out.print(lotto[i] + "\t");
		}
		System.out.println();

		// 3. ��÷�� ���� ���� (����: 10��~100��) //������
		double Max = 10000000000f;
		double Min = 1000000000;
		int money = (int) Math.floor(Math.random() * (Max - Min) + Min);// 10��

		// 4. �Է� ���� ���ڿ� ��÷��ȣ Ȯ�� - 3�� ������ : 4�� (��÷�� 5%) - 4��
		// ������ : 3�� (��÷�� 10%) - 5�� ������ : 2�� (��÷�� 20%) - 6�� ������ : 1�� (��÷�� 50%)
		int count = 0;
		for (int i = 0; i <= arr.length - 1; i++) {
			for (int j = 0; j <= lotto.length - 1; j++) {
				if (arr[i] == lotto[j]) {
					count++;
				}
			}
		}
		System.out.println("���: " + count);
		System.out.print("�Ѵ�÷��: ");
		printMoney(money);
		System.out.print("��÷��   : ");
		int getMoney;
		switch (count) {
		case 3:
			getMoney = (int) (money * 0.05);
			printMoney(getMoney);
			break;
		case 4:
			getMoney = (int) (money * 0.10);
			printMoney(getMoney);
			break;
		case 5:
			getMoney = (int) (money * 0.20);
			printMoney(getMoney);
			break;
		case 6:
			getMoney = (int) (money * 0.5);
			printMoney(getMoney);
			break;
		default:
			System.out.println("�����ϴ�. ������ȸ��~");
		}
	}
	static public void printMoney(int money) {
		System.out.printf("%,d�� �Դϴ�.",money);
		System.out.println();
	}
}
