package com.example.guitarsuggester;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.lang.Integer.parseInt;

@Service
public class GuitarSuggesterService {

    @Autowired
    GuitarSuggesterRepository guitarSuggesterRepository;

    public List<Guitar> getAllGuitars() { return guitarSuggesterRepository.findAll();}

    public Guitar getGuitarById(String id) { return guitarSuggesterRepository.findById(parseInt(id)).orElse(null);}

    public boolean createGuitar(Guitar guitar) {
        if (guitar.getGuitarName() == null) {
            return false;
        }
        guitarSuggesterRepository.save(guitar);
        return true;
    }

    public boolean deleteById(String id) {
        Guitar guitarToDelete = guitarSuggesterRepository.findById(parseInt(id)).orElse(null);

        if (guitarToDelete == null) {
            return false;
        }

        guitarSuggesterRepository.delete(guitarToDelete);
        return true;

    }

    }

