package com.adele.spring.common;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {
	@ExceptionHandler(Exception.class)
	public String catchException(Exception e, Model model) {
		e.printStackTrace();
		model.addAttribute("msg", e.getMessage());
		return "common/errorPage";
	}
}
