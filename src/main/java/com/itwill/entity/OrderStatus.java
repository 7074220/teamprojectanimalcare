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
@EqualsAndHashCode
public class OrderStatus {
	
	@Id
	@SequenceGenerator(name = "orderStatus_no_seq",sequenceName = "orderStatus_no_seq",initialValue = 1,allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "orderStatus_no_seq")
	private Long orderStatusNo;
	private String orderStatusImage;
	private String orderStatusDesc;
	
	@OneToOne(cascade = CascadeType.PERSIST)
	private OrderItem orderItem;
}
