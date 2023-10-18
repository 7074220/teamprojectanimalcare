package com.itwill.entity;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringExclude;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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
@AllArgsConstructor
@NoArgsConstructor

public class Product {

	
	@Id
	@SequenceGenerator(name = "product_product_no_seq",sequenceName = "product_product_no_seq",initialValue = 1,allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "product_product_no_seq")
	private Long productNo;
	private String productName;
	private Integer productPrice;
	private String productCategory;
	private Integer productAmount;
	private String productImage;
	private Integer productStarAvg;
	
	@OneToOne(cascade = CascadeType.PERSIST)
	@ToStringExclude
	private OrderItem orderItems = new OrderItem();

}
