package mvc;

public class ProductDao {
	//Driver Loading
		//DB에 접속 한다.
		//CRUD가 함수로 구현 된다.
	public ProductDao() {
		
	}
	public void ProductInsert(ProductDTO product) {
		System.out.println("DB에 User 입력");
		System.out.println(product);
		System.out.println("입력 완료");
	}
	
	public void ProductUpdate(ProductDTO product) {
		System.out.println("DB에 User 수정");
		System.out.println(product);
		System.out.println("수정 완료");
	}
	public void ProductDelect(int id) {
		System.out.println("DB에 ID 삭제");
		System.out.println(id);
		System.out.println("삭제 완료");
	}

}