package app;

import java.util.ArrayList;
import java.util.Scanner;

import com.product.ProductBiz;
import com.user.UserBiz;
import com.vo.ProductVO;
import com.vo.UserVO;

public class View {
	public static void main(String[] args) {

		w: while (true) {
			System.out.println("[1] ��������� ����  [2] ��ǰ���� ����  [9] ����");
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);
			int select = sc.nextInt();

			switch (select) {
			case 1:
				while (true) {
					System.out.println();
					System.out.println("[1] ����� ��ȸ      [2] ��� ����� ��ȸ [3] ����� ���� �Է�");
					System.out.println("[4] ����� ���� ���� [5] ����� ���� ���� [6] �������� ���ư��� [9] ����");
					UserBiz biz = new UserBiz();
					UserVO user = null;
					ArrayList<UserVO> list = null;
					String id = null;
					String pwd = null;
					String name = null;

					int select2 = sc.nextInt();
					switch (select2) {
					case 1:
						System.out.println("���� ��ȸ�� ID�Է�>>");
						id = sc.next();
						try {
							user = biz.get(id);
							System.out.println(user);
						} catch (Exception e) {
							e.printStackTrace();
						}
						break;

					case 2:
						try {
							list = biz.get();
							for (UserVO u : list) {
								System.out.println(u);
							}
						} catch (Exception e) {
							e.printStackTrace();
						}
						break;

					case 3:
						try {
							System.out.println("ID, ��й�ȣ, �̸�>>");
							id = sc.next();
							pwd = sc.next();
							name = sc.next();
							user = new UserVO(id, pwd, name);
							biz.register(user);					
						} catch (Exception e) {
							e.printStackTrace();
						}
						break;

					case 4:
						try {
							System.out.println("���� ������ ID�Է�>>");
							id = sc.next();
							System.out.println("��й�ȣ, �̸� �Է�>>");
							pwd = sc.next();
							name = sc.next();
							user = new UserVO(id, pwd, name);
							biz.modify(user);					
						} catch (Exception e) {
							e.printStackTrace();
						}
						break;
					case 5:
						System.out.println("���� ������ ID�Է�>>");
						id = sc.next();
						try {
							biz.remove(id);
						} catch (Exception e) {
							e.printStackTrace();
						}
						break;
					case 6:
						continue w;
					case 9:
						break w;
					default:
						System.out.println("�ٽ� �Է��ϼ���");
					}
				}
			case 2:
				while (true) {
					System.out.println();
					System.out.println("[1] ��ǰ ��ȸ      [2] ��� ��ǰ ��ȸ [3] ��ǰ ���� �Է�");
					System.out.println("[4] ��ǰ ���� ���� [5] ��ǰ ���� ���� [6] �������� ���ư��� [9] ����");
					ProductBiz biz = new ProductBiz();
					ProductVO product = null;
					ArrayList<ProductVO> list = null;
					int id;
					String name = null;
					double price;

					int select2 = sc.nextInt();
					s: switch (select2) {
					case 1:
						System.out.println("���� ��ȸ�� ��ǰID�Է�>>");
						id = sc.nextInt();
						try {
							product = biz.get(id);
							System.out.println(product);
						} catch (Exception e) {
							e.printStackTrace();
						}
						break s;

					case 2:
						try {
							list = biz.get();
							for (ProductVO p : list) {
								System.out.println(p);
							}
						} catch (Exception e) {
							e.printStackTrace();
						}
						break s;

					case 3:
						try {
							System.out.println("ID, ��ǰ��, ����>>");
							id = sc.nextInt();
							name = sc.next();
							price = sc.nextDouble();
							product = new ProductVO(id, name, price);
							biz.register(product);
							System.out.println(product);
						} catch (Exception e) {
							e.printStackTrace();
						}
						break s;

					case 4:
						try {
							System.out.println("���� ������ ��ǰID�Է�>>");
							id = sc.nextInt();
							System.out.println("��ǰ��, ���� �Է�>>");
							name = sc.next();
							price = sc.nextDouble();
							product = new ProductVO(id, name, price);
							biz.modify(product);
							System.out.println(product);
						} catch (Exception e) {
							e.printStackTrace();
						}
						break s;
					case 5:
						System.out.println("���� ������ ID�Է�>>");
						id = sc.nextInt();
						try {
							biz.remove(id);
						} catch (Exception e) {
							e.printStackTrace();
						}
						break s;
					case 6:
						continue w;
					case 9:
						break w;
						
					default:
						System.out.println("�ٽ� �Է��ϼ���");
					}
				}
			case 9:
				break w;
				
			default:
				System.out.println("�ٽ� �Է��ϼ���");
			}
			
		}
	}
}