package com.webp.p1;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller 
public class MyController {
	@GetMapping("/") /* 서버 접속 첫화면을 의미 */
	public String home() {
		return "home"; 
	}
	
	@GetMapping("/ex01") // 주소창에 /ex01 이면..
	public String ex01() { // 메소드명 자유
		return "ex01"; // templates폴더에 ex01 호출
	}
	
	@PostMapping("/ex01/answer")
	public String ex01Answer(String id,String pw, Model model) {
		model.addAttribute("id",id);
		model.addAttribute("pw",pw);
		return "ex01Answer";
	}
	
	
	@GetMapping("/wise") 
	public String wise() {
		return "wise"; 
	}
	
	@PostMapping("/wise/answer")
	public String wiseAnswer(String person,String contents, Model model) {
		model.addAttribute("person",person);
		model.addAttribute("contents",contents);
		return "wiseAnswer";
	}
	
	
	@GetMapping("/bread") 
	public String bread() {
		return "bread"; 
	}
	
	@PostMapping("/bread/answer")
	public String breadAnswer(String bread,int price,int num, Model model) {
		model.addAttribute("bread",bread);
		model.addAttribute("price",price);
		model.addAttribute("num",num);
		model.addAttribute("sum",num*price);
		return "breadAnswer";
	}
		
	@GetMapping("/ex02")
	public String ex02() {
		return "ex02";
	}
	@PostMapping("/ex02/answer")
	public String ex02Answer(String name, String po, Model model) {
	model.addAttribute("name", name);
	model.addAttribute("po", po);
	int salary = 0;
	switch(po){
		case "사원":
		 salary = 3500; 
		case "대리":
		salary = 5000; 
		case "팀장":
		 salary = 7000; 
		case "임원":
		salary = 9900; 
	}
	
	model.addAttribute("salary", salary);
		return "ex02Answer";
	}

	@GetMapping("/ex03")
	public String ex03() {
		return "ex03";
	}
	@PostMapping("/ex03/answer")
	public String ex03Answer(String name, String color, Model model) {
		model.addAttribute("name", name);
		model.addAttribute("color", color);
		return "ex03Answer";
	}
	
	@GetMapping("/ex04")
	public String ex04Answer(Model model) {
		ArrayList<String> list = new ArrayList<String>();
		list.add("고흐");
		list.add("james");
		list.add("dooli");
		list.add("bread");
		model.addAttribute("list",list);
		return "ex04";
	}
	@GetMapping("/q06")
	public String q06() {
		return "q06"; 
	}
	
	@GetMapping("q06a")
	public String q06a() {
		return "q06a"; 
	}
	
	@PostMapping("/q06a/q06aa")
	public String q06aa(String job,String job2, Model model) {
		model.addAttribute("job",job);
		model.addAttribute("job2",job2);
		return "q06aa";
	}
	
	@GetMapping("q06b")
	public String q06b() {
		return "q06b"; 
	}
	
	@PostMapping("/q06b/q06bb")
	public String q06bb(String jobList, Model model) {
		model.addAttribute("jobList",jobList);
		return "q06bb";
	}
	
	
}
