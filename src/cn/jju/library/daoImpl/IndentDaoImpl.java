package cn.jju.library.daoImpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.jju.library.dao.BaseDao;
import cn.jju.library.dao.IndentDao;
import cn.jju.library.entity.Indent;



public class IndentDaoImpl extends BaseDao implements IndentDao{

	@Override
	public int addIndent(Indent indent) {
		String sql = "insert into indent (userid,address,totalprice)values"
				+ "(?,?,?)";
		Object []parameters = new Object[3];
		parameters[0] = indent.getUserid();
		parameters[1] = indent.getAddress();
		parameters[2] =indent.getTotalprice();
		//return this.exceuteUpdate(sql, parameters);
		return this.exceuteInsert(sql, parameters);
	}
	@Override
	public int deleteIndent(int Id) {
		String sql = "delete from indent where Id = ?";
		Object []parameters = new Object[1];
		parameters[0] = Id;
		return this.exceuteUpdate(sql, parameters);
	}
	@Override
	public int deleteIndent(Indent indent) {
		return deleteIndent(indent.getId());
	}
	@Override
	public int updateIndent(Indent indent) {
		String sql = "update indent set userid=?,address=?,totalprice=?"
				+" where id=?";
		Object []parameters = new Object[4];
		parameters[0] = indent.getUserid();
		parameters[1] = indent.getAddress();
		parameters[2] = indent.getTotalprice();
		parameters[3] = indent.getId();
		System.out.println(sql);
		return this.exceuteUpdate(sql, parameters);
	}

	

	@Override
	public List<Indent> getIndentBySql(String prepareSql, Object[] parameters) {
		List<Indent> list = new ArrayList<Indent>();
		
		this.rs = this.exceuteQuery(prepareSql, parameters);
		
		try{
			while(rs.next()){
				Indent indent = new Indent();
				indent.setId(rs.getInt("id"));
				indent.setUserid(rs.getInt("userId"));
				indent.setAddress(rs.getString("address"));
				indent.setTotalprice(rs.getDouble("totalprice"));
				list.add(indent);
				System.out.println(indent);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return list;
	}
	

	@Override
	public List<Indent> getAllIndent() {
		String sql = "select * from indent order by id desc";
		return getIndentBySql(sql,null);
	}

	@Override
	public Indent findIndentById(int id) {
		String sql = "select from indent where Id=?";
		Object[] parameters = new Object[1];
		parameters[0]=id;
		return getIndentBySql(sql,parameters).get(0);
	}
	@Override
	public Indent getById(int id) {
		String sql = "select * from indent where Id =?";
		return getIndentBySql(sql,new Object[]{id}).get(0);
	}
	
	
}
