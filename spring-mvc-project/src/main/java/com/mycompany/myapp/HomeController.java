package com.mycompany.myapp;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping(value = "/hi", method = RequestMethod.GET)
	public String hi(HttpServletRequest req, Model model) {
		System.out.println("/hi");
		model.addAttribute("number", 17);
		req.setAttribute("number", 19);
		System.out.println("model: " + model.asMap().get("number"));
		System.out.println("req: " + req.getAttribute("number"));	
		return "forward:/hoho";
	}
	
	@RequestMapping(value = "/hoho", method = RequestMethod.GET)
	public String hoho(HttpServletRequest req, Model model) {
		System.out.println("/hoho");
		System.out.println("model: " + model.asMap().get("number"));
		System.out.println("req: " + req.getAttribute("number"));	
		return null;
	}
	
	@RequestMapping(value = "/go", method = RequestMethod.GET)
	public String go(HttpServletRequest req, Model model) {
		System.out.println("/go");
		req.setAttribute("number", 19);
		System.out.println("req: " + req.getAttribute("number"));		
		return "/oh";
	}
	
	@RequestMapping(value = "/oh", method = RequestMethod.GET)
	public String oh(HttpServletRequest req, Model model) {
		System.out.println("/oh");
		System.out.println("req: " + req.getAttribute("number"));
		return null;
	}
}
