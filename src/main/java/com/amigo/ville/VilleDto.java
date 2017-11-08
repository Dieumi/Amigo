package com.amigo.ville;

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
public class VilleDto {

    private String id;
    @NotNull
    private String name;
    @NotNull
    private String region;
    public VilleDto(String idUser, int nbplace, String depart, String arrive, String typeVoiture){
       /* this.name = name;
        this.brand = brand;
        this.typeId = typeId;
        this.price = price;
        this.imageURL = imageURL;*/
    }
}
