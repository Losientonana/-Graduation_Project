package com.example.springjwt.repository;

import com.example.springjwt.entity.ReservationEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservationRepository extends JpaRepository<ReservationEntity, Long> {

    List<ReservationEntity> findByBookIdOrderByReservationTimeAsc(Long bookId);
    boolean existsByBookId(Long bookId);

    @Transactional
    void deleteByUserId(Long id);

    List<ReservationEntity> findByUserId(Long userId);

    boolean existsByUserId(Long id);
}
