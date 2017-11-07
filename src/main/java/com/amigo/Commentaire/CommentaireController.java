package com.amigo.Commentaire;

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
@RequestMapping("/commentaire")
public class CommentaireController {
    @Autowired
    private CommentaireServiceImpl commentaireService;

    @GetMapping("/find/{name}/{brand}/{type}")
    public List<CommentaireDto> getProductByOptionalParameters(@PathVariable("name") String name, @PathVariable("brand") String brand, @PathVariable("type") String type) {
        try {
            name = (name.equals("any")) ? null : name;
            brand = (brand.equals("any")) ? null : brand;
            type = (type.equals("any")) ? null : type;
            return commentaireService.getSelectedCommentaire(name, brand, type);
        }
        catch(Exception e){
            return null;
        }
    }

    @GetMapping
    public List<CommentaireDto> getAllProducts() {
        try {
            return commentaireService.getAllCommentaire();
        }
        catch(Exception e){
            return null;
        }
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public ResponseEntity createProduct(@RequestBody @Valid CommentaireDto commentaireDto, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            throw new InvalidException();
        }
        try {
            URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{voyage_id}")
                    .buildAndExpand(commentaireService.createCommentaire(commentaireDto)).toUri();
            return ResponseEntity.created(location).body(commentaireDto);
        }
        catch(Exception e){
            return new ResponseEntity(HttpStatus.NOT_MODIFIED);
        }
    }
    @GetMapping("/{voyage_id}")
    public CommentaireDto getProductById(@PathVariable("voyage_id") String id){
        try {
            return commentaireService.getCommentaireById(id);
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
            return new ResponseEntity(commentaireService.deleteCommentaire(id), HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping()
    public ResponseEntity updateProduct(@RequestBody @Valid CommentaireDto commentaireDto, BindingResult bindingResult){
        try {
            if (bindingResult.hasErrors()) {
                throw new InvalidException();
            }
            return new ResponseEntity(commentaireService.updateCommentaire(commentaireDto), HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity(HttpStatus.NOT_MODIFIED);
        }
    }
}
