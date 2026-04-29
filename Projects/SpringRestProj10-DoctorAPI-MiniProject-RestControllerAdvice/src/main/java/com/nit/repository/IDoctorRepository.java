package com.nit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.nit.entity.DoctorEntity;

import jakarta.transaction.Transactional;

public interface IDoctorRepository extends JpaRepository<DoctorEntity, Integer> {

	@Query("delete from DoctorEntity where fees>=:start and fees<=:end")
	@Modifying
	@Transactional
	public int removeDoctorByFeeRange(float start,float end);
}
