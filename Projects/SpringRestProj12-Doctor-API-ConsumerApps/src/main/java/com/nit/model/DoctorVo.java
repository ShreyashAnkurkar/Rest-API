package com.nit.model;

import jakarta.annotation.Nonnull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class DoctorVo {

	private Integer id;
	@Nonnull
	private String dname;
	@Nonnull
	private String address;
	@Nonnull
	private Double fees;
	@Nonnull
	private String specialization;
}
