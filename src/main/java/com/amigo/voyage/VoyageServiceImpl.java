package com.amigo.voyage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by andrem on 05/04/2017.
 */
@Service
public class VoyageServiceImpl implements VoyageService {
    @Autowired
    VoyageRepository productRepository;
    @Override
    public List<VoyageDto> getAllVoyages(){
        return VoyageAdapter.fromProductListToDtoList(productRepository.findAll());
    }
    @Override
    public List<VoyageDto> getSelectedVoyage(String name, String brand, String typeId){
        return VoyageAdapter.fromProductListToDtoList(productRepository.findByOptionalParameters(name, brand, typeId));
    }
    @Override
    public VoyageDto createVoyage(VoyageDto productDto){
        productRepository.save(VoyageAdapter.fromDtoToVoyage(productDto));
        return productDto;
    }
    @Override
    public VoyageDto deleteVoyage(String id){
        VoyageEntity productToDelete = productRepository.findById(id);
        productRepository.delete(productToDelete);
        return VoyageAdapter.fromVoyagetToDto(productToDelete);
    }
    @Override
    public VoyageDto updateVoyage(VoyageDto productDto){
        productRepository.save(VoyageAdapter.fromDtoToVoyage(productDto));
        return productDto;
    }
    @Override
    public VoyageDto getVoyageById(String id){
        VoyageEntity productToRetrieve = productRepository.findById(id);
        return VoyageAdapter.fromVoyagetToDto(productToRetrieve);
    }

}
