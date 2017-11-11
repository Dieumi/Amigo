package com.amigo.uservoyage;

import com.amigo.user.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by andrem on 23/03/2017.
 */
public class UserVoyageAdapter {

    public static UserVoyageDto fromVoyagetToDto(UserVoyageEntity Uservoyage){
        return UserVoyageDto.builder()
                .id(Uservoyage.getId())
                .idVoyage(Uservoyage.getIdVoyage())
                .idUser(Uservoyage.getIdUser())
                .note(Uservoyage.getNote())
                .build();
    }

    public static UserVoyageEntity fromDtoToVoyage(UserVoyageDto UservoyageDto){
        return UserVoyageEntity.builder()
                .id(UservoyageDto.getId())
                .idVoyage(UservoyageDto.getIdVoyage())
                .idUser(UservoyageDto.getIdUser())
                .note(UservoyageDto.getNote())
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
