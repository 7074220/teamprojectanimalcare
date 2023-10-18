package com.itwill.entity;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Orders {
	@Id
	@SequenceGenerator(name = "orders_order_no_seq",sequenceName = "orders_order_no_seq",initialValue = 1,allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "orders_order_no_seq")
	private Long orderNo;
	private LocalDate orderDate;
	private Integer orderPrice;
	private String orderAddress;
	private String orderDesc;
	
	@ManyToOne()
	@Builder.Default
	private Userinfo userinfo = new Userinfo();
	
	@OneToMany
	@Builder.Default
	private List<OrderItem> orderItems = new ArrayList<OrderItem>();

}
