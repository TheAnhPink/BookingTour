package iuh.fit.backend.service;

import iuh.fit.backend.dto.response.ChiTietTourDTO;
import iuh.fit.backend.dto.response.TourDTO;
import iuh.fit.backend.entity.Tour;
import org.springframework.data.domain.Page;

import java.math.BigDecimal;
import java.time.LocalDate;


public interface TourService {
    Page<TourDTO> getTours(String tenTim, Long maLoaiTim, BigDecimal giaMin,
                                  BigDecimal giaMax, LocalDate ngayKH, LocalDate ngayKT,
                                  int trang, int size);
    ChiTietTourDTO getChiTietTour(Long maTour);
    Tour save(Tour t);
    boolean delete(Long maTour);
}