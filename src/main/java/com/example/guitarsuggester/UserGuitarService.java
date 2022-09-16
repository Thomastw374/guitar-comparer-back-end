package com.example.guitarsuggester;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserGuitarService {

    @Autowired
    UserGuitarRepository userGuitarRepository;

    public List<UserGuitar> getAllUserGuitars() { return userGuitarRepository.findAll();}
}
