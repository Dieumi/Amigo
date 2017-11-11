package com.amigo.voyage;

import com.amigo.auth.AuthDto;
import com.amigo.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by andrem on 05/04/2017.
 */
@Service
public class VoyageServiceImpl implements VoyageService {
    @Autowired
    VoyageRepository voyageRepository;
    @Override
    public List<VoyageDto> getAllVoyages(){
        return VoyageAdapter.fromProductListToDtoList(voyageRepository.findAll());
    }
    @Override
    public List<VoyageDto> getSelectedVoyage(String name, String brand, String typeId){
        return VoyageAdapter.fromProductListToDtoList(voyageRepository.findByOptionalParameters(name, brand, typeId));
    }
    @Override
    public VoyageDto createVoyage(VoyageDto productDto){
    VoyageEntity v= voyageRepository.save(VoyageAdapter.fromDtoToVoyage(productDto));
        productDto.setId(v.getId());
        return productDto;
    }
    @Override
    public VoyageDto deleteVoyage(String id){
        VoyageEntity productToDelete = voyageRepository.findById(id);
        voyageRepository.delete(productToDelete);
        return VoyageAdapter.fromVoyagetToDto(productToDelete);
    }
    @Override
    public VoyageDto updateVoyage(VoyageDto productDto){
        voyageRepository.save(VoyageAdapter.fromDtoToVoyage(productDto));
        return productDto;
    }
    @Override
    public VoyageDto getVoyageById(String id){
        VoyageEntity productToRetrieve = voyageRepository.findById(id);
        return VoyageAdapter.fromVoyagetToDto(productToRetrieve);
    }

    @Override
    public List<VoyageDto> getListVoyage(String arrive, String depart, String heure, String date) {
        if(heure!=null){
            return VoyageAdapter.fromProductListToDtoList(voyageRepository.findByArriveAndDepartAndDateGreaterThanEqualAndHeureDepGreaterThanEqualAndNbplaceGreaterThan(arrive,depart,date,heure,0));
        }
        return VoyageAdapter.fromProductListToDtoList(voyageRepository.findByArriveAndDepartAndDateGreaterThanEqualAndNbplaceGreaterThan(arrive,depart,date,0));
    }



    @Override
    public List<VoyageDto> getListVoyageById(String idlist) {
        List<VoyageDto> list = new ArrayList<VoyageDto>();
        String[] idlista;
        idlist=idlist.replace("[\"","");
        idlist=idlist.replace("\"]","");
        idlista=idlist.split("\",\"");
        String today=new SimpleDateFormat("MM/dd/yyyy").format(new Date());
        for(int i=0;i<idlista.length;i++){
            VoyageEntity v=voyageRepository.findByIdAndDateBefore(idlista[i],today);
            if(v!=null){
                list.add(VoyageAdapter.fromVoyagetToDto(v));
            }

        }
        return list;
    }


}
