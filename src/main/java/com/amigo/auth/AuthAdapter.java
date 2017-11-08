package com.amigo.auth;



import org.apache.http.auth.AUTH;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by iPlowplow on 10/03/2017.
 */
public class AuthAdapter {


    public static AuthEntity toAuthEntity(AuthDto authDto){
        return AuthEntity.builder()
                .id(authDto.getId())
                .login(authDto.getLogin())
                .pwd(authDto.getPwd())
                .build();
    }

   public static AuthDto toAuthDto(AuthEntity authEntity){
        return AuthDto.builder()
                .id(authEntity.getId())
                .login(authEntity.getLogin())
                .pwd(authEntity.getPwd())
                .build();
   }
    public static List<AuthDto> fromAuthListToDtoList(List<AuthEntity> AuthEntities){
        List<AuthDto> CommentaireDtoList = new ArrayList<AuthDto>();
        for(AuthEntity authEntitie : AuthEntities){
            CommentaireDtoList.add(toAuthDto(authEntitie));
        }
        return  CommentaireDtoList;
    }
}
