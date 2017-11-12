package cn.jju.library.daoImpl;

import java.util.*;

import cn.jju.library.dao.ConnDB;
import cn.jju.library.entity.ReaderForm;

import java.sql.*;

public class ReaderDaoImpl {
	private ConnDB conn = new ConnDB();

	// 查询数据
	public Collection query(String strif) {
		ReaderForm readerForm = null;
		Collection readerColl = new ArrayList();
		String sql = "";
		if (strif != "all" && strif != null && strif != "") {
			sql = "select r.*,t.name as typename,t.number from tb_reader r left join tb_readerType t on r.typeid=t.id where "
					+ strif + "";
		} else {
			sql = "select r.*,t.name as typename,t.number from tb_reader r left join tb_readerType t on r.typeid=t.id";
		}
		ResultSet rs = conn.executeQuery(sql);
		String birthday = "";
		try {
			while (rs.next()) {
				readerForm = new ReaderForm();
				readerForm.setId(Integer.valueOf(rs.getString(1)));
				readerForm.setName(rs.getString(2));
				readerForm.setSex(rs.getString(3));
				readerForm.setBarcode(rs.getString(4));
				readerForm.setVocation(rs.getString(5));
				birthday = rs.getString(6);
				readerForm.setBirthday(birthday == null ? "" : birthday);
				readerForm.setPaperType(rs.getString(7));
				readerForm.setPaperNO(rs.getString(8));
				readerForm.setTel(rs.getString(9));
				readerForm.setEmail(rs.getString(10));
				readerForm.setCreateDate(rs.getString(11));
				readerForm.setOperator(rs.getString(12));
				readerForm.setRemark(rs.getString(13));
				readerForm.setTypeid(rs.getInt(14));
				readerForm.setTypename(rs.getString(15));
				readerForm.setNumber(rs.getInt(16));
				readerColl.add(readerForm);
			}
		} catch (SQLException ex) {
		}
		// conn.close();
		return readerColl;
	}

	// 用于修改的查询
	public ReaderForm queryM(ReaderForm readerForm) {
		ReaderForm readerForm1 = null;
		String sql = "";
		if (readerForm.getId() != null) { // 根据读者ID查询读者信息
			sql = "select r.*,t.name as typename,t.number from tb_reader r left join tb_readerType t on r.typeid=t.id where r.id="
					+ readerForm.getId() + "";
		} else if (readerForm.getBarcode() != null) {// 根据读者条形码查询读者信息
			sql = "select r.*,t.name as typename,t.number from tb_reader r left join tb_readerType t on r.typeid=t.id where r.barcode="
					+ readerForm.getBarcode() + "";
		}
		ResultSet rs = conn.executeQuery(sql); // 执行查询语句
		String birthday = "";
		try {
			while (rs.next()) {
				readerForm1 = new ReaderForm();
				readerForm1.setId(Integer.valueOf(rs.getString(1))); // 获取读者ID
				readerForm1.setName(rs.getString(2)); // 获取读者姓名
				readerForm1.setSex(rs.getString(3)); // 获取读者性别
				readerForm1.setBarcode(rs.getString(4)); // 获取读者条形码
				readerForm1.setVocation(rs.getString(5)); // 获取职业
				birthday = rs.getString(6); // 获取生日
				readerForm1.setBirthday(birthday == null ? "" : birthday);
				readerForm1.setPaperType(rs.getString(7)); // 获取证件类型
				readerForm1.setPaperNO(rs.getString(8)); // 获取证件号码
				readerForm1.setTel(rs.getString(9));// 获取联系电话
				readerForm1.setEmail(rs.getString(10));// 获取E-mail地址
				readerForm1.setCreateDate(rs.getString(11));// 获取创建日期
				readerForm1.setOperator(rs.getString(12)); // 获取操作员
				readerForm1.setRemark(rs.getString(13));// 获取备注
				readerForm1.setTypeid(rs.getInt(14));// 获取读者类型ID
				readerForm1.setTypename(rs.getString(15)); // 获取读者类型名称
				readerForm1.setNumber(rs.getInt(16)); // 获取可借数量
			}
		} catch (SQLException ex) {
		}
		// conn.close();//关闭数据库连接
		return readerForm1;
	}

	// 添加数据
	public int insert(ReaderForm readerForm) {
		String sql1 = "SELECT * FROM tb_reader WHERE barcode='" + readerForm.getBarcode() + "'";
		ResultSet rs = conn.executeQuery(sql1);
		String sql = "";
		int falg = 0;
		try {
			if (rs.next()) {
				falg = 2;
			} else {
				if (readerForm.getBirthday() == "") {
					sql = "Insert into tb_reader (name,sex,barcode,vocation,paperType,paperNO,tel,email,createDate,operator,remark,typeid) values('"
							+ readerForm.getName() + "','" + readerForm.getSex() + "','" + readerForm.getBarcode()
							+ "','" + readerForm.getVocation() + "','" + readerForm.getPaperType() + "','"
							+ readerForm.getPaperNO() + "','" + readerForm.getTel() + "','" + readerForm.getEmail()
							+ "','" + readerForm.getCreateDate() + "','" + readerForm.getOperator() + "','"
							+ readerForm.getRemark() + "'," + readerForm.getTypeid() + ")";
				} else {
					sql = "Insert into tb_reader (name,sex,barcode,vocation,birthday,paperType,paperNO,tel,email,createDate,operator,remark,typeid) values('"
							+ readerForm.getName() + "','" + readerForm.getSex() + "','" + readerForm.getBarcode()
							+ "','" + readerForm.getVocation() + "','" + readerForm.getBirthday() + "','"
							+ readerForm.getPaperType() + "','" + readerForm.getPaperNO() + "','" + readerForm.getTel()
							+ "','" + readerForm.getEmail() + "','" + readerForm.getCreateDate() + "','"
							+ readerForm.getOperator() + "','" + readerForm.getRemark() + "'," + readerForm.getTypeid()
							+ ")";
				}
				falg = conn.executeUpdate(sql);
				System.out.println("添加读者信息的SQL：" + sql);
				// conn.close();
			}
		} catch (SQLException ex) {
			falg = 0;
		}
		System.out.println("falg:" + falg);
		return falg;
	}

	// 修改数据
	public int update(ReaderForm readerForm) {
		String sql = "";
		if (readerForm.getBirthday() == "") {
			sql = "Update tb_reader set sex='" + readerForm.getSex() + "',barcode='" + readerForm.getBarcode()
					+ "',vocation='" + readerForm.getVocation() + "',birthday=null,paperType='"
					+ readerForm.getPaperType() + "',paperNO='" + readerForm.getPaperNO() + "',tel='"
					+ readerForm.getTel() + "',email='" + readerForm.getEmail() + "',remark='" + readerForm.getRemark()
					+ "',typeid=" + readerForm.getTypeid() + " where id=" + readerForm.getId() + "";
		} else {
			sql = "Update tb_reader set sex='" + readerForm.getSex() + "',barcode='" + readerForm.getBarcode()
					+ "',vocation='" + readerForm.getVocation() + "',birthday='" + readerForm.getBirthday()
					+ "',paperType='" + readerForm.getPaperType() + "',paperNO='" + readerForm.getPaperNO() + "',tel='"
					+ readerForm.getTel() + "',email='" + readerForm.getEmail() + "',remark='" + readerForm.getRemark()
					+ "',typeid=" + readerForm.getTypeid() + " where id=" + readerForm.getId() + "";
		}
		int falg = conn.executeUpdate(sql);
		System.out.println("修改数据时的SQL：" + sql);
		// conn.close();
		return falg;
	}

	// 删除数据
	public int delete(ReaderForm readerForm) {
		String sql = "Delete from tb_reader where id=" + readerForm.getId() + "";
		int falg = conn.executeUpdate(sql);
		System.out.println("删除时的SQL：" + sql);
		return falg;
	}
}
