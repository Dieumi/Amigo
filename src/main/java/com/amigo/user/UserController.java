package com.amigo.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by Pierre on 02/03/2017.
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserServiceImpl userService;

    @GetMapping()
    public List<UserDTO> getAccountList()
    {

        return userService.getList();
    }

    @GetMapping("/{login}")
    public ResponseEntity getUserByLogin(@PathVariable("login") String login)
    {
        return new ResponseEntity(userService.getUserByLogin(login),HttpStatus.OK);
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    class BadRequestException extends RuntimeException{

    }
    @PostMapping()
    public ResponseEntity createAccount(@RequestBody @Valid UserDTO accountEntity, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            System.out.println(bindingResult.getErrorCount());
            System.out.println(bindingResult.getAllErrors().get(0));
            System.out.println(bindingResult.getAllErrors().get(1));
            throw new BadRequestException();

        }
      return  new ResponseEntity(userService.createAccount(accountEntity),HttpStatus.CREATED);
    }

    @DeleteMapping()
    public ResponseEntity deleteAccount(@RequestBody  String id){
        return new ResponseEntity(userService.deleteAccount(id),HttpStatus.OK);
    }

    @PutMapping()
    public ResponseEntity updateAccount(@RequestBody @Valid UserDTO userDTO,  BindingResult bindingResult){
        return new ResponseEntity(userService.updateAccount(userDTO),HttpStatus.OK);
    }
    @PutMapping("/pay")
    public ResponseEntity updateAccount(@RequestBody @Valid Res res , BindingResult bindingResult){

        UserDTO user=userService.getUserById(res.getIdUser());
        if(user.getCredit()-res.getPrice()<0){
            return new ResponseEntity("Pas assez de bif",HttpStatus.OK);
        }else{
            user.setCredit(user.getCredit()-res.getPrice());
            return new ResponseEntity(userService.updateAccount(user),HttpStatus.OK);
        }

    }

}
