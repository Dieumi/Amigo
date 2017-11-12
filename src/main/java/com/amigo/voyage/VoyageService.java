package com.amigo.voyage;

import com.amigo.typeVoyage.TypeVoyageDTO;

import java.util.List;

/**
 * Created by andrem on 05/04/2017.
 */
public interface VoyageService {
    public List<VoyageDto> getAllVoyages();
    public List<VoyageDto> getSelectedVoyage(String name, String brand, String typeId);

    public VoyageDto createVoyage(VoyageDto productDto);

    public VoyageDto deleteVoyage(String id);
    public VoyageDto updateVoyage(VoyageDto productDto);

    public VoyageDto getVoyageById(String id);
    public List<VoyageDto> getListVoyage(String arrive,String depart,String heure,String date);
    public List<VoyageDto> getListVoyageById(String idlist);
    public List<VoyageDto> getListVoyageByIdUser(String id);

}
