package com.amigo.type;

import java.util.ArrayList;
import java.util.List;

import com.amigo.user.User;
import com.amigo.user.UserDTO;
import com.amigo.voyage.VoyageDto;
import com.amigo.voyage.VoyageEntity;

public class TypeAdapter {

    public static TypeDTO fromTypeToDto(Type typeDTO){
        return TypeDTO.builder()
                .id(typeDTO.getId())
                .value(typeDTO.getValue())
                .build();
    }
    
    public static Type fromDtoToType(TypeDTO type){
        return Type.builder()
                .id(type.getId())
                .value(type.getValue())
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


