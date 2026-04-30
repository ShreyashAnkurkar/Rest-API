package com.nit.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Table(name = "API_EMPLOYEE_TAB")
public class Employee {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	@Nonnull
	private String name;
	@Nonnull
	private String department;
	@Nonnull
	private Double salary;
	
	//metaData properties
	@CreationTimestamp
	@Column(insertable = true,updatable = false)
	private LocalDateTime createdOn;
	@UpdateTimestamp
	@Column(insertable=false,updatable = true)
	private LocalDateTime updatedOn;
	@Version
	private int updateCount;
}
