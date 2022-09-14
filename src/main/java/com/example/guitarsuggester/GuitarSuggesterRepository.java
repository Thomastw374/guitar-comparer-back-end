package com.example.guitarsuggester;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GuitarSuggesterRepository extends JpaRepository<Guitar, Integer> {
    @Query(value = "SELECT e FROM Guitar e ORDER BY guitar_price ASC")
    public List<Guitar> findAllSortedByPriceAsc();

    @Query(value = "SELECT e FROM Guitar e ORDER BY guitar_price DESC")
    public List<Guitar> findAllSortedByPriceDesc();

    @Query(value = "SELECT e FROM Guitar e ORDER BY guitar_name ASC")
    public List<Guitar> findAllSortedByNameAsc();

    @Query(value = "SELECT e FROM Guitar e ORDER BY guitar_name DESC")
    public List<Guitar> findAllSortedByNameDesc();

}
