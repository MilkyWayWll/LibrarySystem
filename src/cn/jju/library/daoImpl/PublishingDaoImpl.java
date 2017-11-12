package cn.jju.library.daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;



import cn.jju.library.dao.ConnDB;
import cn.jju.library.dao.PublishingDao;
import cn.jju.library.entity.PublishingForm;

public class PublishingDaoImpl implements PublishingDao {
	private ConnDB conn = new ConnDB();
	@Override
	//查询出版社信息
	public Collection query(String strif) {
		PublishingForm pubForm=null;
		Collection pubColl=new ArrayList();
		String sql="";
		if(strif!="all" && strif!=null && strif!=""){
		    sql="select * from tb_publishing where "+strif+"";
		}else{
		    sql="select * from tb_publishing";
		}
		ResultSet rs=conn.executeQuery(sql);
		try {
		    while (rs.next()) {
		    	 pubForm=new PublishingForm();
		         pubForm.setIsbn(rs.getString(1));
		         pubForm.setPubname(rs.getString(2));
		         pubColl.add(pubForm);
		    }
		} catch (SQLException ex) {
		}
		//conn.close();
		return pubColl;
		}

}
