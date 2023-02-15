package libraryapp.repository;

import libraryapp.entity.BorrowEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface BorrowEventRepository extends JpaRepository<BorrowEvent, UUID> {

    Optional<BorrowEvent> findByUser_Id(UUID uuid);
}
