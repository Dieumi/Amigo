package com.amigo.typeVoyage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeVoyageServiceImpl implements TypeVoyageService {
	@Autowired
	TypeVoyageRepository typeRepository;
	@Override
	public TypeVoyageDTO createType(TypeVoyageDTO typeDTO) {
		typeRepository.save(TypeVoyageAdapter.fromDtoToType(typeDTO));
        return typeDTO;
	}

	@Override
	public TypeVoyageDTO deleteType(String id) {
        TypeVoyage productToDelete = typeRepository.findByid(id);
        typeRepository.delete(productToDelete);
        return TypeVoyageAdapter.fromTypeToDto(productToDelete);
	}

	@Override
	public TypeVoyageDTO updateType(TypeVoyageDTO typeDTO) {
        typeRepository.save(TypeVoyageAdapter.fromDtoToType(typeDTO));
        return typeDTO;
	}

	@Override
	public TypeVoyageDTO getTypeById(String id) {
        TypeVoyage typeToRetrieve = typeRepository.findByid(id);
        return TypeVoyageAdapter.fromTypeToDto(typeToRetrieve);
	}

	@Override
	public List<TypeVoyageDTO> getListType() {
		return TypeVoyageAdapter.fromProductListToDtoList(typeRepository.findAll());
	}

}
