package com.amigo.voyage;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by andrem on 23/03/2017.
 */
public class VoyageAdapter {

    public static VoyageDto fromVoyagetToDto(VoyageEntity voyage){
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        return VoyageDto.builder()
                .id(voyage.getId())
                .arrive(voyage.getArrive())
                .depart(voyage.getDepart())
                .idUser(voyage.getIdUser())
                .nbplace(voyage.getNbplace())
                .price(voyage.getPrice())
                .typeVoiture(voyage.getTypeVoiture())
                .note(voyage.getNote())
                .date(voyage.getDate())
                .heureDep(voyage.getHeureDep())
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
                .note(voyageDto.getNote())
                .date(voyageDto.getDate())
                .heureDep(voyageDto.getHeureDep())
                .build();
    }
    public static  Date ConvertToDate(String date){
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        Date truedate=null;
        try {
             truedate= formatter.parse(date);

        } catch (ParseException e) {
            e.printStackTrace();

        }
        return truedate;
    }
    public static List<VoyageDto> fromProductListToDtoList(List<VoyageEntity> voyageEntities){
        List<VoyageDto> userVoyageDtoList = new ArrayList<VoyageDto>();
        for(VoyageEntity voyageEntitie : voyageEntities){
            userVoyageDtoList.add(fromVoyagetToDto(voyageEntitie));
        }
        return  userVoyageDtoList;
    }
}
