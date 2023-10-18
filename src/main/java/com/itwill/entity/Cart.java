package com.itwill.entity;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringExclude;

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
@AllArgsConstructor
@NoArgsConstructor
public class Cart {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long cartNo;
	private Integer cartQty;
	
	@ManyToOne
	@ToStringExclude
	private Userinfo userinfo = new Userinfo();
	
	
	@OneToOne(mappedBy = "cart")
	@ToStringExclude
	@Builder.Default
	private Product product = new Product();

}