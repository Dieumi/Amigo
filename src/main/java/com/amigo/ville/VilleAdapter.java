package com.amigo.ville;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by andrem on 23/03/2017.
 */
public class VilleAdapter {

    public static VilleDto fromVoyagetToDto(VilleEntity ville){
        return VilleDto.builder()
                .id(ville.getId())
                .name(ville.getName())
                .region(ville.getRegion())
                .build();
    }

    public static VilleEntity fromDtoToVoyage(VilleDto villeDto){
        return VilleEntity.builder()
                .id(villeDto.getId())
                .name(villeDto.getName())
                .region(villeDto.getRegion())
                .build();
    }

    public static List<VilleDto> fromProductListToDtoList(List<VilleEntity> villeEntities){
        List<VilleDto> userVilleDtoList = new ArrayList<VilleDto>();
        for(VilleEntity villeEntitie : villeEntities){
            userVilleDtoList.add(fromVoyagetToDto(villeEntitie));
        }
        return  userVilleDtoList;
    }
}
