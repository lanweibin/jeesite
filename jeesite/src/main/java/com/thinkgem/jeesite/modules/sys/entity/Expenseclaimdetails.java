/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.sys.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 报销记录Entity
 * @author test
 * @version 2018-08-24
 */
public class Expenseclaimdetails extends DataEntity<Expenseclaimdetails> {
	
	private static final long serialVersionUID = 1L;
	private String project;		// 项目编号
	private String classes;		// 报销项
	private String total;		// 报销金额
	
	public Expenseclaimdetails() {
		super();
	}

	public Expenseclaimdetails(String id){
		super(id);
	}

	@Length(min=1, max=64, message="项目编号长度必须介于 1 和 64 之间")
	public String getProject() {
		return project;
	}

	public void setProject(String project) {
		this.project = project;
	}
	
	@Length(min=1, max=64, message="报销项长度必须介于 1 和 64 之间")
	public String getClasses() {
		return classes;
	}

	public void setClasses(String classes) {
		this.classes = classes;
	}
	
	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}
	
}