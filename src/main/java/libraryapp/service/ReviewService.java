package libraryapp.service;

import libraryapp.entity.Review;
import libraryapp.repository.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class ReviewService {

    private ReviewRepository reviewRepository;

    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public Optional<Review> findById(UUID id){
        return reviewRepository.findById(id);
    }


    public Iterable<Review> findAllReviews(){
        return reviewRepository.findAll();
    }

    public Review addReview(Review review){
        return reviewRepository.save(review);
    }

    public void deleteById(UUID id){
        reviewRepository.deleteById(id);
    }

}
