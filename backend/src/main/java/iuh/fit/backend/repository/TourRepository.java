package iuh.fit.backend.repository;

import iuh.fit.backend.dto.response.TourDTO;
import iuh.fit.backend.entity.Tour;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

public interface TourRepository extends JpaRepository<Tour,Long> {
    @Query("select DISTINCT t from Tour t left join t.lichKhoiHanhs l " +
            "where t.trangThai = 'HOAT_DONG' " +
            "and (:tenTim is null or (lower(t.tenTour) like lower(concat('%',:tenTim,'%')) or (lower(t.diemDen) like lower((concat('%',:tenTim,'%') )) ) ) ) "+
            "and (:maLoaiTim is null or t.loaiTour.maLoaiTour= :maLoaiTim) " +
            "and (:giaMin is null or t.giaNguoiLon >= :giaMin) " +
            "and (:giaMax is null or t.giaNguoiLon <= :giaMax) " +
            "and (:ngayKH is null or cast(l.ngayKhoiHanh as date) >= :ngayKH) " +
            "and (:ngayKT is null or cast (l.ngayKhoiHanh as date) <= :ngayKT)")
    public Page<Tour> getTours(@Param("tenTim") String tenTim,
                                  @Param("maLoaiTim") Long maLoaiTim,
                                  @Param("giaMin") BigDecimal giaMin,
                                  @Param("giaMax") BigDecimal giaMax,
                                  @Param("ngayKH")LocalDate ngayKH,
                                  @Param("ngayKT") LocalDate ngayKT,
                                  Pageable pageable
                                  );

    Optional<Tour> findFirstByHinhAnhChinhIsNotNullOrderByMaTourDesc();
}
