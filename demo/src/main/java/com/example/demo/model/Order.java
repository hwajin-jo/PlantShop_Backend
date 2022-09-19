package com.example.demo.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import org.springframework.web.bind.annotation.CrossOrigin;

import lombok.Getter;
import lombok.Setter;

@CrossOrigin(origins = "http://localhost:8081")
@Entity
@Table(name = "orders")
@Setter @Getter
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long oid; //주문 아이디
	
//	@ManyToOne
	@JoinColumn(name = "username")
	private String username; //고객명
	
	@JoinColumn(name = "pname")
	private String pname; // 상품명
	
	@JoinColumn(name = "pprice")
	private Integer pprice; // 상품 가격
	
	@JoinColumn(name = "pstock")
	private Integer pstock; // 상품 갯수
	
	@JoinColumn(name = "pid")
	private Integer pid; // 상품 아이디
	
	@JoinColumn(name = "pimg1")
	private String pimg1; // 상품 이미지
	
	@Column(length = 50/*, nullable = false*/)
	private String oname;//수령인
	
	@Column(length = 50/*, nullable = false*/)
	private Integer ocount;//주문 수량
	
	@Column(length = 100/*, nullable = false*/)
	private String oaddress;//수령인 주소
	
	@Column(length = 50/*, nullable = false*/)
	private String ophone;//수령인 연락처
	
	@Column(length = 10/*, nullable = false*/)
	private String opost;//수령지 우편번호
	
	@Column(length = 50/*, nullable = false*/)
	private String opayment;//결제 수단
	
	private Integer ototal;
	
	@Column(columnDefinition = "VARCHAR(20) default '결제완료'")
	private String ostatus;//주문 상태
	
	private LocalDate odate; //주문일
	
//	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
//	private List<OrderProduct> orderProducts = new ArrayList<>();
//	
//	public void addOrderItem(OrderProduct orderProduct) {
//		orderProducts.add(orderProduct);
//		orderProduct.setOrder(this);
//	}
	
	public Order(String oname, Integer ocount, String oaddress, String ophone, String opost, String opayment,
			LocalDate odate, String pname, Integer ototal,Integer pprice, Integer pstock, Integer pid, String ostatus,String pimg1, String username) {
		this.oname = oname;
		this.ocount = ocount;
		this.oaddress = oaddress;
		this.ophone = ophone;
		this.opost = opost;
		this.opayment = opayment;
		this.odate = odate;
		this.pname = pname;
		this.pprice = pprice;
		this.pstock = pstock;
		this.pid = pid;
		this.pimg1 = pimg1;
		this.ostatus = ostatus;
		this.ototal = ototal;
		this.username = username;
	}
	
	public Order(String oname, Integer ocount, String oaddress, String ophone, String opost, String opayment,
			LocalDate odate, String pname, Integer pprice) {
		this.oname = oname;
		this.ocount = ocount;
		this.oaddress = oaddress;
		this.ophone = ophone;
		this.opost = opost;
		this.opayment = opayment;
		this.odate = odate;
		this.pname = pname;
		this.ototal = ototal;
		this.pprice = pprice;
	}
	
	public Order(Integer pid, String pname, Integer pprice,Integer ototal, Integer ocount, String pimg1,LocalDate odate,String username) {
		this.pid = pid;
		this.pname = pname;
		this.pprice = pprice;
		this.ocount = ocount;
		this.odate = odate;
		this.pimg1 = pimg1;
		this.ototal = ototal;
		this.username = username;
	}
	
	public Order() {
		// TODO Auto-generated constructor stub
	}

}
