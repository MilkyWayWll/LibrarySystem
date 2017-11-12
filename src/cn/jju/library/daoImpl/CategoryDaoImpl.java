package cn.jju.library.daoImpl;

import java.util.List;

import cn.jju.library.dao.BaseDao;
import cn.jju.library.dao.CategoryDao;
import cn.jju.library.entity.Category;


public class CategoryDaoImpl extends BaseDao implements CategoryDao {

	@Override
	public int addCategory(Category category) {
		String sql = "insert into categoty(categoryNo,categoryName,description)values"
				+"(?,?,?)";
		Object []parameters = new Object[2];
		parameters[0] = category.getCategoryNo();
		parameters[1] = category.getCategoryName();
		parameters[2] = category.getDescription();
		return  this.exceuteUpdate(sql, parameters);
	}

	@Override
	public int updateCategory(Category category) {
		String sql ="update category set categoryName = ?, description = ?"
				+" where categoryNo = ?";
		Object []parameters = new Object[2];
		parameters[0] = category.getCategoryName();
		parameters[1] = category.getDescription();
		parameters[2] = category.getCategoryNo();
		System.out.println(sql);
		return  this.exceuteUpdate(sql, parameters);
	}

	@Override
	public List<Category> getCategoryBySql(String prepareSql, Object[] parameters) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Category> getAllCategory() {
		// TODO Auto-generated method stub
		return null;
	}


}
