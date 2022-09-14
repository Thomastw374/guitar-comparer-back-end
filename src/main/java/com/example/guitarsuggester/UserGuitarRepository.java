package com.example.guitarsuggester;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserGuitarRepository extends JpaRepository<UserGuitar, Integer> {


}