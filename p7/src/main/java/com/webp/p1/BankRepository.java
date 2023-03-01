package com.webp.p1;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BankRepository extends JpaRepository<Bank, Integer> {
/* 이 부분에 리파지토리 추상메소드가 추가됩니다 */
@Query("select b from Bank b where id=?1 order by tdate desc") 
List<Bank> findByIdOrderByTdateDesc(String id); 
} // interface