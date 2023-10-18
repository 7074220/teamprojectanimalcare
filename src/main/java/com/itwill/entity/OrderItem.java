package com.itwill.entity;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
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
	@SequenceGenerator(name = "oi_no_seq",sequenceName = "oi_no_seq",allocationSize = 1,initialValue = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "oi_no_seq")
	private Long oiNo;
	private Integer oiQty;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@Builder.Default
	private Orders orders = new Orders();
	
	@OneToOne(cascade = CascadeType.PERSIST)
	@Builder.Default
	private Product product =new Product();
	
	@OneToOne(cascade = CascadeType.PERSIST)
	@Builder.Default
	private OrderStatus orderStatus = new OrderStatus();
	

}
