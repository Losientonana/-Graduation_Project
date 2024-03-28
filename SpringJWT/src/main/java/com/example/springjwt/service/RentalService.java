package com.example.springjwt.service;

import com.example.springjwt.dto.BookDTO;
import com.example.springjwt.entity.BookEntity;
import com.example.springjwt.entity.UserEntity;
import com.example.springjwt.repository.BookRepository;
import com.example.springjwt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RentalService {
    @Autowired
    private BookRepository bookRepository;

    public void rentBookByTitle(String title) {
        BookEntity bookEntity = bookRepository.findByTitle(title)
                .orElseThrow(() -> new RuntimeException("책을 찾을 수 없습니다."));
        bookEntity.setRentalstate(false); // 대여 상태를 false로 업데이트
        bookRepository.save(bookEntity);

    }



}
