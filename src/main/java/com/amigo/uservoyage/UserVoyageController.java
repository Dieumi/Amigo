package com.amigo.uservoyage;

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
@RequestMapping("/product")
public class UserVoyageController {
    @Autowired
    private UserVoyageServiceImpl userVoyageService;

    @GetMapping("/find/{name}/{brand}/{type}")
    public List<UserVoyageDto> getProductByOptionalParameters(@PathVariable("name") String name, @PathVariable("brand") String brand, @PathVariable("type") String type) {
        try {
            name = (name.equals("any")) ? null : name;
            brand = (brand.equals("any")) ? null : brand;
            type = (type.equals("any")) ? null : type;
            return userVoyageService.getSelectedUserVoyage(name, brand, type);
        }
        catch(Exception e){
            return null;
        }
    }

    @GetMapping
    public List<UserVoyageDto> getAllUserVoyage() {
        try {
            return userVoyageService.getAllUserVoyages();
        }
        catch(Exception e){
            return null;
        }
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public ResponseEntity createProduct(@RequestBody @Valid UserVoyageDto UservoyageDto, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            throw new InvalidException();
        }
        try {
            URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{voyage_id}")
                    .buildAndExpand(userVoyageService.createUserVoyage(UservoyageDto)).toUri();
            return ResponseEntity.created(location).body(UservoyageDto);
        }
        catch(Exception e){
            return new ResponseEntity(HttpStatus.NOT_MODIFIED);
        }
    }
    @GetMapping("/{Uservoyage_id}")
    public UserVoyageDto getProductById(@PathVariable("Uservoyage_id") String id){
        try {
            return userVoyageService.getUserVoyageById(id);
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
            return new ResponseEntity(userVoyageService.deleteUserVoyage(id), HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping()
    public ResponseEntity updateProduct(@RequestBody @Valid UserVoyageDto UservoyageDto, BindingResult bindingResult){
        try {
            if (bindingResult.hasErrors()) {
                throw new InvalidException();
            }
            return new ResponseEntity(userVoyageService.updateUserVoyage(UservoyageDto), HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity(HttpStatus.NOT_MODIFIED);
        }
    }
}
