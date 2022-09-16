package com.example.guitarsuggester;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserGuitarService {

    @Autowired
    UserGuitarRepository userGuitarRepository;

    public List<UserGuitar> getAllUserGuitars() { return userGuitarRepository.findAll();}

    public boolean createUserGuitarAndUser(UserGuitar guitar) {
        if(guitar.getGuitarName() == null || guitar.getGuitarPrice() == null || guitar.getGuitarPicUrl() == null || guitar.getGuitarDescription() == null) {
            return false;
        }

        userGuitarRepository.save(guitar);
        return true;
    }

    public boolean createUserGuitar(UserGuitar guitar) {
        if(guitar.getGuitarName() == null || guitar.getGuitarPrice() == null || guitar.getGuitarPicUrl() == null || guitar.getGuitarDescription() == null || guitar.getUserKey() == null) {
            return false;
        }

        userGuitarRepository.save(guitar);
        return true;
    }

    public List<UserGuitar> getUserGuitarsByKey(String userKey) {
        List<UserGuitar> userGuitars = userGuitarRepository.findUserGuitarsByUserKey(userKey);

        return userGuitars;
    }

    public boolean deleteUserGuitarById(String id) {
        UserGuitar guitarToDelete = userGuitarRepository.findById(Integer.parseInt(id)).orElse(null);
        if (guitarToDelete == null) {
            return false;
        }

        userGuitarRepository.delete(guitarToDelete);
        return true;
    }

    public boolean updateUserGuitarById(String id, UserGuitar newGuitarDetails) {
        UserGuitar guitarToUpdate = userGuitarRepository.findById(Integer.parseInt(id)).orElse(null);

        if(guitarToUpdate == null) {
            return false;
        }
        guitarToUpdate.setGuitarName(newGuitarDetails.getGuitarName());
        guitarToUpdate.setGuitarPrice(newGuitarDetails.getGuitarPrice());
        guitarToUpdate.setGuitarDescription(newGuitarDetails.getGuitarDescription());
        guitarToUpdate.setGuitarPicUrl(newGuitarDetails.getGuitarPicUrl());
        userGuitarRepository.save(guitarToUpdate);

        return true;
        }
}
