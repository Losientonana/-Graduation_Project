package com.example.springjwt.repository;

import com.example.springjwt.entity.RentalEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface RentalRepository extends JpaRepository<RentalEntity, Long> {
    Optional<RentalEntity> findByBookIdAndRentalState(Long bookId, Boolean rentalState);
}
