package product.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import frame.Biz;
import product.ProductBiz;
import user.UserBiz;
import vo.ProductVO;
import vo.UserVO;

class ProductBizRegisterTest {

	Biz<ProductVO, Integer> biz;
	
	public ProductBizRegisterTest() {
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
	void testRegisterProductVO() {
		ProductVO product = new ProductVO(01, "name", 1000);
		try {
			biz.register(product);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}


}
