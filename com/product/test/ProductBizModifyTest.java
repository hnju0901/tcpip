package com.product.test;

import org.junit.jupiter.api.Test;

import com.product.ProductBiz;
import com.vo.ProductVO;


class ProductBizModifyTest {

	@Test
	void testModifyProductVO() {
		ProductBiz biz = new ProductBiz();
		ProductVO product = new ProductVO(00, "name", 20000);
		
		try {
			biz.modify(product);
			System.out.println(product);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
