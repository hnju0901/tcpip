package product;

import java.util.ArrayList;

import org.omg.DynamicAny.DynAnyPackage.InvalidValueHelper;

import frame.Dao;
import vo.ProductVO;

public class ProductDao extends Dao<ProductVO, Integer> {

	@Override
	public void insert(ProductVO t) {
		start();
		System.out.println(t+" Inserted...");
		end();
	}

	@Override
	public void delete(Integer v) {
		start();
		System.out.println(v+" Delected...");
		end();
	}

	@Override
	public void update(ProductVO t) {
		start();
		System.out.println(t+" Updated...");
		end();
	}

	@Override
	public ProductVO select(Integer v) {
		start();
		System.out.println(v+" Selected...");
		ProductVO product =new ProductVO(v, "name", 1000);
		end();
		return product;
	}

	@Override
	public ArrayList<ProductVO> select() {
		start();
		System.out.println("Selected All...");
		ArrayList<ProductVO> list = new ArrayList<>();
		list.add(new ProductVO(1, "name", 10000));
		list.add(new ProductVO(2, "name", 20000));
		list.add(new ProductVO(3, "name", 30000));
		list.add(new ProductVO(4, "name", 40000));
		list.add(new ProductVO(5, "name", 50000));
		end();
		return list;
	}

}
