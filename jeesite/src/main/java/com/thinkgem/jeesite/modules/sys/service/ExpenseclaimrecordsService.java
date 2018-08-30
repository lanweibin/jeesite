/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.sys.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.sys.entity.Expenseclaimrecords;
import com.thinkgem.jeesite.modules.sys.dao.ExpenseclaimrecordsDao;

/**
 * 报销表Service
 * @author test
 * @version 2018-08-24
 */
@Service
@Transactional(readOnly = true)
public class ExpenseclaimrecordsService extends CrudService<ExpenseclaimrecordsDao, Expenseclaimrecords> {

	public Expenseclaimrecords get(String id) {
		return super.get(id);
	}
	
	public List<Expenseclaimrecords> findList(Expenseclaimrecords expenseclaimrecords) {
		return super.findList(expenseclaimrecords);
	}
	
	public Page<Expenseclaimrecords> findPage(Page<Expenseclaimrecords> page, Expenseclaimrecords expenseclaimrecords) {
		return super.findPage(page, expenseclaimrecords);
	}
	
	@Transactional(readOnly = false)
	public void save(Expenseclaimrecords expenseclaimrecords) {
		super.save(expenseclaimrecords);
	}
	
	@Transactional(readOnly = false)
	public void delete(Expenseclaimrecords expenseclaimrecords) {
		super.delete(expenseclaimrecords);
	}
	
}