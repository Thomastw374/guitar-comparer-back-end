package com.example.guitarsuggester;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuitarSuggesterService {

    @Autowired
    GuitarSuggesterRepository guitarSuggesterRepository;

    public List<Guitar> getAllGuitars() { return guitarSuggesterRepository.findAll();}

    public boolean createGuitar(Guitar guitar) {
        if (guitar.getGuitarName() == null) {
            return false;
        }
        guitarSuggesterRepository.save(guitar);
        return true;
    }

    }

