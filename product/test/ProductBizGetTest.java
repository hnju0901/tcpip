package product.test;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import frame.Biz;
import product.ProductBiz;
import vo.ProductVO;

class ProductBizGetTest {

	Biz<ProductVO, Integer> biz;

	public ProductBizGetTest() {
		biz = new ProductBiz();
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
	void testGetInteger() throws Exception {

		ProductVO product = biz.get(01);
		System.out.println(product);
	}

	@Test
	void testGet() throws Exception {
		ArrayList<ProductVO> list = biz.get();
		for(ProductVO product :list) {
			System.out.println(product);
		}
	}

}
