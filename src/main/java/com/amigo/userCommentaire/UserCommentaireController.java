package com.amigo.userCommentaire;

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
@RequestMapping("/UserCommentaire")
public class UserCommentaireController {
    @Autowired
    private UserCommentaireServiceImpl usercommentaireService;

    @GetMapping("/find/{name}/{brand}/{type}")
    public List<UserCommentaireDto> getProductByOptionalParameters(@PathVariable("name") String name, @PathVariable("brand") String brand, @PathVariable("type") String type) {
        try {
            name = (name.equals("any")) ? null : name;
            brand = (brand.equals("any")) ? null : brand;
            type = (type.equals("any")) ? null : type;
            return usercommentaireService.getSelectedUserCommentaire(name, brand, type);
        }
        catch(Exception e){
            return null;
        }
    }

    @GetMapping
    public List<UserCommentaireDto> getAllUserCommentaire() {
        try {
            return usercommentaireService.getAllUserCommentaire();
        }
        catch(Exception e){
            return null;
        }
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public ResponseEntity createProduct(@RequestBody @Valid UserCommentaireDto commentaireDto, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            throw new InvalidException();
        }
        try {
            URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{voyage_id}")
                    .buildAndExpand(usercommentaireService.createUserCommentaire(commentaireDto)).toUri();
            return ResponseEntity.created(location).body(commentaireDto);
        }
        catch(Exception e){
            return new ResponseEntity(HttpStatus.NOT_MODIFIED);
        }
    }
    @GetMapping("/{voyage_id}")
    public UserCommentaireDto getProductById(@PathVariable("voyage_id") String id){
        try {
            return usercommentaireService.getUserCommentaireById(id);
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
            return new ResponseEntity(usercommentaireService.deleteUserCommentaire(id), HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping()
    public ResponseEntity updateProduct(@RequestBody @Valid UserCommentaireDto commentaireDto, BindingResult bindingResult){
        try {
            if (bindingResult.hasErrors()) {
                throw new InvalidException();
            }
            return new ResponseEntity(usercommentaireService.updateUserCommentaire(commentaireDto), HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity(HttpStatus.NOT_MODIFIED);
        }
    }
}
