package libraryapp.repository;

import libraryapp.entity.BorrowEventElement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BorrowEventElementRepository extends JpaRepository<BorrowEventElement, UUID> {
}
