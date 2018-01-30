package mvc;

public class ProductBiz {
	private ProductDao dao;
	public ProductBiz() {
		dao = new ProductDao();
		//tight하기 때문
	}
	
	public void register(ProductDTO product) {
		System.out.println("데이터 체크");
		System.out.println("아이템 입력");
		dao.ProductInsert(product);
		System.out.println("메일 전송");
	}
	public void modify(ProductDTO product) {
		System.out.println("데이터 체크");
		dao.ProductUpdate(product);
	}
	public void remove(int id) {
		System.out.println("데이터 체크");
		dao.ProductDelect(id);
	}

}
