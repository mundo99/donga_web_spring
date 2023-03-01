package com.webp.p1;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class YourController {
	
	@GetMapping("/login")
	public String login() {
	return "login";
	}
	
	
	@PostMapping("/login/check")
	public String loginCheck(HttpSession session, String id) {
	ArrayList<String> list = new ArrayList<String>();
	list.add("고흐");
	list.add("james");
	list.add("dooli");
	list.add("bread");
	if( list.contains(id) ) {
		session.setAttribute("id", id);
	return "redirect:/menu";
	}
	else
	return "popups";
	}
	
	@GetMapping("/menu")
	public String menu(HttpSession session, Model model) {
	model.addAttribute("id", session.getAttribute("id"));
	return "menu";
	}
	
	@GetMapping("/popups")
	public String popups() {
	return "popups";
	}
	
	
	@GetMapping("/logout")
	public String logout(HttpSession session, Model model) {
	model.addAttribute("id", session.getAttribute("id"));
	session.invalidate(); // 세션초기화 
	return "logout";
	}
	
	
	@GetMapping("/start")
	public String start() { 
		return "start"; 
		}
	
	@PostMapping("/survey1")
	public String survey1(HttpSession session, String id) {
	session.setAttribute("id",id);
	return "survey1"; 
	}
	
	@PostMapping("/survey2")
	public String survey2(HttpSession session, String artist) {
	session.setAttribute("artist",artist);
	return "survey2"; 
	}
	
	@PostMapping("/thanks")
	public String thanks(HttpSession session, String musician) {
	session.setAttribute("musician",musician);
	return "thanks"; 
	}
	
	@GetMapping("/result")
	public String result(HttpSession session, Model model) {
	model.addAttribute("id",session.getAttribute("id"));
	model.addAttribute("artist",session.getAttribute("artist"));
	model.addAttribute("musician",session.getAttribute("musician"));
	return "result"; 
	}
	
	
	
	
	@GetMapping("/phone")
	public String phone() { 
	return "phone"; 
	}
	
	
	@PostMapping("/phone/result")
	public String phoneResult(HttpSession session, Model mo,String company,String model) {
		if(company.equals("삼성") || company.equals("애플")) {
			session.setAttribute("company", company);
			session.setAttribute("model", model);
			mo.addAttribute("msg",company +" " + model +"를 선택해 주셔서 감사합니다!!");
		return "phoneThanks";
		}
		else
			mo.addAttribute("msg","해당 회사의 제품은 매진되었습니다.");
		return "phoneThanks";
	}
	
	@GetMapping("/phone/session")
	public String phoneSession(HttpSession session, Model mo) {
	mo.addAttribute("company",session.getAttribute("company"));
	mo.addAttribute("model",session.getAttribute("model"));
	session.invalidate();
	return "phoneSession"; 
	}
	
	@GetMapping("/car")
	public String car() { 
		return "car"; 
		}
	
	@PostMapping("/car/save")
	public String carSave(HttpSession session,String car,String color,Model model) {
		session.setAttribute("car", car);
		session.setAttribute("color", color);
		model.addAttribute("car", session.getAttribute("car"));
		model.addAttribute("color", session.getAttribute("color"));

		return "carSave";
	}
	
	@GetMapping("/phone2")
	public String phone2() { 
	return "phone2"; 
	}
	
}

