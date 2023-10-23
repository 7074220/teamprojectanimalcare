package com.itwill.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderStatus {
	
	@Id
	@SequenceGenerator(name = "OrderStatus_orderStatus_no_SEQ",sequenceName = "OrderStatus_orderStatus_no_SEQ",initialValue = 1,allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "OrderStatus_orderStatus_no_SEQ")
	private Long orderStatusNo;
	private String orderStatusImage;
	private String orderStatusDesc;
	
	@OneToOne(mappedBy = "orderStatus", cascade = CascadeType.PERSIST)
	private OrderItem orderItem;
}
