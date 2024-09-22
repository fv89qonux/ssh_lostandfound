package com.lin.lostandfound.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/handel-error")
public class HandelErrorController {
	
	// 获取拒绝访问视图
	@RequestMapping(value = { "/refuse-error.html" })
	public String refuseError() {

		return "error/refuse-error";
	}

}
