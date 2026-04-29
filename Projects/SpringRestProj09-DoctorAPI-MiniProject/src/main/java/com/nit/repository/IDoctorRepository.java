package com.nit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nit.entity.DoctorEntity;

public interface IDoctorRepository extends JpaRepository<DoctorEntity, Integer> {

}
