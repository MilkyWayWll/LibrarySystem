package cn.jju.library.daoImpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.jju.library.dao.BaseDao;
import cn.jju.library.dao.ProductDao;
import cn.jju.library.entity.Product;


public class ProductDaoImpl extends BaseDao implements ProductDao{

	@Override
	public int addProduct(Product product) {
		String sql = "insert into product (productNo,productName,description,"
				+ "price,categoryNo,img)values(?,?,?,?,?,?)";
		
		Object []parameters = new Object[6];
		parameters[0] = product.getProductNo();
		parameters[1] = product.getProductName();
		parameters[2] = product.getDescription();
		parameters[3] = product.getPrice();
		parameters[4] = product.getCategoryNo();
		parameters[5] = product.getImg();
		System.out.println(sql);
		return this.exceuteUpdate(sql, parameters);
	}
	
	@Override
	public int deleteProduct(int id) {
		String sql = "delete from product where id= ?";
		Object [] parameters = new Object[1];
		parameters[0] = id;
		return this.exceuteUpdate(sql, parameters);
	}

	@Override
	public int deleteProduct(Product product) {
		return deleteProduct(product.getId());
	}

	@Override
	public int updateProduct(Product product) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Product> getProductBySql(String prepareSql, Object[] parameters) {
		
		List<Product> list = new ArrayList<Product>();
		
		this.rs = this.exceuteQuery(prepareSql, parameters);
		
		try{
			while(rs.next()){
				Product product = new Product();
				product.setId(rs.getInt("id"));
				product.setProductNo(rs.getString("productNo"));
				product.setProductName(rs.getString("productName"));
				product.setDescription(rs.getString("description"));
				product.setPrice(rs.getDouble("price"));
				product.setCategoryNo(rs.getString("categoryNo"));
				product.setImg(rs.getString("img"));
				list.add(product);
				System.out.println(product);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Product> getAllProduct() {
	String sql ="select * from product order by id desc ";
		return getProductBySql(sql,null);
	}

	@Override
	public Product findProductById(int id) {
		String sql = "select * from product where id=?";
		Object[] paramters = new Object[1];
		paramters[0] = id;
		return getProductBySql(sql,paramters).get(0);
	}
	
	@Override
	public Product getById(int id) {
		String sql = "select * from product where id = ?";
		return getProductBySql(sql,new Object[]{id}).get(0);
	}



	

	
}
