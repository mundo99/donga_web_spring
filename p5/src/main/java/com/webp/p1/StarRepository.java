package com.webp.p1;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface StarRepository extends JpaRepository<Star, Integer> 
{
	@Transactional  // 업데이트 쿼리인 경우 써줌
	@Modifying 
	@Query("update Star s set s.count_final=s.count_final+1 where name=?1") // 우승 카운터 증가
	int updateCountF(String name);
	
	@Transactional 
	@Modifying 
	@Query("update Star s set s.count_semi=s.count_semi+1 where name=?1") // 준우승 카운터 증가
	int updateCountS(String name);

	@Transactional 
	@Modifying 
	@Query("update Star s set count_final=0,count_semi=0") // 우승,준우승 카운터 리셋
	int starReset();

}