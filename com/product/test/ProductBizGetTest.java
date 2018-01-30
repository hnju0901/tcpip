package com.product.test;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import com.product.ProductBiz;
import com.vo.ProductVO;

class ProductBizGetTest {

	@Test
	void testGetInteger() {
		ProductBiz biz = new ProductBiz();
		ProductVO product = null;
		int id = 00;
		try {
			product= biz.get(id);
			System.out.println(product);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	void testGet() {
		ProductBiz biz =new ProductBiz();
		ArrayList<ProductVO> list = null;
		try {
			list = biz.get();
			System.out.println("================================");
			for(ProductVO product: list) {
				System.out.println(product);
			}
			System.out.println("================================");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
