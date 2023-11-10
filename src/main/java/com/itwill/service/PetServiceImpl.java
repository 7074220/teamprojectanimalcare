package com.itwill.service;

import java.lang.StackWalker.Option;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itwill.dao.PetDao;
import com.itwill.entity.Pet;
import com.itwill.entity.Product;
@Transactional
@Service
public class PetServiceImpl implements PetService{
@Autowired
private PetDao petDao;
	
	@Override
	public Pet petFindById(Long petNo) {
		Pet pet = petDao.petFindById(petNo);
		return pet;
	}
	
	@Override
	public Page<Pet> petFindAllPage(Pageable pageable){
		Page<Pet> petList=petDao.petFindAllPage(pageable);
		return petList;
	}
	
	
	 public List<Pet> petFindAll() { 
		 List<Pet> petList = petDao.petFindAll();
	  return petList; }
	 

	@Override
	public Pet petSave(Pet pet) {
		 
		return petDao.petInsert(pet);
	}

	@Override
	public void petRemove(Long petNo) throws Exception {
	
	petDao.petDelete(petNo);
	}
	
	@Override
	public Pet petUpdate(Pet pet) throws Exception {
		return petDao.petUpdate(pet);
	}

	@Override
	public List<Pet> findAllByOrderBypetNoDesc() {
	 
		return petDao.findAllByOrderBypetNoDesc();
	}

	@Override
	public List<Pet> findAllByOrderBypetType(String petType) {
		return petDao.findAllByOrderByPetType(petType);
	}
	
	@Override
	public List<Pet> findAllByPetLocal(String petLocal) {
		
		return petDao.findAllByPetLocal(petLocal);
	}
	
}
