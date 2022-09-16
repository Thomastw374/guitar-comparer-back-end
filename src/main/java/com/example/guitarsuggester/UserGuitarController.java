package com.example.guitarsuggester;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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


}
