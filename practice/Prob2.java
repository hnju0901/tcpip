package practice;

import java.util.Arrays;
import java.util.Scanner;

public class Prob2 {

	/*
	 * project명: ws03 Ws03.java 1~9까지의 숫자를 3개 입력 받는다. 이중 최대 값과 최소 값의 차가 얼마 인지 출력 하시오
	 * 
	 * 최대값:4 최소값:2 차 :2
	 */

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.println("1~9까지 숫자 중 3가지를 입력하세요");

		int[] arr = new int[3];
		arr[0] = sc.nextInt();
		arr[1] = sc.nextInt();
		arr[2] = sc.nextInt();
		for (int i = 0; i <= arr.length - 1; i++) {
			if (arr[i] > 9 || arr[i] < 1) {
				throw new Exception("잘못입력하셨습니다");
			}
		}
		Arrays.sort(arr);
		System.out.println("최대값: " + arr[2] + "\n최솟값: " + arr[0] + "\n차: " + (arr[2] - arr[0]));
	}

}
