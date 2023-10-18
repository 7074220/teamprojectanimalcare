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
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cart {
	
	@Id
	@SequenceGenerator(name = "cart_no_seq",sequenceName = "cart_no_seq",allocationSize = 1,initialValue = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "cart_no_seq")
	private Long cartNo;
	private Integer cartQty;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@ToStringExclude
	@JoinColumn(name = "user_id")
	private Userinfo userinfo = new Userinfo();
	
	@OneToOne(cascade = CascadeType.PERSIST)
	@ToStringExclude
	@Builder.Default
	@JoinColumn(name = "product_no")
	private Product product = new Product();

}