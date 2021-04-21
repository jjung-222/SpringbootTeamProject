package com.mycompany.webapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	private final Logger logger = LoggerFactory.getLogger(HomeController.class);
   @RequestMapping
   public String home() {
	   logger.info("실행");
      return "home";
   }
}