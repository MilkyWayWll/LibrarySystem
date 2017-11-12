package cn.jju.library.dao;

import java.util.Collection;

import cn.jju.library.entity.BookCaseForm;

public interface BookCaseDao {
	public Collection query(String strif);

	public BookCaseForm queryM(BookCaseForm bookCaseForm);

	// 添加数据
	public int insert(BookCaseForm bookCaseForm);

	// 修改数据
	public int update(BookCaseForm bookCaseForm);

	// 删除数据
	public int delete(BookCaseForm bookCaseForm);
}
