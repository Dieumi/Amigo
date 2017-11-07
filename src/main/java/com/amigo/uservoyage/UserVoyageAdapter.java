package com.amigo.uservoyage;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by andrem on 23/03/2017.
 */
public class UserVoyageAdapter {

    public static UserVoyageDto fromVoyagetToDto(UserVoyageEntity Uservoyage){
        return UserVoyageDto.builder()
                .idVoyage(Uservoyage.getIdVoyage())
                .idUser(Uservoyage.getIdUser())
                .build();
    }

    public static UserVoyageEntity fromDtoToVoyage(UserVoyageDto UservoyageDto){
        return UserVoyageEntity.builder()
                .idVoyage(UservoyageDto.getIdVoyage())
                .idUser(UservoyageDto.getIdUser())
                .build();
    }

    public static List<UserVoyageDto> fromProductListToDtoList(List<UserVoyageEntity> userVoyageEntities){
        List<UserVoyageDto> userVoyageDtoList = new ArrayList<UserVoyageDto>();
        for(UserVoyageEntity userVoyageEntity : userVoyageEntities){
            userVoyageDtoList.add(fromVoyagetToDto(userVoyageEntity));
        }
        return  userVoyageDtoList;
    }
}
