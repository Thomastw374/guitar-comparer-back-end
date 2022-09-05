package com.example.guitarsuggester;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuitarSuggesterRepository extends JpaRepository<Guitar, Integer> {
}
