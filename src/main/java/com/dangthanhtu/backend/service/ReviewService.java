package com.dangthanhtu.backend.service;

import java.util.List;

import com.dangthanhtu.backend.payloads.ReviewDTO;
import com.dangthanhtu.backend.payloads.ReviewResponse;

public interface ReviewService {
    List<ReviewDTO> getReviewsByProductId(Long productId);
    ReviewResponse getReviewsByProductId(Long productId, Integer pageNumber, Integer pageSize, String sortBy, String sortOrder);
    ReviewDTO createReview(Long userId, Long productId, int rating, String comment, String userName);
    ReviewDTO updateReview(Long reviewId, int rating, String comment);
    void deleteReview(Long reviewId);
    ReviewDTO getReviewByUserIdAndProductId(Long userId, Long productId);
}
