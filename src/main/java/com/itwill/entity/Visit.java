package com.itwill.entity;

import java.time.LocalDate;

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
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Visit {

	@Id
	@SequenceGenerator(name = "visit_no_seq", sequenceName = "visit_no_seq", allocationSize = 1, initialValue = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "visit_no_seq")
	private Long visitNo;// PK

	private Long visitTime;

	private LocalDate visitDate;

	private String visitstatus;

	@Builder.Default
	@ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	@JoinColumn(name = "user_Id")
	@ToString.Exclude
	private Userinfo userinfo = new Userinfo();

	@Builder.Default

	@OneToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)

	@ToString.Exclude

	@JoinColumn(name = "center_no")
	private Center center = new Center();

}
