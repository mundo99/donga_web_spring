package com.webp.p1;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class VanController1 {
	
	/*
	 * @Autowired private MemberRepository memRep;
	 * 
	 * @GetMapping("/member/list") public String memberList(Model mo) { List<Member>
	 * list = memRep.findAll(Sort.by(Sort.Direction.DESC, "rdate"));
	 * mo.addAttribute("list",list); return "memberList"; }
	 */
	
	@Autowired
	private SaleRepository saleRep;
	
	@GetMapping("/sale/list")
	public String saleList(Model mo) {
	List<Sale> list = saleRep.findAll(Sort.by(Sort.Direction.ASC, "number"));
	mo.addAttribute("list",list);
	return "saleList";
	}
	
	
	@Autowired private MemoRepository memoRep;
	  
	@GetMapping("/memo/list") 
	public String memoList(Model mo) { 
	List<Memo> list = memoRep.findAll(); 
	mo.addAttribute("list",list); return "memoList"; 
	}
	 
	
	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	@GetMapping("/member/register")
	public String memberRegister() { 
		return "memberRegister";
		}
	
		/*
		 * @PostMapping("/member/insert") public String memberInsert(String id, String
		 * pw, String name, String phone, Model mo) { Member member= new Member();
		 * member.id = id; member.pw = pw; member.name = name; member.phone= phone;
		 * member.balance= 0; memRep.save(member);
		 * mo.addAttribute("msg",id+"님,회원가입을 축하드립니다!!"); return "popups"; }
		 */
	
	@GetMapping("/memo")
	public String memo() { 
		return "memo";
		}
	
	@PostMapping("/memo/insert")
	public String memoInsert(String title, String memo, Model mo) {
		Memo memoo= new Memo();
		memoo.title = title;      
		memoo.memo = memo; 
		memoRep.save(memoo);
		return "mpopups";
	}
	
	@GetMapping("/foods")
	public String foods() {
	return "foods";
	}
	
	@PostMapping("/foods/result")
	public String foodsResult(String gender, int age, String[] arr, 
	int face, int grade, int omg, String comments, Model mo) {
	mo.addAttribute("gender", gender);
	mo.addAttribute("age", age);
	String temp = "";
	if(arr==null) temp = "없음";
	else {
			for(int i=0; i<arr.length; i++) {
				temp += arr[i];
				if(arr!= null)
					temp+=",";
		        }
			 temp = temp.replaceAll(",$", "");
			}
	mo.addAttribute("foods", temp);
	mo.addAttribute("face", face);
	mo.addAttribute("grade", grade);
	mo.addAttribute("omg", omg);
	mo.addAttribute("comments", comments);
	return "foodsResult";
	}
	
	@GetMapping("/star/1")
	public String star() {
		return "star";
		}
	
	@GetMapping("/star/2")
	public String star2(String choice1,Model mo) { 
		mo.addAttribute("choice1",choice1);
		return "star2";
		}
	
	@Autowired 
	private StarRepository starRep;
	
	@GetMapping("/star/3")
	public String star3(String choice1,String choice2,Model mo){
		mo.addAttribute("choice1",choice1);
		mo.addAttribute("choice2",choice2);
		return "star3";
		}
	
	@GetMapping("/star/winner")
	public String starWinner(String h_winner1,String h_winner2,String winner,Model mo){
		starRep.updateCountF(winner);
		mo.addAttribute("winner",winner);
		if(winner.equals(h_winner1)) {
			starRep.updateCountS(h_winner2);
		}
		else if(winner.equals(h_winner2)) {
			starRep.updateCountS(h_winner1);
		}
		return "starWinner";
		}
	
	@GetMapping("/star/list")
	public String starList(Model mo) {
		List<Star> list = starRep.findAll(Sort.by(Sort.Direction.DESC, "name")); 
		mo.addAttribute("list",list);
	return "starList";
	}
	
	@GetMapping("/star/reset")
	public String starReset() {
		starRep.starReset();
		return "redirect:/star/list";
	}
} // class
