package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "product")
@Getter @Setter
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long pid;
	
	private String pname; // ��ǰ��
	
	private String ptype; // ��ǰ ī�װ�
	
	private Integer pprice; // ��ǰ ����
	
	private Integer pstock; // ��ǰ ����
	
	private String pImg1; // ��ǰ�̹���1
//	
//	private String pImg2; // ��ǰ�̹���2
//	
//	private String pImg3; // ��ǰ�̹���3
	
	private String pdetail; // ��ǰ �󼼼���
	
	public Product() {
		
	}
	
	public Product(String pname, String ptype, Integer pprice, Integer pstock, String pImg1, String pdetail) {
		this.pname = pname;
		this.ptype = ptype;
		this.pprice = pprice;
		this.pstock = pstock;
		this.pImg1 = pImg1;
		this.pdetail = pdetail;
	}
	
}
