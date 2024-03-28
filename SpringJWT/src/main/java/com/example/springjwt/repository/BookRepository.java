package com.example.springjwt.repository;

import com.example.springjwt.entity.BookEntity;
import lombok.extern.java.Log;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookRepository extends JpaRepository<BookEntity, Long> {

    Optional<BookEntity> findByTitle(String title);
//    Boolean existsByTitle(String title);
//    Boolean existsByAuthor(String author);
//    Boolean existsByGenre(String genre);
//    Boolean existsByLocationInfo(String locationInfo);
//    Boolean existsByRentalState(Boolean rentalState);

}
