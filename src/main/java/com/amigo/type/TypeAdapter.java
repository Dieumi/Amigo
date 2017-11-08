package com.amigo.type;

import java.util.ArrayList;
import java.util.List;

import com.amigo.user.User;
import com.amigo.user.UserDTO;
import com.amigo.voyage.VoyageDto;
import com.amigo.voyage.VoyageEntity;

public class TypeAdapter {

    public static TypeDTO fromTypeToDto(Type typeDTO){
        return Type.builder()
                .id(typeDTO.getId())
                .nbSuitcase(typeDTO.getNbSuitcase())
                .smoking(typeDTO.getSmoking())
                .build();
    }
    
    public static Type fromDtoToType(TypeDTO type){
        return TypeDTO.builder()
                .id(type.getId())
                .nbSuitcase(type.getNbSuitcase())
                .smoking(type.getSmoking())
                .build();
    }
    
    public static List<TypeDTO> fromProductListToDtoList(List<Type> productEntities){
        List<TypeDTO> productDtoList = new ArrayList<TypeDTO>();
        for(Type productEntity : productEntities){
            productDtoList.add(fromTypeToDto(productEntity));
        }
        return  productDtoList;
    }
}


