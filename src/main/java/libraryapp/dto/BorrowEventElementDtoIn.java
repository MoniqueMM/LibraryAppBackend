package libraryapp.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
@Builder

public class BorrowEventElementDtoIn {
    private LocalDate startDate;
    private LocalDate endDate;
    private UUID bookId;
    private Long bookAmount;

}
