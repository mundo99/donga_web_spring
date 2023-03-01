package com.webp.p1;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.Id;
import org.hibernate.annotations.CreationTimestamp;

@Entity
public class Sale {
	@Id public String id;
	public Integer number;
	public Integer count;
	public Integer price;
	public String product;
@CreationTimestamp public LocalDateTime rdate;

} // class