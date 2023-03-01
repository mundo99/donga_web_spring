package com.webp.p1;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, String> {
		@Transactional 
		@Modifying 
		@Query("update Member set pw=?2, name=?3, phone=?4 where id=?1") 
		int updateMyinfo(String id, String pw, String name, String phone);
		
		@Query("select count(id) from Member")
		int findCount();
		
		@Query("select balance from Member where id=?1") 
		int findBalance(String id);
		
		@Modifying 
		@Query("update Member set balance=balance+?2 where id=?1") 
		int updateBalance(String id, int money);
		
		@Query("select count(id) from QA where id=?1") 
		int findQCount(String id);
		
		@Query("select m from Member m where balance > 50000000")
		List<Member> findVip();
} // interface