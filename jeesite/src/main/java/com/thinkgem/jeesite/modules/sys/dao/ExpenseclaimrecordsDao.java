/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.sys.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.sys.entity.Expenseclaimrecords;

/**
 * 报销表DAO接口
 * @author test
 * @version 2018-08-24
 */
@MyBatisDao
public interface ExpenseclaimrecordsDao extends CrudDao<Expenseclaimrecords> {
	
}