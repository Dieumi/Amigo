package com.amigo.typeVoyage.type;

import java.util.ArrayList;
import java.util.List;

public class TypeVoyageAdapter {

    public static TypeVoyageDTO fromTypeToDto(TypeVoyage typeDTO){
        return TypeVoyageDTO.builder()
                .id(typeDTO.getId())
                .idvoyage(typeDTO.getIdvoyage())
                .build();
    }

    public static TypeVoyage fromDtoToType(TypeVoyageDTO type){
        return TypeVoyage.builder()
                .id(type.getId())
                .idvoyage(type.getIdvoyage())

                .build();
    }

    public static List<TypeVoyageDTO> fromProductListToDtoList(List<TypeVoyage> productEntities){
        List<TypeVoyageDTO> productDtoList = new ArrayList<TypeVoyageDTO>();
        for(TypeVoyage productEntity : productEntities){
            productDtoList.add(fromTypeToDto(productEntity));
        }
        return  productDtoList;
    }
}


