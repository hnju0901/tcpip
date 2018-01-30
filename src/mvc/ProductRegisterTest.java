package mvc;

public class ProductRegisterTest {

	public static void main(String[] args) {
		ProductDTO product = new ProductDTO(1, "name", 10000);
		ProductBiz biz = new ProductBiz();
		biz.register(product);
	}
}
