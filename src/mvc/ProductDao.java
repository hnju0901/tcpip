package mvc;

public class ProductDao {
	//Driver Loading
		//DB�� ���� �Ѵ�.
		//CRUD�� �Լ��� ���� �ȴ�.
	public ProductDao() {
		
	}
	public void ProductInsert(ProductDTO product) {
		System.out.println("DB�� User �Է�");
		System.out.println(product);
		System.out.println("�Է� �Ϸ�");
	}
	
	public void ProductUpdate(ProductDTO product) {
		System.out.println("DB�� User ����");
		System.out.println(product);
		System.out.println("���� �Ϸ�");
	}
	public void ProductDelect(int id) {
		System.out.println("DB�� ID ����");
		System.out.println(id);
		System.out.println("���� �Ϸ�");
	}

}