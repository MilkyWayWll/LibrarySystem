package cn.jju.library.daoImpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.jju.library.dao.BaseDao;
import cn.jju.library.dao.ItemDao;
import cn.jju.library.entity.Item;


public class ItemDaoImpl extends BaseDao implements ItemDao {

	@Override
	public int addItem(Item item) {
		String sql = "insert into item(productId,indentId,price,quantity)values"
				+"(?,?,?,?)";
		Object []parameters = new Object[4];
		parameters[0] = item.getProductId();
		parameters[1] = item.getIndentId();
		parameters[2] = item.getPrice();
		parameters[3] = item.getQuantity();
		return this.exceuteUpdate(sql, parameters);
	}
	@Override
	public int deleteItem(int Id) {
		String sql = "delete from item where Id = ?";
		Object []parameters = new Object[1];
		parameters[0] = Id;
		return this.exceuteUpdate(sql, parameters);
	}
	@Override
	public int deleteItem(Item item) {
		return deleteItem(item.getId());
	}
	@Override
	public int updateItem(Item item) {
		String sql = "update item set productId = ?,indentId = ?, price = ?, quantity = ? "
				+ "where Id = ?";
		Object []parameters = new Object[5];
		parameters[0] = item.getProductId();
		parameters[1] = item.getIndentId();
		parameters[2] = item.getPrice();
		parameters[3] = item.getQuantity();
		parameters[4] = item.getId();
		System.out.println(sql);
		return this.exceuteUpdate(sql, parameters);
		
	}
	@Override
	public List<Item> getItemBySql(String prepareSql, Object[] parameters) {
		List<Item> list = new ArrayList<Item>();
		this.rs = this.exceuteQuery(prepareSql, parameters);
		try{
			while(rs.next()){
				Item item = new Item();
				item.setId(rs.getInt("id"));
				item.setProductId(rs.getInt("productId"));
				item.setIndentId(rs.getInt("indentId"));
				item.setPrice(rs.getDouble("price"));
				item.setQuantity(rs.getInt("quantity"));
				list.add(item);
				System.out.print(item);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Item> getAllItem() {
		String sql = "selevt * from item order by id desc";
		return getItemBySql(sql,null);
	}

	@Override
	public Item findItemById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Item getById(int id) {
		String sql = "select * from item where id = ? ";
		return getItemBySql(sql,new Object[]{id}).get(0);
	}
	@Override
	public List<Item> getByIndentId(int indentId) {
		String sql = "select * from Item where indentId= ?" ;
		return getItemBySql(sql,new Object[]{indentId});
	}

}
