package com.amigo.voyage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

/**
 * Created by andrem on 23/03/2017.
 */
@RestController
@RequestMapping("/voyage")
public class VoyageController {
    @Autowired
    private VoyageServiceImpl voyageService;

    @GetMapping("/find/{name}/{brand}/{type}")
    public List<VoyageDto> getProductByOptionalParameters(@PathVariable("name") String name, @PathVariable("brand") String brand, @PathVariable("type") String type) {
        try {
            name = (name.equals("any")) ? null : name;
            brand = (brand.equals("any")) ? null : brand;
            type = (type.equals("any")) ? null : type;
            return voyageService.getSelectedVoyage(name, brand, type);
        }
        catch(Exception e){
            return null;
        }
    }

    @GetMapping
    public List<VoyageDto> getAllProducts() {
        try {
            return voyageService.getAllVoyages();
        }
        catch(Exception e){
            return null;
        }
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public ResponseEntity createProduct(@RequestBody @Valid VoyageDto voyageDto, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            throw new InvalidException();
        }
        try {
            URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{voyage_id}")
                    .buildAndExpand(voyageService.createVoyage(voyageDto)).toUri();
            return ResponseEntity.created(location).body(voyageDto);
        }
        catch(Exception e){
            return new ResponseEntity(HttpStatus.NOT_MODIFIED);
        }
    }
    @PostMapping("/getList")
    @ResponseStatus(OK)
    public ResponseEntity getListVoyage(@RequestBody @Valid Search search, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            throw new InvalidException();
        }
        try {

            return new ResponseEntity(voyageService.getListVoyage(search.getArrive(),search.getDepart(),search.getHeureDep(),search.getDate()),HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity(HttpStatus.NOT_MODIFIED);
        }
    }
    @PostMapping("/getListById")
    @ResponseStatus(OK)
    public ResponseEntity getListVoyageId(@RequestBody   String id, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            throw new InvalidException();
        }
        try {

            return new ResponseEntity(voyageService.getListVoyageByIdUser(id),HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity(HttpStatus.NOT_MODIFIED);
        }
    }
    @PostMapping("/getListByUser")
    @ResponseStatus(OK)
    public ResponseEntity getListVoyage(@RequestBody String idlist, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            throw new InvalidException();
        }
        try {
            return new ResponseEntity(voyageService.getListVoyageById(idlist),HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity(HttpStatus.NOT_MODIFIED);
        }
    }
    @GetMapping("/{voyage_id}")
    public VoyageDto getProductById(@PathVariable("voyage_id") String id){
        try {
            return voyageService.getVoyageById(id);
        }
        catch(Exception e){
            return null;
        }
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteProduct(@PathVariable("id") String id){
        try {
            return new ResponseEntity(voyageService.deleteVoyage(id), HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping()
    public ResponseEntity updateProduct(@RequestBody @Valid VoyageDto voyageDto, BindingResult bindingResult){
        try {
            if (bindingResult.hasErrors()) {
                throw new InvalidException();
            }
            return new ResponseEntity(voyageService.updateVoyage(voyageDto), HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity(HttpStatus.NOT_MODIFIED);
        }
    }
    @PutMapping("/reduce")
    public ResponseEntity reducePlace(@RequestBody  String id, BindingResult bindingResult){
        try {
            if (bindingResult.hasErrors()) {
                throw new InvalidException();
            }
            VoyageDto voyageDto=voyageService.getVoyageById(id);
            voyageDto.setNbplace(voyageDto.getNbplace()-1);
            return new ResponseEntity(voyageService.updateVoyage(voyageDto), HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity(HttpStatus.NOT_MODIFIED);
        }
    }
}
