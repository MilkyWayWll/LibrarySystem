package cn.jju.library.dao;

import java.util.List;

import cn.jju.library.entity.Category;

public interface CategoryDao {
	public int addCategory(Category category);
	public int updateCategory(Category category);
	
	public List<Category> getCategoryBySql(String prepareSql,Object[] parameters );
	public List<Category> getAllCategory();
	
	//public Category findItemById();
}
