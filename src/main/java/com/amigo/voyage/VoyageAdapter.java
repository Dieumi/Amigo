package com.amigo.voyage;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by andrem on 23/03/2017.
 */
public class VoyageAdapter {

    public static VoyageDto fromVoyagetToDto(VoyageEntity voyage){
        return VoyageDto.builder()
                .id(voyage.getId())
                .arrive(voyage.getArrive())
                .depart(voyage.getDepart())
                .idUser(voyage.getIdUser())
                .nbplace(voyage.getNbplace())
                .price(voyage.getPrice())
                .typeVoiture(voyage.getTypeVoiture())
                .build();
    }

    public static VoyageEntity fromDtoToVoyage(VoyageDto voyageDto){
        return VoyageEntity.builder()
                .id(voyageDto.getId())
                .arrive(voyageDto.getArrive())
                .depart(voyageDto.getDepart())
                .idUser(voyageDto.getIdUser())
                .price(voyageDto.getPrice())
                .nbplace(voyageDto.getNbplace())
                .typeVoiture(voyageDto.getTypeVoiture())
                .build();
    }

    public static List<VoyageDto> fromProductListToDtoList(List<VoyageEntity> voyageEntities){
        List<VoyageDto> userVoyageDtoList = new ArrayList<VoyageDto>();
        for(VoyageEntity voyageEntitie : voyageEntities){
            userVoyageDtoList.add(fromVoyagetToDto(voyageEntitie));
        }
        return  userVoyageDtoList;
    }
}
