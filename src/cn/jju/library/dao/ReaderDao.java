package cn.jju.library.dao;


import java.util.Collection;

import cn.jju.library.entity.ReaderForm;


public interface ReaderDao {
	 
	public Collection query(String strif) ;

	public ReaderForm queryM(ReaderForm reader);
	

	
	public int insert(ReaderForm reader);

	public int update(ReaderForm reader);

	public int delete(ReaderForm reader);

}
