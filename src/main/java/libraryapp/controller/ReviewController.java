package libraryapp.controller;

import libraryapp.dto.ReviewDtoIn;
import libraryapp.dto.ReviewDtoOut;
import libraryapp.entity.Review;
import libraryapp.mapper.ReviewMapper;
import libraryapp.service.ReviewService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {

    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @PostMapping
    public ResponseEntity<Review> add(@RequestBody ReviewDtoIn reviewDtoIn) {
        final Review review = reviewService.add(reviewDtoIn);
        return ResponseEntity.status(HttpStatus.OK).body(review);
    }

    @GetMapping("{id}")
    public ResponseEntity<ReviewDtoOut> findById(@PathVariable UUID id) {
        final Optional<Review> optionalReview = reviewService.findById(id);
        return optionalReview.map(review -> ResponseEntity.ok(ReviewMapper.mapToDtoOut(review)))
                .orElseGet(() -> ResponseEntity.of(Optional.empty()));
    }

    @GetMapping("{userId}")
    public List<ReviewDtoOut> findByUserId(@PathVariable UUID userId){
        return reviewService.findByUserId(userId).stream()
                .map(ReviewMapper::mapToDtoOut)
                .collect(Collectors.toList());
    }

    @GetMapping("{bookId}")
    public List<ReviewDtoOut> findByBookId(@PathVariable UUID bookId){
        return reviewService.findByBookId(bookId).stream()
                .map(ReviewMapper::mapToDtoOut)
                .collect(Collectors.toList());
    }

    @DeleteMapping
    public void deleteById (@RequestParam UUID reviewId){
        reviewService.deleteById(reviewId);
    }

    @PatchMapping("{reviewId}")
    public void updateContent(@PathVariable UUID reviewId, @RequestParam String content){
        reviewService.updateContent(reviewId,content);
    }

    @GetMapping
    public List<ReviewDtoOut> findAll(){
        return reviewService.findAll().stream()
                .map(ReviewMapper::mapToDtoOut)
                .collect(Collectors.toList());
    }

}
