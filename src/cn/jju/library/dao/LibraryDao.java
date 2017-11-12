package cn.jju.library.dao;

import cn.jju.library.entity.LibraryForm;

public interface LibraryDao {
	public LibraryForm query();
	public int update(LibraryForm libraryForm);
}
