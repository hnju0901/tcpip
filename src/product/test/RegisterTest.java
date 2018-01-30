package product.test;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import frame.Biz;
import product.ProductBIZ;
import vo.ProductVO;

class RegisterTest {
	

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		System.out.println("TEST START");
	}

	@AfterEach
	void tearDown() throws Exception {
		System.out.println("TEST END");
	}

	Biz biz = new ProductBIZ(); 
	ProductVO product = new ProductVO(10, "name10", 10000);
	@Test
	void testRegister() {	
		biz.register(product);
		System.out.println("입력완료");
	}

	@Test
	void testModify() {
		biz.modify(product);
		System.out.println("수정완료");
	}

	@Test
	void testRemove() {
		biz.remove(10);
		System.out.println("삭제완료");
	}

}
