package com.amigo.uservoyage;

import lombok.*;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;

/**
 * Created by andrem on 23/03/2017.
 */
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Component
public class UserVoyageDto {
    private String id;
    @NotNull
    private String idVoyage;
    @NotNull
    private String idUser;

    private double note;

    public UserVoyageDto(String idUser, int nbplace, String depart, String arrive, String typeVoiture){
       /* this.name = name;
        this.brand = brand;
        this.typeId = typeId;
        this.price = price;
        this.imageURL = imageURL;*/
    }
}
