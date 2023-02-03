package libraryapp.service;

import libraryapp.dto.BorrowEventElementDtoIn;
import libraryapp.entity.Book;
import libraryapp.entity.BorrowEventElement;
import libraryapp.repository.BookRepository;
import libraryapp.repository.BorrowEventElementRepository;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

public class JpaBorrowEventElementService implements BorrowEventElementService{

    private final BorrowEventElementRepository eventElementRepository;
    private final BookRepository bookRepository;

    public JpaBorrowEventElementService(BorrowEventElementRepository eventElementRepository, BookRepository bookRepository) {
        this.eventElementRepository = eventElementRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public BorrowEventElement add(BorrowEventElementDtoIn newElement) {
        Book book = bookRepository.getReferenceById(newElement.getBookId());
        if(book.getQuantity()>= newElement.getBookAmount()){
        BorrowEventElement element = BorrowEventElement.builder()
                .book(Book.builder()
                        .id(newElement.getBookId())
                        .build())
                .bookAmount(newElement.getBookAmount())
                .startDate(newElement.getStartDate())
                .endDate(newElement.getEndDate())
                .isReturned(false)
                .build();

        book.setQuantity(book.getQuantity()- newElement.getBookAmount());
        return eventElementRepository.save(element);
    }else throw new RuntimeException("Brak wymaganej ilości książki"+ book.getTitle());
    }

    @Override
    public void delete(UUID eventElementId) {
    eventElementRepository.deleteById(eventElementId);
    }

    @Override
    public Optional<BorrowEventElement> update(UUID eventElementId, BorrowEventElementDtoIn updatedElement) {
                eventElementRepository.findById(eventElementId)
                .ifPresent(b->{b.setBook(Book.builder()
                                        .id(updatedElement.getBookId())
                                        .build());
                    b.setBookAmount(updatedElement.getBookAmount());
                    b.setStartDate(updatedElement.getStartDate());
                    b.setEndDate(updatedElement.getEndDate());
                b.setIsReturned(!b.getIsReturned());
                eventElementRepository.save(b);});
        return Optional.empty();
    }

    @Override
    public Optional<BorrowEventElement> updateEndDate(UUID eventElementId, LocalDate newEndDate) {
        return Optional.empty();
    }

    @Override
    public Optional<BorrowEventElement> findByid(UUID eventId) {
        return Optional.empty();
    }
}
