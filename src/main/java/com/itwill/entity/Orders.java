package com.itwill.entity;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

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
	@CreationTimestamp
	private LocalDate orderDate;
	private Integer orderPrice;
	private String orderAddress;
	private String orderDesc;
	
	@ManyToOne(cascade = CascadeType.PERSIST,fetch = FetchType.LAZY)
	@Builder.Default
	@JoinColumn(name = "user_id")
	@ToString.Exclude
	private Userinfo userinfo = new Userinfo();
	
	@OneToMany(mappedBy = "orders",cascade = CascadeType.PERSIST,fetch = FetchType.LAZY)
	@Builder.Default
	private List<OrderItem> orderItems = new ArrayList<OrderItem>();

}
