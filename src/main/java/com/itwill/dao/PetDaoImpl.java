package com.itwill.dao;

import java.util.List;
import java.util.Optional;

import com.itwill.entity.Pet;
import com.itwill.repository.PetRepository;

public class PetDaoImpl implements PetDao {

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
		Optional<Pet> selectedPetOptional = petRepository.findById(petNo);
		if(selectedPetOptional.isEmpty()) {
			throw new Exception("존재하지 않습니다.");
		}
		petRepository.delete(selectedPetOptional.get());
	}
		
	

	@Override
	public Pet petUpdate(Pet pet)throws Exception {
		Optional<Pet> selectedPetOptional = petRepository.findById(pet.getPetNo());
		Pet updatePet=null;
		if(selectedPetOptional.isEmpty()) {
			Pet pet1 = selectedPetOptional.get();
			pet1.setPetLocal(pet.getPetLocal());
			pet1.setPetType(pet.getPetType());
			pet1.setPetgender(pet.getPetgender());
			pet1.setPetRegisterDate(pet.getPetRegisterDate());
			pet1.setPetFindPlace(pet.getPetFindPlace());
			pet1.setPetCharacter(pet.getPetCharacter());
			pet1.setPetCenter(pet.getPetCenter());
			updatePet=petRepository.save(pet1);
		}else {
			throw new Exception("존재하지않습니다.");
		}
		return updatePet;
	}

	//최신등록순 정렬
	@Override
	public List<Pet> findAllByNo(Long petNo) {
		List<Pet> petList = petRepository.findAllByOrderByPetNoDesc(petNo);
		return petList;
	}

}
