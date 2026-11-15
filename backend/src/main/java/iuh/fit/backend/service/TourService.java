package iuh.fit.backend.service;

import iuh.fit.backend.entity.Tour;
import iuh.fit.backend.repository.TourRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;

@Service
public class TourService {
    private final TourRepository tourRepository;

    // Constructor injection (giữ nguyên style của bạn)
    public TourService(TourRepository tourRepository) {
        this.tourRepository = tourRepository;
    }

    public Page<Tour> getTours(String tenTim, Long maLoaiTim, BigDecimal giaMin,
                               BigDecimal giaMax, LocalDate ngayKH, LocalDate ngayKT,
                               int trang, int size) {

        // trang hiện tại, số phần tử, sắp xếp theo mã tour giảm dần
        Pageable pageable = PageRequest.of(trang, size, Sort.by("maTour").descending());

        // nếu rỗng hoặc toàn khoảng trắng thì gán null để Repo bỏ qua điều kiện này
        String searchKeyword = (tenTim != null && !tenTim.trim().isEmpty()) ? tenTim.trim() : null;


        return tourRepository.getTours(searchKeyword, maLoaiTim, giaMin, giaMax, ngayKH, ngayKT, pageable);
    }
}