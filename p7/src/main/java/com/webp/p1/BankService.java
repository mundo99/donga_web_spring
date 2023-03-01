package com.webp.p1;

import java.text.DecimalFormat;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankService {
	
	@Autowired
	private BankRepository bankRep; 
	
	@Autowired
	private MemberRepository memRep; 
	/* 이 부분에 서비스 메소드가 추가됩니다 */
	
public List<Bank> myhistory(String id) {
	return bankRep.findByIdOrderByTdateDesc(id);
	}

	public String findBalance(String id) {
	int balance = memRep.findBalance(id); /* 정수로 읽어와서 */
	DecimalFormat df = new DecimalFormat("###,###"); /* 쉼표 추가 */
	return df.format(balance);
	}
	
	@Transactional
	public void dewi(String id, int money, int choice) { /* 입출금 */
	Bank b = new Bank(); b.id = id;
	b.de = (choice==1? money: 0); b.wi = (choice==-1? money: 0);
	b.tcode = 0; bankRep.save(b);
	memRep.updateBalance(id, choice*money);
	}

	
	@Transactional
	public boolean transfer(String id, int money, String tid) { /* 이체*/ 
	if( !memRep.existsById(tid) ) 
	return false;
	Bank b = new Bank();
	b.id = id; /* 보내는사람 */
	b.de = 0;
	b.wi = money; 
	b.tcode = 1; /* 이체보냄 */
	b.tid = tid;
	bankRep.save(b);
	memRep.updateBalance(id, -money);
	b = new Bank(); /* new 안 하면 bank.no가 같아서 insert아니고 update됨 */
	b.id = tid; /* 받는 사람 */
	b.de = money; 
	b.wi = 0;
	b.tcode = 2; /* 이체받음 */
	b.tid = id;
	bankRep.save(b);
	memRep.updateBalance(tid, money);
	return true; 
	}
	
	
	
} // class