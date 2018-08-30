/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.sys.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.modules.sys.entity.Expenseclaimdetails;
import com.thinkgem.jeesite.modules.sys.service.ExpenseclaimdetailsService;

/**
 * 报销记录Controller
 * @author test
 * @version 2018-08-24
 */
@Controller
@RequestMapping(value = "${adminPath}/sys/expenseclaimdetails")
public class ExpenseclaimdetailsController extends BaseController {

	@Autowired
	private ExpenseclaimdetailsService expenseclaimdetailsService;
	
	@ModelAttribute
	public Expenseclaimdetails get(@RequestParam(required=false) String id) {
		Expenseclaimdetails entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = expenseclaimdetailsService.get(id);
		}
		if (entity == null){
			entity = new Expenseclaimdetails();
		}
		return entity;
	}
	
	@RequiresPermissions("sys:expenseclaimdetails:view")
	@RequestMapping(value = {"list", ""})
	public String list(Expenseclaimdetails expenseclaimdetails, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<Expenseclaimdetails> page = expenseclaimdetailsService.findPage(new Page<Expenseclaimdetails>(request, response), expenseclaimdetails); 
		model.addAttribute("page", page);
		return "modules/sys/expenseclaimdetailsList";
	}

	@RequiresPermissions("sys:expenseclaimdetails:view")
	@RequestMapping(value = "form")
	public String form(Expenseclaimdetails expenseclaimdetails, Model model) {
		model.addAttribute("expenseclaimdetails", expenseclaimdetails);
		return "modules/sys/expenseclaimdetailsForm";
	}

	@RequiresPermissions("sys:expenseclaimdetails:edit")
	@RequestMapping(value = "save")
	public String save(Expenseclaimdetails expenseclaimdetails, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, expenseclaimdetails)){
			return form(expenseclaimdetails, model);
		}
		expenseclaimdetailsService.save(expenseclaimdetails);
		addMessage(redirectAttributes, "保存报销项表成功");
		return "redirect:"+Global.getAdminPath()+"/sys/expenseclaimdetails/?repage";
	}
	
	@RequiresPermissions("sys:expenseclaimdetails:edit")
	@RequestMapping(value = "delete")
	public String delete(Expenseclaimdetails expenseclaimdetails, RedirectAttributes redirectAttributes) {
		expenseclaimdetailsService.delete(expenseclaimdetails);
		addMessage(redirectAttributes, "删除报销项表成功");
		return "redirect:"+Global.getAdminPath()+"/sys/expenseclaimdetails/?repage";
	}

}