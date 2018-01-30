package product;

import java.util.ArrayList;

import frame.Dao;
import vo.ProductVO;

public class ProductDAO implements Dao {

	@Override
	public void insert(Object obj) {
		ProductVO product = (ProductVO) obj;
		System.out.println(product+"Inserted...");
	}

	@Override
	public void delete(Object obj) {
		int id = (int) obj;
		System.out.println(id+"Deleted...");
	}

	@Override
	public void update(Object obj) {
		ProductVO product = (ProductVO) obj;
		System.out.println(product+"Updated...");
	}

	@Override
	public Object select(Object obj) {
		int id = (int) obj;
		System.out.println(id+" Selected...");
		ProductVO product = new ProductVO(1, "name", 1000);
		return product;
	}

	@Override
	public ArrayList<Object> select() {
		ArrayList<Object> list = new ArrayList<>();
		System.out.println("Selected All...");
		list.add(new ProductVO(1, "name", 1000));
		list.add(new ProductVO(2, "name2", 2000));
		list.add(new ProductVO(3, "name3", 3000));
		list.add(new ProductVO(4, "name4", 4000));
		list.add(new ProductVO(5, "name5", 5000));
		return list;
	}

}
