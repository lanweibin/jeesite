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
import com.thinkgem.jeesite.modules.sys.entity.Expenseclaimrecords;
import com.thinkgem.jeesite.modules.sys.service.ExpenseclaimrecordsService;

/**
 * 报销表Controller
 * @author test
 * @version 2018-08-24
 */
@Controller
@RequestMapping(value = "${adminPath}/sys/expenseclaimrecords")
public class ExpenseclaimrecordsController extends BaseController {

	@Autowired
	private ExpenseclaimrecordsService expenseclaimrecordsService;
	
	@ModelAttribute
	public Expenseclaimrecords get(@RequestParam(required=false) String id) {
		Expenseclaimrecords entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = expenseclaimrecordsService.get(id);
		}
		if (entity == null){
			entity = new Expenseclaimrecords();
		}
		return entity;
	}
	
	@RequiresPermissions("sys:expenseclaimrecords:view")
	@RequestMapping(value = {"list", ""})
	public String list(Expenseclaimrecords expenseclaimrecords, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<Expenseclaimrecords> page = expenseclaimrecordsService.findPage(new Page<Expenseclaimrecords>(request, response), expenseclaimrecords); 
		model.addAttribute("page", page);
		return "modules/sys/expenseclaimrecordsList";
	}

	@RequiresPermissions("sys:expenseclaimrecords:view")
	@RequestMapping(value = "form")
	public String form(Expenseclaimrecords expenseclaimrecords, Model model) {
		model.addAttribute("expenseclaimrecords", expenseclaimrecords);
		return "modules/sys/expenseclaimrecordsForm";
	}

	@RequiresPermissions("sys:expenseclaimrecords:edit")
	@RequestMapping(value = "save")
	public String save(Expenseclaimrecords expenseclaimrecords, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, expenseclaimrecords)){
			return form(expenseclaimrecords, model);
		}
		expenseclaimrecordsService.save(expenseclaimrecords);
		addMessage(redirectAttributes, "保存报销表成功");
		return "redirect:"+Global.getAdminPath()+"/sys/expenseclaimrecords/?repage";
	}
	
	@RequiresPermissions("sys:expenseclaimrecords:edit")
	@RequestMapping(value = "delete")
	public String delete(Expenseclaimrecords expenseclaimrecords, RedirectAttributes redirectAttributes) {
		expenseclaimrecordsService.delete(expenseclaimrecords);
		addMessage(redirectAttributes, "删除报销表成功");
		return "redirect:"+Global.getAdminPath()+"/sys/expenseclaimrecords/?repage";
	}

}