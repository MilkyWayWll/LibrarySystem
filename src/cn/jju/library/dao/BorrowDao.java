package cn.jju.library.dao;

import java.util.Collection;

import cn.jju.library.entity.BookForm;
import cn.jju.library.entity.BorrowForm;
import cn.jju.library.entity.ReaderForm;


public interface BorrowDao {
	public int insert();
	public int insertBorrow(ReaderForm readerForm, BookForm bookForm,
			String operator);
	 public int renew(int id);
	 public int back(int id,String operator);
	 public Collection<BorrowForm> borrowinfo(String str);
	 public Collection bremind();//到期提醒
	 public Collection borrowQuery(String strif);//图书借阅查询
	 public Collection<BorrowForm> bookBorrowSort() ;//图书借阅额查询
}
