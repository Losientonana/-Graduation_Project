package com.example.springjwt.service;

import com.example.springjwt.dto.BookDTO;
import com.example.springjwt.entity.BookEntity;
import com.example.springjwt.entity.RentalEntity;
import com.example.springjwt.entity.UserEntity;
import com.example.springjwt.repository.BookRepository;
import com.example.springjwt.repository.RentalRepository;
import com.example.springjwt.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookRentalService {


    private final RentalRepository rentalRepository;
    private final BookRepository bookRepository;

    public BookRentalService(RentalRepository rentalRepository,BookRepository bookRepository) {
        this.rentalRepository = rentalRepository;
        this.bookRepository = bookRepository;
    }

    @Transactional
    public boolean rentBook(Long userId, Long bookId) {
        Optional<RentalEntity> existingRental = rentalRepository.findByBookIdAndRentalState(bookId,true);
        if (existingRental.isPresent()) {
            // 이미 대여 중인 경우
            return false;
        }

        // 책 대여 로직
        RentalEntity newRental = new RentalEntity();
        newRental.setUserId(userId);
        newRental.setBookId(bookId);
        newRental.setRentalState(false);
        rentalRepository.save(newRental);

        return true;
    }
}


