package com.example.springjwt.controller;

import com.example.springjwt.dto.BookDTO;
import com.example.springjwt.service.RentalService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/api")
public class RentalController {

    @Autowired
    private final RentalService rentalService;


    public RentalController(RentalService rentalService) {
        this.rentalService = rentalService;
    }

    @PostMapping("/rent")
    public ResponseEntity<String> rentBook(@RequestBody Map<String, String> request) {
        String title = request.get("title");
        rentalService.rentBookByTitle(title);
        return ResponseEntity.ok("대여 처리가 완료되었습니다.");
    }
}
