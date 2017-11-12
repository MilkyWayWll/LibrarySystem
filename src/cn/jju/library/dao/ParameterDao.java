package cn.jju.library.dao;

import java.util.Collection;

import cn.jju.library.entity.ParameterForm;


public interface ParameterDao {
	//查询信息
	public ParameterForm query();
	//更新信息
	public int update(ParameterForm parameter);
	
	

}
