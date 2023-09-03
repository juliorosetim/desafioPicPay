package com.example.picpay.Controller.Users;

import com.example.picpay.Entity.Users.UsersEntity;
import com.example.picpay.Services.Users.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    UsersService usersService;
    @GetMapping
    public ResponseEntity<?> getAllUsers() throws Exception {
        List<UsersEntity> allUsers = usersService.getAllUsers();
        return ResponseEntity.status(HttpStatus.OK).body(allUsers);
    }

    @PostMapping
    public ResponseEntity<UsersEntity> saveUser(@RequestBody UsersEntity usersEntity) throws Exception {
        UsersEntity userSave = usersService.saveUsers(usersEntity);
        return ResponseEntity.status( HttpStatus.CREATED).body(userSave);
    }
}
