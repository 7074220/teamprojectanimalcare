package com.itwill.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itwill.entity.Pet;
import com.itwill.repository.PetRepository;

@Repository
public class PetDaoImpl implements PetDao {
	@Autowired
	PetRepository petRepository;
	
	@Override
	public Pet petFindById(Long petNo) {
		Pet pet = petRepository.findById(petNo).get();	
		return pet;
	}

	@Override
	public List<Pet> petFindAll() {
		List<Pet> petList = petRepository.findAll();
		return petList;
	}

	@Override
	public Pet petInsert(Pet pet) {
		Pet petSave = petRepository.save(pet);
		return petSave;
	}

	@Override
	public void petDelete(Long petNo) throws Exception {
		
		petRepository.deleteById(petNo);
	}
		
	

	@Override
	public Pet petUpdate(Pet updatepet)throws Exception {
		return petRepository.save(updatepet);
	}

	//최신등록순 정렬
	@Override
	public List<Pet> findAllByOrderBypetNoDesc() {
		List<Pet> petList = petRepository.findAllByOrderByPetNoDesc();
		return petList;
	}

	
	

}
