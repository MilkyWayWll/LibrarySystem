package cn.jju.library.dao;

import java.util.Collection;


import cn.jju.library.entity.BookForm;
public interface BookDao {
	// 查询数据
	public Collection query(String strif);

	public BookForm queryM(BookForm bookForm1);

	// 用于借阅的查询
	public BookForm queryB(String f, String key);

	// 添加数据
	public int insert(BookForm bookForm);

	// 修改数据
	public int update(BookForm bookForm);

	// 删除数据
	public int delete(BookForm bookForm);

	
}
