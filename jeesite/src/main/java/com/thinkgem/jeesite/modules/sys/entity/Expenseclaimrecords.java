/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.sys.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 报销表Entity
 * @author test
 * @version 2018-08-24
 */
public class Expenseclaimrecords extends DataEntity<Expenseclaimrecords> {
	
	private static final long serialVersionUID = 1L;
	private String name;		// 项目名称
	
	public Expenseclaimrecords() {
		super();
	}

	public Expenseclaimrecords(String id){
		super(id);
	}

	@Length(min=1, max=30, message="项目名称长度必须介于 1 和 30 之间")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}