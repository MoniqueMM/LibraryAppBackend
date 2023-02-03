package libraryapp.service;

import libraryapp.dto.ReviewDtoIn;
import libraryapp.entity.Review;
import libraryapp.repository.ReviewRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ReviewService implements IReviewService {

    private final ReviewRepository reviewRepository;

    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }


    @Override
    public Review add(ReviewDtoIn newReview) {
        Review review = Review.builder()
                .user(newReview.getUser())
                .date(LocalDate.now())
                .content(newReview.getContent())
                .rating(newReview.getRating())
                .book(newReview.getBook())
                .build();
        return reviewRepository.save(review);
    }

    @Override
    public Optional<Review> findById(UUID reviewId) {
        return reviewRepository.findById(reviewId);
    }

    @Override
    public Optional<Review> findByUserId(UUID userId) {
        return reviewRepository.findByUserId(userId);
    }

    @Override
    public void deleteById(UUID reviewId) {
        reviewRepository.deleteById(reviewId);
    }

    @Override
    public void updateContent(UUID reviewId, String content) {
        Optional<Review> updatedReview = reviewRepository.findById(reviewId);
        if (updatedReview.isPresent()) {
            Review review = updatedReview.get();
            review.setContent(content);
            reviewRepository.save(review);
        }

    }

    @Override
    public Optional<Review> findByBookId(UUID bookId) {
        return reviewRepository.findByBookId(bookId);
    }

    @Override
    public List<Review> findAll() {
        return reviewRepository.findAll();
    }
}
