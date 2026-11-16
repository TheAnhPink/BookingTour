package iuh.fit.backend.repository;

import iuh.fit.backend.entity.AnhTour;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnhTourRepository extends JpaRepository<AnhTour, Long> {
    public List<AnhTour> findByTour_MaTour(Long maTour);
}
