package com.dangthanhtu.backend.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.dangthanhtu.backend.entity.Review;

import java.util.List;
import java.util.Optional;

public interface ReviewRepo extends JpaRepository<Review, Long> {
    // Tìm review theo productId (không phân trang)
    List<Review> findByProductId(Long productId);

    // Tìm review theo productId với phân trang
    Page<Review> findByProductId(Long productId, Pageable pageable);

    
    Optional<Review> findByUserIdAndProductId(Long userId, Long productId);

}
