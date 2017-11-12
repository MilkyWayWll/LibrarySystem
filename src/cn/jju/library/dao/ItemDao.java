package cn.jju.library.dao;

import java.util.List;

import cn.jju.library.entity.Item;

public interface ItemDao {
	public int addItem(Item item);
	public int deleteItem(int Id);
	public int deleteItem(Item item);
	public int updateItem(Item item);
	
	public List<Item> getItemBySql(String prepareSql,Object[] parameters );
	public List<Item> getAllItem();
	
	public Item findItemById(int id);
	
	public Item getById(int id);
	public List<Item>getByIndentId(int indentId);
}
