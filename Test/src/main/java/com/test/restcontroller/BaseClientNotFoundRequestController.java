package com.test.restcontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value = {"/person", "/person/detail/", "payment/update/"})
@Controller
public class BaseClientNotFoundRequestController {
						 
	@GetMapping(value = "/{path:[^\\.]*}")
	public String redirect(){
		return "forward:/index.html";
	}

}
