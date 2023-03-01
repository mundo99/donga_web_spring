package com.webp.p1;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface QARepository extends JpaRepository<QA, Integer> {
	@Transactional  // 업데이트 쿼리인 경우 써줌
	@Modifying 
	@Query("update QA set adate = now(), answer = ?2 where no = ?1") 
	int updateAnswer(int no,String answer);

	

}
