package cn.jju.library.daoImpl;

import java.sql.ResultSet;

import cn.jju.library.dao.ConnDB;
import cn.jju.library.dao.ParameterDao;
import cn.jju.library.entity.ParameterForm;

public class ParameterDaoImpl implements ParameterDao {
	ConnDB conn = null;

	public ParameterDaoImpl() {
		conn = new ConnDB();
	}

	public ParameterForm query() {
		ParameterForm libraryForm1 = null;
		String sql = "select * from tb_parameter where id=1";
		ResultSet rs = conn.executeQuery(sql);
		try {
			while (rs.next()) {
				libraryForm1 = new ParameterForm();
				libraryForm1.setId(Integer.valueOf(rs.getString(1)));
				libraryForm1.setCost(rs.getInt(2));
				libraryForm1.setValidity(rs.getInt(3));

			}
		} catch (Exception ex) {
		}
		// conn.close();
		return libraryForm1;
	}

	public int update(ParameterForm parameterForm) {
		String sql = "UPDATE tb_parameter SET cost=" + parameterForm.getCost() + ",validity="
				+ parameterForm.getValidity() + " where id=1";
		int ret = conn.executeUpdate(sql);
		// conn.close();
		return ret;
	}

}
