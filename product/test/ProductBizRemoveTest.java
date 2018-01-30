package product.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import frame.Biz;
import product.ProductBiz;
import vo.ProductVO;

class ProductBizRemoveTest {

	Biz<ProductVO, Integer> biz;
	
	public ProductBizRemoveTest() {
		biz= new ProductBiz();
	}

	@BeforeEach
	void setUp() throws Exception {
		System.out.println("TEST START");
	}

	@AfterEach
	void tearDown() throws Exception {
		System.out.println("TEST END");
	}
	@Test
	void testRemoveInteger() {
		try {
			biz.remove(01);
		} catch (Exception e) {
			System.out.println("해당 ID가 없습니다.");
		}
	}

}
