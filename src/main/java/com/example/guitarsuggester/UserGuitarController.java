package com.example.guitarsuggester;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class UserGuitarController {

    @Autowired
    UserGuitarRepository userGuitarRepository;

    @Autowired
    UserGuitarService userGuitarService;

    @GetMapping("/user-guitars")
    public ResponseEntity<List<UserGuitar>> getAllUserGuitars() {
        List<UserGuitar> allGuitars = userGuitarService.getAllUserGuitars();
        return ResponseEntity.status(HttpStatus.OK).body(allGuitars);
    }

    @GetMapping("/user-guitars/{userKey}")
    public ResponseEntity<List<UserGuitar>> getUserGuitarsByKey(@PathVariable String userKey) {
        List<UserGuitar> userGuitars = userGuitarService.getUserGuitarsByKey(userKey);
        return ResponseEntity.status(HttpStatus.OK).body(userGuitars);
    }

    @PostMapping("/new-user-guitar")
    public ResponseEntity<String> createUserGuitarAndUser(@RequestBody NewUserGuitar newUserGuitar) {
        UserGuitar userGuitar = new UserGuitar(newUserGuitar.getGuitarName(), newUserGuitar.getGuitarPrice(), newUserGuitar.getGuitarPicUrl(), newUserGuitar.getGuitarDescription());

        boolean isCreated = userGuitarService.createUserGuitarAndUser(userGuitar);

        if (isCreated) {
            return ResponseEntity.status(HttpStatus.OK).body("Created Successfully");
        }

        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Please enter all of the guitars details");
    }

    @PostMapping("/user-guitar")
    public ResponseEntity<String> createUserGuitar(@RequestBody UserGuitar userGuitar) {
        boolean isCreated = userGuitarService.createUserGuitar(userGuitar);

        if (isCreated) {
            return ResponseEntity.status(HttpStatus.OK).body("Created Successfully");
        }

        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Please enter all of the guitars details");
    }

    @DeleteMapping("user-guitar/{id}")
    public ResponseEntity deleteUserGuitarById(@PathVariable String id) {
        boolean isDeleted = userGuitarService.deleteUserGuitarById(id);

        if(isDeleted) {
            return ResponseEntity.status(HttpStatus.OK).body("Guitar deleted successfully");
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No guitar with this id");
    }

    @PostMapping("user-guitar/{id}")
    public ResponseEntity updateUserGuitar(@RequestBody UserGuitar newGuitarDetails, @PathVariable String id) {
        boolean isUpdated = userGuitarService.updateUserGuitarById(id, newGuitarDetails);

        if(isUpdated) {
            return ResponseEntity.status(HttpStatus.OK).body("Guitar updated successfully");
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No guitar with this id");
    }

}


