package iuh.fit.backend.repository;

import iuh.fit.backend.entity.Tour;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TourRepository extends JpaRepository<Tour,Long> {
}
