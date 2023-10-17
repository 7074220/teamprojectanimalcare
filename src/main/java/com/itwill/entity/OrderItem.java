package com.itwill.entity;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor

public class OrderItem {

	private Long oiNo;
	private Integer oiQty;
	
	
	
	@OneToMany
	private List<Orders> orders = new ArrayList<>();
	@OneToOne
	private  Product product =new Product();
	@OneToOne
	private OrderStatus orderStatus = new OrderStatus();
	

}
