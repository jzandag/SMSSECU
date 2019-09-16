package com.sms.controller;
		
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sms.base.BaseController;
import com.sms.service.StudentService;
import com.sms.util.InventoryUtility;
	
/*
 * Controller for general pages
 *  - zidrex
 */
@Controller
public class GeneralTilesController extends BaseController{
	
	protected static Logger logger = Logger.getLogger(GeneralTilesController.class);
	
	@Autowired
	private StudentService studentService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String welcome() {
		return "loginPage";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String getLoginPage(ModelMap model, HttpServletRequest request, @RequestParam(value="error", required = false) Boolean isError) {
		logger.debug("Received request to show login page");
		model.clear();
		if(!InventoryUtility.isNull(isError) && isError) {
			logger.info("isError: " + isError);
			System.out.println("login url");
			request.getSession().setAttribute("isError", isError);
			return "redirect:/institute/login";
		}
		
		return "loginPage";
	}
	
	
	
	
}

