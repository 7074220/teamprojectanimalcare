package com.itwill.entity;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringExclude;

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
@AllArgsConstructor
@NoArgsConstructor
public class Cart {

	private Long cartNo;
	private Integer cartQty;
	
	@OneToOne
	@ToStringExclude
	private Userinfo userinfo = new Userinfo();
	
	
	@OneToMany(mappedBy = "cart")
	@ToStringExclude
	
	private List<Product> products = new ArrayList<>();
}
