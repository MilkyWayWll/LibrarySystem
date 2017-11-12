package cn.jju.library.dao;

import java.util.Collection;


import cn.jju.library.entity.ReaderTypeForm;

public interface ReaderTypeDao {
		
		public Collection query(String strif);
		
		public ReaderTypeForm queryM(ReaderTypeForm readertype);
		
		public int insert(ReaderTypeForm readertype);
		
		public int update(ReaderTypeForm readertype);
		
		public int delete(ReaderTypeForm readertype);

}
