package com.product.test;

import org.junit.jupiter.api.Test;

import com.product.ProductBiz;
import com.vo.ProductVO;

class ProductBizRegisterTest {

	@Test
	void testRegisterProductVO() {
		ProductBiz biz = new ProductBiz();
		ProductVO product = new ProductVO(00, "�ϳ���", 10000);
		try {
			biz.register(product);
			System.out.println(product);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
