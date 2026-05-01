package com.nit.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nit.entity.DoctorEntity;
import com.nit.exceptions.DoctorNotFoundException;
import com.nit.repository.IDoctorRepository;
import com.nit.vo.DoctorVo;

@Service
public class DoctorManagementServiceImpl implements IDoctorManagementService {

	@Autowired
	private IDoctorRepository docRepo;
	
	@Override
	public String registerDoctor(DoctorVo vo) {
		
		DoctorEntity entity=new DoctorEntity();
		BeanUtils.copyProperties(vo, entity);
		
		entity.setCreatedBy(System.getProperty("user.name"));
		int id=docRepo.save(entity).getId();
		return "Doctor Record is saved with id :"+id;
	}

	@Override
	public String registerDoctors(List<DoctorVo> listVo) {
		
		List<DoctorEntity> listEntity=new ArrayList<>();
		
		listVo.forEach(vo->{
			DoctorEntity entity=new DoctorEntity();
			BeanUtils.copyProperties(vo, entity);
			entity.setCreatedBy(System.getProperty("user.name"));
			listEntity.add(entity);
		});
		
		List<Integer> ids=docRepo.saveAll(listEntity).stream().map(DoctorEntity::getId).toList();
		
		return ids.size()+" Number of reccords with id value: "+ids+" is saved";
		
	}

	@Override
	public DoctorVo showDoctorById(int id) {
		
		DoctorEntity res=docRepo.findById(id).orElseThrow(()->new DoctorNotFoundException("Invalid id"));
		DoctorVo vo=new DoctorVo();
		BeanUtils.copyProperties(res, vo);
		
		return vo;
	}

	@Override
	public List<DoctorVo> showAllDoctors() {
		
		List<DoctorEntity> list=docRepo.findAll();
		List<DoctorVo>listVo=new ArrayList<>();
		
		list.forEach(entity->{
			DoctorVo vo=new DoctorVo();
			BeanUtils.copyProperties(entity,vo);
			listVo.add(vo);
		});
		
		listVo.sort((v1,v2)-> v1.getDname().compareTo(v2.getDname()));
		return listVo; 
	}

	@Override
	public String hikeDoctorFeeById(int id, float hikePercentage) {
		
		DoctorEntity entity=docRepo.findById(id).orElseThrow(()-> new DoctorNotFoundException("Invalid Id"));
		entity.setFees(entity.getFees()+(entity.getFees()*hikePercentage/100));
		entity.setUpdatedBy(System.getProperty("user.name"));
		   double uFee=docRepo.save(entity).getFees();
		   
		   return id+"Doctor fee is updated by"+hikePercentage+" % "+"Updated Fees: "+uFee;
	}

	@Override
	public String updateDocterDetails(DoctorVo vo) {
		
		DoctorEntity entity=docRepo.findById(vo.getId()).orElseThrow(()-> new DoctorNotFoundException("Invalid Id"));
		BeanUtils.copyProperties(vo, entity);
		entity.setUpdatedBy(System.getProperty("user.name"));
		docRepo.save(entity);
		return entity.getId()+" Doctor Details Updated Successfully";
	}

	@Override
	public String deleteDoctorbyId(int id) {
		
		DoctorEntity entity=docRepo.findById(id).orElseThrow(()->new DoctorNotFoundException("Invalid Doctor id"));
		docRepo.delete(entity);
		return id+" record is deleted";
	}

	@Override
	public String deleteDoctorsByFeeRange(float start, float end) {
		
		int count=docRepo.removeDoctorByFeeRange(start, end);
		return count==0?"No Doctor found with fee range "+start+" to "+end:count+" number of Doctors are deleted with fee range "+start+" to "+end;
	}
	

}
