package com.example.guitarsuggester;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.lang.Integer.parseInt;

@CrossOrigin
@RestController
public class GuitarSuggesterController {

    @Autowired
    GuitarSuggesterRepository guitarSuggesterRepository;

    @Autowired
    UserGuitarRepository userGuitarRepository;

    @Autowired
    GuitarSuggesterService guitarSuggesterService;

    @GetMapping("/guitars")
    public ResponseEntity<List<Guitar>> getAllGuitars() {
        List<Guitar> allGuitars = guitarSuggesterService.getAllGuitars();
        return ResponseEntity.status(HttpStatus.OK).body(allGuitars);
    }

    @GetMapping("/user-guitars")
    public ResponseEntity<List<UserGuitar>> getAllUserGuitars() {
        List<UserGuitar> allGuitars = userGuitarRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(allGuitars);
    }

    @GetMapping("/guitar/{id}")
    public ResponseEntity<Guitar> getGuitarById(@PathVariable String id) {
        Guitar guitar = guitarSuggesterService.getGuitarById(id);
        return ResponseEntity.status(HttpStatus.OK).body(guitar);
    }

    @GetMapping("/guitars/by-price/asc")
    public ResponseEntity<List<Guitar>> getGuitarsByPriceAsc() {
        List<Guitar> priceSortedGuitars = guitarSuggesterRepository.findAllSortedByPriceAsc();
        return ResponseEntity.status(HttpStatus.OK).body(priceSortedGuitars);
    }

    @GetMapping("/guitars/by-name/asc")
    public ResponseEntity<List<Guitar>> getGuitarsByNameAsc() {
        List<Guitar> nameSortedGuitars = guitarSuggesterRepository.findAllSortedByNameAsc();
        return ResponseEntity.status(HttpStatus.OK).body(nameSortedGuitars);
    }

//    @GetMapping("/guitar/{id}")
//    public ResponseEntity

    @DeleteMapping("/guitar/{id}")
    public ResponseEntity deleteGuitarById(@PathVariable String id) {
        boolean isDeleted = guitarSuggesterService.deleteById(id);

        if(isDeleted) {
            return ResponseEntity.status(HttpStatus.OK).body("Guitar deleted successfully");
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Couldn't find a guitar to delete with that id");
    }

    @PostMapping("/guitar")
    public ResponseEntity createGuitar(@RequestBody Guitar guitar) {
        boolean isCreated = guitarSuggesterService.createGuitar(guitar);

        if (isCreated) {
            return ResponseEntity.status(HttpStatus.OK).body(null);
        }

        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Please enter the guitars details");
    }

    @PutMapping("/guitar/{id}")
    public ResponseEntity updateGuitar(@RequestBody Guitar guitarDetails, @PathVariable String id) {
        Guitar guitar = guitarSuggesterRepository.findById(parseInt(id)).orElse(null);

        guitar.setGuitarName(guitarDetails.getGuitarName());
        guitar.setGuitarPrice(guitarDetails.getGuitarPrice());
        guitar.setGuitarDescription(guitarDetails.getGuitarDescription());
        guitar.setGuitarPicUrl(guitarDetails.getGuitarPicUrl());
        guitarSuggesterRepository.save(guitar);

        if(guitar == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No guitar found with that id");
        }

        return ResponseEntity.status(HttpStatus.OK).body("Guitar details updated");
    }




}
