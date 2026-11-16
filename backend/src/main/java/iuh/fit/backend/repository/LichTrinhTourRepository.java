package iuh.fit.backend.repository;

import iuh.fit.backend.entity.LichTrinhTour;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LichTrinhTourRepository extends JpaRepository<LichTrinhTour, Long> {
    public List<LichTrinhTour> findByTour_MaTourOrderByNgayThuAsc(Long maTour);
}
