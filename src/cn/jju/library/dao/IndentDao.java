package cn.jju.library.dao;

import java.util.List;

import cn.jju.library.entity.Indent;

public interface IndentDao {
	public int addIndent(Indent indent);
	public int deleteIndent(int Id);
	public int deleteIndent(Indent indent);
	public int updateIndent(Indent indent);
	
	public List<Indent> getIndentBySql(String prepareSql,Object[] parameters );
	public List<Indent> getAllIndent();
	
	public Indent findIndentById(int id);
	public Indent getById(int id);
	
	
}
