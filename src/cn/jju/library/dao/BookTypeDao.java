package cn.jju.library.dao;

import java.util.Collection;

import cn.jju.library.entity.BookTypeForm;



public interface BookTypeDao {
	//查询数据
	public Collection query(String strif);
	//用于修改图书类别的查询
	public BookTypeForm queryM(BookTypeForm bookTypeForm);
	//添加图书类别数据
	public int insert(BookTypeForm bookTypeForm);
	//修改数据
	public int update(BookTypeForm bookTypeForm);
	//删除数据
	public int delete(BookTypeForm bookTypeForm);
}
