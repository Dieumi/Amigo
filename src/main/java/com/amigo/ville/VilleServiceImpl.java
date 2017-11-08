package com.amigo.ville;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by andrem on 05/04/2017.
 */
@Service
public class VilleServiceImpl implements VilleService {
    @Autowired
    VilleRepository villeRepository;
    @Override
    public List<VilleDto> getAllVille(){
        return VilleAdapter.fromProductListToDtoList(villeRepository.findAll());
    }
    @Override
    public List<VilleDto> getSelectedVille(String name, String brand, String typeId){
        return VilleAdapter.fromProductListToDtoList(villeRepository.findByOptionalParameters(name, brand, typeId));
    }
    @Override
    public VilleDto createVille(VilleDto villeDto){
        villeRepository.save(VilleAdapter.fromDtoToVoyage(villeDto));
        return villeDto;
    }
    @Override
    public VilleDto deleteVille(String id){
        VilleEntity productToDelete = villeRepository.findById(id);
        villeRepository.delete(productToDelete);
        return VilleAdapter.fromVoyagetToDto(productToDelete);
    }
    @Override
    public VilleDto updateVille(VilleDto productDto){
        villeRepository.save(VilleAdapter.fromDtoToVoyage(productDto));
        return productDto;
    }
    @Override
    public VilleDto getVilleById(String id){
        VilleEntity productToRetrieve = villeRepository.findById(id);
        return VilleAdapter.fromVoyagetToDto(productToRetrieve);
    }

}
