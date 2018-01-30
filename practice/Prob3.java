package practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Prob3 {
	
	public static void main(String[] args) throws Exception {
		// 1. 6개의 숫자 입력 (범위 : 1~45): day06ws
		Scanner sc = new Scanner(System.in);
		System.out.println("6개의 번호를 선택해주세요.(범위: 1~45)");
		int[] arr = new int[6];
		arr[0] = sc.nextInt();
		arr[1] = sc.nextInt();
		arr[2] = sc.nextInt();
		arr[3] = sc.nextInt();
		arr[4] = sc.nextInt();
		arr[5] = sc.nextInt();
		for (int i = 0; i <= arr.length - 1; i++) {
			if (arr[i] > 45 || arr[i] < 1) {
				throw new Exception("잘못입력하셨습니다.");
			}
		}
		System.out.print("내    번호: ");
		for (int i = 0; i <= arr.length - 1; i++) {
			System.out.print(arr[i] + "\t");
		}
		System.out.println();

		// 2. 그 날의 당첨번호 6개 생성 (범위 : 1~45)
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

		System.out.print("당첨 번호: ");
		for (int i = 0; i <= lotto.length - 1; i++) {
			System.out.print(lotto[i] + "\t");
		}
		System.out.println();

		// 3. 당첨금 생성 범위 (범위: 10억~100억) //만단위
		double Max = 10000000000f;
		double Min = 1000000000;
		int money = (int) Math.floor(Math.random() * (Max - Min) + Min);// 10억

		// 4. 입력 받은 숫자와 당첨번호 확인 - 3개 맞으면 : 4등 (당첨금 5%) - 4개
		// 맞으면 : 3등 (당첨금 10%) - 5개 맞으면 : 2등 (당첨금 20%) - 6개 맞으면 : 1등 (당첨금 50%)
		int count = 0;
		for (int i = 0; i <= arr.length - 1; i++) {
			for (int j = 0; j <= lotto.length - 1; j++) {
				if (arr[i] == lotto[j]) {
					count++;
				}
			}
		}
		System.out.println("등수: " + count);
		System.out.print("총당첨금: ");
		printMoney(money);
		System.out.print("당첨금   : ");
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
			System.out.println("없습니다. 다음기회에~");
		}
	}
	static public void printMoney(int money) {
		System.out.printf("%,d원 입니다.",money);
		System.out.println();
	}
}
