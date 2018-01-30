package com.product.test;

import org.junit.jupiter.api.Test;

import com.product.ProductBiz;

class ProductBizRemoveTest {

	@Test
	void testRemoveInteger() {
		ProductBiz biz = new ProductBiz();
		int id = 01;
		try {
			biz.remove(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
