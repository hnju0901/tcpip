package product;

import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import frame.Biz;
import vo.ProductVO;

class GetTest {

	Biz biz = new ProductBIZ();
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testGetObject() {
		ProductVO product=(ProductVO) biz.get(10);
		System.out.println(product);
	}

	@Test
	void testGet() {
		ArrayList<Object> list =biz.get();
		for(Object obj: list) {
			ProductVO product = (ProductVO) obj;
			System.out.println(product);
		}
	}

}
