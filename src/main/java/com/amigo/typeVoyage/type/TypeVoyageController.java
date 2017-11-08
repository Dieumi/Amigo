package com.amigo.typeVoyage.type;

import com.amigo.voyage.InvalidException;
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

@RestController
@RequestMapping("/typeVoyage")
public class TypeVoyageController {

	@Autowired
    private TypeVoyageServiceImpl typeService;

    @GetMapping("/find/{name}/{brand}/{type}")
    public List<TypeVoyageDTO> getProductByOptionalParameters(@PathVariable("name") String name, @PathVariable("brand") String brand, @PathVariable("type") String type) {
        try {
            name = (name.equals("any")) ? null : name;
            brand = (brand.equals("any")) ? null : brand;
            type = (type.equals("any")) ? null : type;
            return typeService.getListType(); ///// ERROOOOORR
        }
        catch(Exception e){
            return null;
        }
    }

    @GetMapping
    public List<TypeVoyageDTO> getAllProducts() {
        try {
            return typeService.getListType();
        }
        catch(Exception e){
            return null;
        }
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public ResponseEntity createProduct(@RequestBody @Valid TypeVoyageDTO typeDto, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            throw new InvalidException();
        }
        try {
            URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{type_id}")
                    .buildAndExpand(typeService.createType(typeDto)).toUri();
            return ResponseEntity.created(location).body(typeDto);
        }
        catch(Exception e){
            return new ResponseEntity(HttpStatus.NOT_MODIFIED);
        }
    }
    @GetMapping("/{type_id}")
    public TypeVoyageDTO getProductById(@PathVariable("type_id") String id){
        try {
            return typeService.getTypeById(id);
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
            return new ResponseEntity(typeService.deleteType(id), HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping()
    public ResponseEntity updateProduct(@RequestBody @Valid TypeVoyageDTO typeDto, BindingResult bindingResult){
        try {
            if (bindingResult.hasErrors()) {
                throw new InvalidException();
            }
            return new ResponseEntity(typeService.updateType(typeDto), HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity(HttpStatus.NOT_MODIFIED);
        }
    }
}
