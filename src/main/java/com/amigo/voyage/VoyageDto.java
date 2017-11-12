package com.amigo.voyage;

import lombok.*;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by andrem on 23/03/2017.
 */
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Component
public class VoyageDto {

    private String id;
    @NotNull
    private String idUser;
    @NotNull
    private int nbplace;
    @NotNull
    private String depart;
    @NotNull
    private String arrive;
    @NotNull
    private String typeVoiture;
    @NotNull
    private double price;
    @NotNull
    private String date;
    @NotNull
    private String note;
    @NotNull
    private String heureDep;
    public VoyageDto(String idUser, int nbplace, String depart, String arrive, String typeVoiture){
       /* this.name = name;
        this.brand = brand;
        this.typeId = typeId;
        this.price = price;
        this.imageURL = imageURL;*/
    }
}
