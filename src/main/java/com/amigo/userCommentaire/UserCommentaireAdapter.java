package com.amigo.userCommentaire;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by andrem on 23/03/2017.
 */
public class UserCommentaireAdapter {

    public static UserCommentaireDto fromVoyagetToDto(UserCommentaireEntity UserCommentaire){
        return UserCommentaireDto.builder()
                .id(UserCommentaire.getId())
                .idUser(UserCommentaire.getIdUser())
                .idReceiver(UserCommentaire.getIdReceiver())
                .build();
    }

    public static UserCommentaireEntity fromDtoToVoyage(UserCommentaireDto UserCommentaireDto){
        return UserCommentaireEntity.builder()
                .id(UserCommentaireDto.getId())
                .idUser(UserCommentaireDto.getIdUser())
                .idReceiver(UserCommentaireDto.getIdReceiver())
                .build();
    }

    public static List<UserCommentaireDto> fromProductListToDtoList(List<UserCommentaireEntity> UserCommentaireEntities){
        List<UserCommentaireDto> UserCommentaireDtoList = new ArrayList<UserCommentaireDto>();
        for(UserCommentaireEntity UserCommentaireEntitie : UserCommentaireEntities){
            UserCommentaireDtoList.add(fromVoyagetToDto(UserCommentaireEntitie));
        }
        return  UserCommentaireDtoList;
    }
}
