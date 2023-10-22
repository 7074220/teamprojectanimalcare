package com.itwill.entity;



import java.util.Date;

import org.apache.commons.lang3.builder.ToStringExclude;
import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Coupon {
     @Id
     private Long couponId;
     
	 private String couponName;
	 private Integer couponDiscount;
	 
	 private Date couponExpirationDate;
	 private Date couponPayday;
	 
	 @ManyToOne(cascade = CascadeType.PERSIST,fetch = FetchType.LAZY)
	 @Builder.Default
	 @JoinColumn(name = "user_no")
	 @ToString.Exclude
	 private Userinfo userinfo = new Userinfo();
}
