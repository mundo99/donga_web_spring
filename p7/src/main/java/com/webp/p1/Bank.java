package com.webp.p1;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;

@Entity
public class Bank {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
public Integer no; 
public String id;
@CreationTimestamp
public LocalDateTime tdate;
public Integer de; 
public Integer wi; 
public Byte tcode;
public String tid;
}