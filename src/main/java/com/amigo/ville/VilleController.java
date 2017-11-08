package com.amigo.ville;

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

/**
 * Created by andrem on 23/03/2017.
 */
@RestController
@RequestMapping("/ville")
public class VilleController {
    @Autowired
    private VilleServiceImpl villeService;

    @GetMapping("/find/{name}/{brand}/{type}")
    public List<VilleDto> getProductByOptionalParameters(@PathVariable("name") String name, @PathVariable("brand") String brand, @PathVariable("type") String type) {
        try {
            name = (name.equals("any")) ? null : name;
            brand = (brand.equals("any")) ? null : brand;
            type = (type.equals("any")) ? null : type;
            return villeService.getSelectedVille(name, brand, type);
        }
        catch(Exception e){
            return null;
        }
    }

    @GetMapping
    public List<VilleDto> getAllProducts() {
        try {
            return villeService.getAllVille();
        }
        catch(Exception e){
            return null;
        }
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public ResponseEntity createProduct(@RequestBody @Valid VilleDto villeDto, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            throw new InvalidException();
        }
        try {
            URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{voyage_id}")
                    .buildAndExpand(villeService.createVille(villeDto)).toUri();
            return ResponseEntity.created(location).body(villeDto);
        }
        catch(Exception e){
            return new ResponseEntity(HttpStatus.NOT_MODIFIED);
        }
    }
    @GetMapping("/{ville_id}")
    public VilleDto getProductById(@PathVariable("ville_id") String id){
        try {
            return villeService.getVilleById(id);
        }
        catch(Exception e){
            return null;
        }
    }
    @DeleteMapping()
    public ResponseEntity deleteProduct(@RequestBody String id, BindingResult bindingResult){
        try {
            if (bindingResult.hasErrors()) {
                throw new InvalidException();
            }
            return new ResponseEntity(villeService.deleteVille(id), HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping()
    public ResponseEntity updateProduct(@RequestBody @Valid VilleDto villeDto, BindingResult bindingResult){
        try {
            if (bindingResult.hasErrors()) {
                throw new InvalidException();
            }
            return new ResponseEntity(villeService.updateVille(villeDto), HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity(HttpStatus.NOT_MODIFIED);
        }
    }
}
