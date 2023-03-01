package com.webp.p1;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;

@Entity

public class Memo {
	@Id
	public String title;
	public String memo;
	@CreationTimestamp public LocalDateTime wdate;
	} // class