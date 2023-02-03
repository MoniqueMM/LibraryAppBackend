package libraryapp.service;

import libraryapp.dto.ReviewDtoIn;
import libraryapp.entity.Review;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IReviewService {

    Review add(ReviewDtoIn newReview);

    Optional<Review> findById(UUID reviewId);

    Optional<Review> findByUserId(UUID userId);

    void deleteById(UUID reviewId);

    void updateContent(UUID reviewId, String content);

    Optional<Review> findByBookId(UUID bookId);
    List<Review> findAll();

}
