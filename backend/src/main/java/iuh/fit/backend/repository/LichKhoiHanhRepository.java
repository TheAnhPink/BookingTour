package iuh.fit.backend.repository;

import iuh.fit.backend.entity.LichKhoiHanh;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LichKhoiHanhRepository extends JpaRepository<LichKhoiHanh, Long> {
    // join fetch la join va gắn khách sạn vào lịch khởi hành luôn
    @Query("select l from LichKhoiHanh l join fetch l.khachSan " +
            "where l.tour.maTour= :maTourTim and l.trangThai= 'DANG_MO_BAN'")
    List<LichKhoiHanh> findByMaTourVaDangMoBan(@Param("maTourTim") Long maTourTim);
}
