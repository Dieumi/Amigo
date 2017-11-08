package com.amigo.type;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TypeServiceImpl implements TypeService {
	@Autowired
	TypeRepository typeRepository;
	@Override
	public TypeDTO createType(TypeDTO typeDTO) {
		typeRepository.save(TypeAdapter.fromDtoToType(typeDTO));
        return typeDTO;
	}

	@Override
	public TypeDTO deleteType(String id) {
        Type productToDelete = typeRepository.findByid(id);
        typeRepository.delete(productToDelete);
        return TypeAdapter.fromTypeToDto(productToDelete);
	}

	@Override
	public TypeDTO updateType(TypeDTO typeDTO) {
        typeRepository.save(TypeAdapter.fromDtoToType(typeDTO));
        return typeDTO;
	}

	@Override
	public TypeDTO getTypeById(String id) {
        Type typeToRetrieve = typeRepository.findByid(id);
        return TypeAdapter.fromTypeToDto(typeToRetrieve);
	}

	@Override
	public List<TypeDTO> getListType() {
		return TypeAdapter.fromProductListToDtoList(typeRepository.findAll());
	}

}
