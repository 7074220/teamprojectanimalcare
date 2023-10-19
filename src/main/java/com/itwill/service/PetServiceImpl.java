package com.itwill.service;

import java.lang.StackWalker.Option;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itwill.dao.PetDao;
import com.itwill.entity.Pet;
import com.itwill.entity.Product;
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
	public List<Pet> petFindAll() {
		List<Pet> petList = petDao.petFindAll();
		return petList;
	}

	@Override
	public Pet petSave(Pet pet) {
		 
		return petDao.petInsert(pet);
	}

	@Override
	public void petRemove(Long petNo) throws Exception {
	
	Optional<Pet> petOptional = Optional.of(petDao.petFindById(petNo));
	if(petOptional.isEmpty()) {
		throw new Exception("존재하지 않는 제품입니다.");
	
		}
	petDao.petDelete(petNo);
	}

	@Override
	public Pet petUpdate(Pet pet) throws Exception {
		Optional<Pet> petOptional = Optional.of(petDao.petFindById(pet.getPetNo()));
		Pet updatedPet = null;
		if(petOptional.isPresent()) {
			Pet pet1 = petOptional.get();
			pet1.setPetLocal(pet.getPetLocal());
			pet1.setPetType(pet.getPetType());
			pet1.setPetgender(pet.getPetgender());
			pet1.setPetRegisterDate(pet.getPetRegisterDate());
			pet1.setPetFindPlace(pet.getPetFindPlace());
			pet1.setPetCharacter(pet.getPetCharacter());
			pet1.setCenter(pet.getCenter());
			
			updatedPet=petDao.petUpdate(pet1);
		}
		return updatedPet;
	}

	@Override
	public List<Pet> findAllByOrderBypetNoDesc() {
	 
		return petDao.findAllByOrderBypetNoDesc();
	}

}
