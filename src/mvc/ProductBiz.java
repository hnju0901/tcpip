package mvc;

public class ProductBiz {
	private ProductDao dao;
	public ProductBiz() {
		dao = new ProductDao();
		//tight�ϱ� ����
	}
	
	public void register(ProductDTO product) {
		System.out.println("������ üũ");
		System.out.println("������ �Է�");
		dao.ProductInsert(product);
		System.out.println("���� ����");
	}
	public void modify(ProductDTO product) {
		System.out.println("������ üũ");
		dao.ProductUpdate(product);
	}
	public void remove(int id) {
		System.out.println("������ üũ");
		dao.ProductDelect(id);
	}

}
