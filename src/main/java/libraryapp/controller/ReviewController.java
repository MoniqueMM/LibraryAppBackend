package libraryapp.controller;

import libraryapp.entity.Review;
import libraryapp.service.ReviewService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {

    private ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/all")
    public Iterable<Review> getAll() {
        return reviewService.findAllReviews();
    }

    @GetMapping
    public Optional<Review> getById(@RequestParam UUID id) {
        return reviewService.findById(id);
    }

    @PostMapping
    public Review addReview(@RequestBody Review review) {
        return reviewService.addReview(review);
    }

    @PutMapping
    public Review updateReview(@RequestBody Review review) {
        return reviewService.addReview(review);
    }

    @DeleteMapping
    public void deleteReview(@RequestParam UUID id) {
        reviewService.deleteById(id);
    }
}
