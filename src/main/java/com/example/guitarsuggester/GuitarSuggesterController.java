package com.example.guitarsuggester;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class GuitarSuggesterController {

//    @Autowired
//    GuitarSuggesterRepository guitarSuggesterRepository;

    @Autowired
    GuitarSuggesterService guitarSuggesterService;

    @GetMapping("/guitars")
    public ResponseEntity<List<Guitar>> getAllGuitars() {
        List<Guitar> allGuitars = guitarSuggesterService.getAllGuitars();
        return ResponseEntity.status(HttpStatus.OK).body(allGuitars);
    }

    @PostMapping("guitar")
    public ResponseEntity createGuitar(@RequestBody Guitar guitar) {
        boolean isCreated = guitarSuggesterService.createGuitar(guitar);

        if (isCreated) {
            return ResponseEntity.status(HttpStatus.OK).body(null);
        }

        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Please enter the guitars details");
    }



}
