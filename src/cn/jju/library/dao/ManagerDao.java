package cn.jju.library.dao;

import java.util.Collection;

import cn.jju.library.entity.ManagerForm;

public interface ManagerDao {
	// 查询数据
		public Collection query(String queryif) ;
		//查询权限信息
		public ManagerForm query_p(String str);
		// 管理员身份验证
		public int checkManager(ManagerForm manager); 
		// 修改时应用的查询方法
		public ManagerForm query_update(ManagerForm manager); 
		// 更改口令时应用的查询方法
		public ManagerForm query_pwd(ManagerForm manager);
		
		// 添加数据
		public int insert(ManagerForm manager);
		// 设置管理员权限
		public int update(ManagerForm manager) ;
		// 修改管理员密码
		public int updatePwd(ManagerForm manager) ;
		// 删除数据
		public int delete(ManagerForm manager) ;
}
