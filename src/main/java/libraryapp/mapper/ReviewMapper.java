package libraryapp.mapper;

import libraryapp.dto.ReviewDtoOut;
import libraryapp.entity.Review;

public class ReviewMapper {

    public static ReviewDtoOut mapToDtoOut (Review review){
        return ReviewDtoOut.builder()
                .userId(review.getId())
                .date(review.getDate())
                .content(review.getContent())
                .rating(review.getRating())
                .book(review.getBook())
                .build();
    }

}
