package com.itwill.entity;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
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

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long oiNo;
	private Integer oiQty;
	
	@OneToMany
	@Builder.Default
	private Orders orders = new Orders();
	
	@OneToOne
	@Builder.Default
	private  Product product =new Product();
	
	@OneToOne
	@Builder.Default
	private OrderStatus orderStatus = new OrderStatus();
	

}
