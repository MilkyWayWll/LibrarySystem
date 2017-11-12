package cn.jju.library.dao;

import java.util.List;

import cn.jju.library.entity.Product;

public interface ProductDao {
	public int addProduct(Product product);
	public int deleteProduct(int id);
	public int deleteProduct(Product product);
	public int updateProduct(Product product);
	
	public List<Product> getProductBySql(String prepareSql,Object[] parameters );
	
	public List<Product> getAllProduct();
	
	public Product findProductById(int id);
	public Product getById(int id);
}
